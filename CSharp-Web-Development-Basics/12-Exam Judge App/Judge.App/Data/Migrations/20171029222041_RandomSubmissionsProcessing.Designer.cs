﻿// <auto-generated />
namespace Judge.App.Data.Migrations
{
    using Judge.App.Data;
    using Microsoft.EntityFrameworkCore;
    using Microsoft.EntityFrameworkCore.Infrastructure;
    using Microsoft.EntityFrameworkCore.Metadata;
    using Microsoft.EntityFrameworkCore.Migrations;

    [DbContext(typeof(JudgeDbContext))]
    [Migration("20171029222041_RandomSubmissionsProcessing")]
    partial class RandomSubmissionsProcessing
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "2.0.0-rtm-26452")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("Judge.App.Data.Models.Contest", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Name")
                        .IsRequired()
                        .HasMaxLength(100);

                    b.Property<int>("UserId");

                    b.HasKey("Id");

                    b.HasIndex("UserId");

                    b.ToTable("Contests");
                });

            modelBuilder.Entity("Judge.App.Data.Models.Submission", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<int>("Build");

                    b.Property<string>("Code")
                        .IsRequired();

                    b.Property<int>("ContestId");

                    b.Property<int>("UserId");

                    b.HasKey("Id");

                    b.HasIndex("ContestId");

                    b.HasIndex("UserId");

                    b.ToTable("Submissions");
                });

            modelBuilder.Entity("Judge.App.Data.Models.User", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Email")
                        .IsRequired()
                        .HasMaxLength(50);

                    b.Property<string>("FullName");

                    b.Property<bool>("IsAdmin");

                    b.Property<string>("Password")
                        .IsRequired()
                        .HasMaxLength(50);

                    b.HasKey("Id");

                    b.HasIndex("Email")
                        .IsUnique();

                    b.ToTable("Users");
                });

            modelBuilder.Entity("Judge.App.Data.Models.Contest", b =>
                {
                    b.HasOne("Judge.App.Data.Models.User", "User")
                        .WithMany("Contests")
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.Restrict);
                });

            modelBuilder.Entity("Judge.App.Data.Models.Submission", b =>
                {
                    b.HasOne("Judge.App.Data.Models.Contest", "Contest")
                        .WithMany("Submissions")
                        .HasForeignKey("ContestId")
                        .OnDelete(DeleteBehavior.Restrict);

                    b.HasOne("Judge.App.Data.Models.User", "User")
                        .WithMany("Submissions")
                        .HasForeignKey("UserId")
                        .OnDelete(DeleteBehavior.Restrict);
                });
#pragma warning restore 612, 618
        }
    }
}
