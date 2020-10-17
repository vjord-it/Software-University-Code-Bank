#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[2048];

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  char *input_begin = input_buffer;
  char *input_end;

  errno = 0;
  double a = strtod (input_begin, &input_end);
  if (errno || input_end == input_begin)
    {
      fprintf (stderr, "error: Invalid number given (errno: %d)\n", errno);
      return 1;
    }
  input_begin = input_end;

  errno = 0;
  double b = strtod (input_begin, &input_end);
  if (errno || input_end == input_begin)
    {
      fprintf (stderr, "error: Invalid number given (errno: %d)\n", errno);
      return 1;
    }
  input_begin = input_end;

  errno = 0;
  double c = strtod (input_begin, &input_end);
  if (errno || input_end == input_begin)
    {
      fprintf (stderr, "error: Invalid number given (errno: %d)\n", errno);
      return 1;
    }

  printf ("| %5.2lf | %5.2lf | %5.2lf | ", a, b, c);

  if (a > b && a > c)
    {
      if (b > c)
        {
          printf ("%5.2lf  %5.2lf  %5.2lf |\n", a, b, c);
        }
      else
        {
          printf ("%5.2lf  %5.2lf  %5.2lf |\n", a, c, b);
        }
    }
  else if (b > a && b > c)
    {
      if (a > c)
        {
          printf ("%5.2lf  %5.2lf  %5.2lf |\n", b, a, c);
        }
      else
        {
          printf ("%5.2lf  %5.2lf  %5.2lf |\n", b, c, a);
        }
    }
  else
    {
      if (a > b)
        {
          printf ("%5.2lf  %5.2lf  %5.2lf |\n", c, a, b);
        }
      else
        {
          printf ("%5.2lf  %5.2lf  %5.2lf |\n", c, b, a);
        }
    }

  return 0;
}
