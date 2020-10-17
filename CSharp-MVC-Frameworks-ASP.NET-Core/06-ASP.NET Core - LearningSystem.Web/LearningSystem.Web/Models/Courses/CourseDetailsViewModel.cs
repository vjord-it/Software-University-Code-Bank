﻿namespace LearningSystem.Web.Models.Courses
{
    using Services.Models;

    public class CourseDetailsViewModel
    {
        public CourseDetailsServiceModel Course { get; set; }

        public bool IsUserEnrolledInCourse { get; set; }
    }
}
