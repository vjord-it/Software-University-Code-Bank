﻿namespace LearningSystem.Services.Admin.Models
{
    using Common.Mapping;
    using Data.Models;
    using System.Collections.Generic;
    using AutoMapper;

    public class AdminUserListingServiceModel : IMapFrom<User>
    {
        public string Id { get; set; }

        public string Username { get; set; }

        public string Email { get; set; }

        public string Name { get; set; }

    }
}
