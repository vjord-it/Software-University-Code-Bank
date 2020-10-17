﻿namespace SimpleMvc.Framework
{
    using System;
    using System.Reflection;
    using WebServer;

    public static class MvcEngine
    {
        public static void Run(WebServer server)
        {
            RegisterAssemblyName();

            try
            {
                server.Run();
            }
            catch (Exception e)
            {
                // Log errors
                Console.WriteLine(e.Message);
            }
        }

        private static void RegisterAssemblyName()
        {
            MvcContext.Get.AssemblyName = Assembly
                                         .GetEntryAssembly()
                                         .GetName()
                                         .Name;
        }
    }
}
