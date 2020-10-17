﻿using System;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using System.Xml;
using System.Xml.Serialization;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;
using Stations.Data;
using Stations.DataProcessor.Dto.Export;
using Stations.Models.Enums;
using Formatting = Newtonsoft.Json.Formatting;

namespace Stations.DataProcessor
{
    public class Serializer
    {
        public static string ExportDelayedTrains(StationsDbContext context, string dateAsString)
        {
            DateTime inputDate = DateTime.ParseExact(dateAsString, "dd/MM/yyyy", CultureInfo.InvariantCulture);

            TrainDto[] trains = context.Trains
                .Include(t => t.Trips)
                .Where(t => t.Trips.Any(tr => tr.Status == TripStatus.Delayed && tr.DepartureTime <= inputDate))
                .Select(t => new
                {
                    t.TrainNumber,
                    DelayedTrips = t.Trips.Where(tr => tr.Status == TripStatus.Delayed && tr.DepartureTime <= inputDate)
                        .ToArray()
                })
                .Select(t => new TrainDto
                {
                    TrainNumber = t.TrainNumber,
                    DelayedTimes = t.DelayedTrips.Length,
                    MaxDelayedTime = t.DelayedTrips.Max(tr => tr.TimeDifference)
                })
                .OrderByDescending(t => t.DelayedTimes)
                .ThenByDescending(t => t.MaxDelayedTime)
                .ThenBy(t => t.TrainNumber)
                .ToArray();

            string serializedTrains = JsonConvert.SerializeObject(trains, Formatting.Indented);
            return serializedTrains;
        }

        public static string ExportCardsTicket(StationsDbContext context, string cardType)
        {
            CardType type = Enum.Parse<CardType>(cardType);

            CardDto[] cards = context.Cards
                .Where(c => c.Type == type && c.BoughtTickets.Any())
                .Select(c => new CardDto
                {
                    Name = c.Name,
                    Type = c.Type.ToString(),
                    Tickets = c.BoughtTickets.Select(t => new TicketDto
                    {
                        OriginStation = t.Trip.OriginStation.Name,
                        DestinationStation = t.Trip.DestinationStation.Name,
                        DepartureTime = t.Trip.DepartureTime.ToString("dd/MM/yyyy HH:mm", CultureInfo.InvariantCulture)
                    })
                    .ToArray()
                })
                .ToArray();

            StringBuilder sb = new StringBuilder();
            XmlSerializer serializer = new XmlSerializer(typeof(CardDto[]), new XmlRootAttribute("Cards"));
            serializer.Serialize(new StringWriter(sb), cards, new XmlSerializerNamespaces(new[] { XmlQualifiedName.Empty }));

            string serializedCards = sb.ToString();
            return serializedCards;
        }
    }
}