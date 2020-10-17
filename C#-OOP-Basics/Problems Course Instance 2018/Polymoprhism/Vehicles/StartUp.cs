using System;
using System.Reflection;

public class StartUp
{
    public static void Main()
    {
        string[] carParams = Console.ReadLine().Split();
        Car car = new Car(double.Parse(carParams[1]), double.Parse(carParams[2]));

        string[] truckParams = Console.ReadLine().Split();
        Truck truck = new Truck(double.Parse(truckParams[1]), double.Parse(truckParams[2]));

        int n = int.Parse(Console.ReadLine());

        for (int i = 0; i < n; i++)
        {
            string[] inputCmds = Console.ReadLine().Split();

            Vehicle vehicle = null;

            if (inputCmds[1] == "Car")
            {
                vehicle = car;
            }
            else if (inputCmds[1] == "Truck")
            {
                vehicle = truck;
            }

            Type theType = vehicle.GetType();
            MethodInfo theMethod = theType.GetMethod(inputCmds[0]);
            object[] methodParams = new object[] { double.Parse(inputCmds[2]) };
            object result = theMethod.Invoke(vehicle, methodParams);
            if (result != null)
            {
                Console.WriteLine(result);
            }
        }

        Console.WriteLine($"Car: {car.Fuel:f2}");
        Console.WriteLine($"Truck: {truck.Fuel:f2}");
    }
}