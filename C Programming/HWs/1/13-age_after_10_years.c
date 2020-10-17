#include <stdio.h>
#include <time.h>


int
main (int argc, char *argv[])
{
  time_t current_epoch_time = time(NULL);
  struct tm *current_time = localtime (&current_epoch_time);
  int current_day = current_time->tm_mday;
  int current_year = current_time->tm_year + 1900;
  int current_month = current_time->tm_mon + 1;

  int birth_day;
  int birth_month;
  int birth_year;
  printf ("Your birthday in D.M.Y format: ");

  /*
   * Maybe I should use strptime here instead of scanf, but strptime
   * isn't part of the C standard library.
   */

  if (3 == scanf ("%u.%u.%u", &birth_day, &birth_month, &birth_year))
    {
      if (birth_day >= 1 && birth_day <= 31 &&
          birth_month >= 1 && birth_month <= 12)
        {
          int years_old = current_year - birth_year;

          if (current_month < birth_month ||
              (current_month == birth_month &&
               current_day < birth_day))
            {
              --years_old;
            }

          printf ("Now: %d\n", years_old);
          printf ("After 10 years: %d\n", years_old + 10);
        }
      else
        {
          fprintf (stderr, "error: Invalid date\n");
        }
    }
  else
    {
      fprintf (stderr, "error: Invalid date format\n");
    }

  return 0;
}
