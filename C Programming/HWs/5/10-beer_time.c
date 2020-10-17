#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[12];

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  char *input_begin = input_buffer;
  char *input_end;


  /* GET HOURS */
  errno = 0;
  long hour = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || hour < 1 || hour > 12)
    {
      fprintf (stderr, "error: Invalid hour time given\n");
      return 1;
    }
  input_begin = input_end;


  if (input_begin[0] != ':')
    {
      fprintf (stderr, "error: Missing ':' after hour time\n");
      printf ("invalid time\n");
      return 1;
    }
  ++input_begin;


  /* GET MINUTES */
  errno = 0;
  long minutes = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || minutes < 0 || minutes > 59)
    {
      fprintf (stderr, "error: Invalid minutes time given\n");
      printf ("invalid time\n");
      return 1;
    }
  input_begin = input_end;


  if (input_begin[0] != ' ')
    {
      fprintf (stderr, "error: Missing space after minutes time\n");
      printf ("invalid time\n");
      return 1;
    }
  ++input_begin;


  /* GET AM/PM */
  int before_midday;

  switch (input_begin[0])
    {
    case 'A':
      {
        before_midday = 1;
        break;
      }
    case 'P':
      {
        before_midday = 0;
        break;
      }
    default:
      {
        fprintf (stderr, "error: Invalid AM/PM string\n");
        printf ("invalid time\n");
        return 1;
      }
    }
  ++input_begin;

  if (input_begin[0] != 'M' || input_begin[1] > ' ')
    {
      fprintf (stderr, "error: Invalid AM/PM string\n");
      printf ("invalid time\n");
      return 1;
    }


  /* printf ("%02ld:%02ld %cM: ", */
  /*         hour, */
  /*         minutes, */
  /*         before_midday ? 'A' : 'P'); */


  if ((before_midday && (hour < 3 || hour == 12)) ||
      (!before_midday && (hour >= 1 && hour != 12)))
    {
      printf ("beer time\n");
    }
  else
    {
      printf ("non-beer time\n");
    }

  return 0;
}
