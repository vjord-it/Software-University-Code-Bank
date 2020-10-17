#include <stdio.h>
#include <stdlib.h>
#include <errno.h>


int
main (int argc, char *argv[])
{
  char input_buffer[512];
  int successful_input = 1;

  long a;
  printf ("integer a (between 0 and 500): ");

  if (fgets (input_buffer, sizeof (input_buffer), stdin))
    {
      char *invaid_input_part;
      errno = 0;
      a = strtol (input_buffer, &invaid_input_part, 10);

      if (!errno)
        {
          if (invaid_input_part != input_buffer)
            {
              if (invaid_input_part[0] != '.')
                {
                  if (a < 0 || a > 500)
                    {
                      fprintf (stderr, "error: Number must be between 0 and 500\n");
                      successful_input = 0;
                    }
                }
              else
                {
                  fprintf (stderr, "error: Number isn't an integer\n");
                  successful_input = 0;
                }
            }
          else
            {
              fprintf (stderr, "error: Invalid number given\n");
              successful_input = 0;
            }
        }
      else
        {
          if (errno == ERANGE)
            {
              fprintf (stderr, "error: Number is too big or too small\n");
              successful_input = 0;
            }
          else
            {
              fprintf (stderr, "error: Unknown error occurred (errno %d)\n", errno);
              successful_input = 0;
            }
        }
    }
  else
    {
      fprintf (stderr, "error: No input given\n");
      successful_input = 0;
    }


  double b;

  if (successful_input)
    {
      printf ("real b: ");
      if (fgets (input_buffer, sizeof (input_buffer), stdin))
        {
          char *invaid_input_part;
          errno = 0;
          b = strtod (input_buffer, &invaid_input_part);

          if (!errno)
            {
              if (invaid_input_part == input_buffer)
                {
                  fprintf (stderr, "error: Invalid number given\n");
                  successful_input = 0;
                }
            }
          else
            {
              if (errno == ERANGE)
                {
                  fprintf (stderr, "error: Number has too may digits\n");
                  successful_input = 0;
                }
              else
                {
                  fprintf (stderr, "error: Unknown error occurred (errno %d)\n", errno);
                  successful_input = 0;
                }
            }
        }
      else
        {
          fprintf (stderr, "error: No input given\n");
          successful_input = 0;
        }
    }

  double c;

  if (successful_input)
    {
      printf ("real c: ");
      if (fgets (input_buffer, sizeof (input_buffer), stdin))
        {
          char *invaid_input_part;
          errno = 0;
          c = strtod (input_buffer, &invaid_input_part);

          if (!errno)
            {
              if (invaid_input_part == input_buffer)
                {
                  fprintf (stderr, "error: Invalid number given\n");
                  successful_input = 0;
                }
            }
          else
            {
              if (errno == ERANGE)
                {
                  fprintf (stderr, "error: Number has too may digits\n");
                  successful_input = 0;
                }
              else
                {
                  fprintf (stderr, "error: Unknown error occurred (errno %d)\n", errno);
                  successful_input = 0;
                }
            }
        }
      else
        {
          fprintf (stderr, "error: No input given\n");
          successful_input = 0;
        }
    }


  if (successful_input)
    {
      /* The same result can be done with a loop, but the way I did it
         is much clearer and should require less processor operations
         and processor time. */

      char binary_a[11];
      binary_a[0] = (a & 0b1000000000) ? '1' : '0';
      binary_a[1] = (a & 0b0100000000) ? '1' : '0';
      binary_a[2] = (a & 0b0010000000) ? '1' : '0';
      binary_a[3] = (a & 0b0001000000) ? '1' : '0';
      binary_a[4] = (a & 0b0000100000) ? '1' : '0';
      binary_a[5] = (a & 0b0000010000) ? '1' : '0';
      binary_a[6] = (a & 0b0000001000) ? '1' : '0';
      binary_a[7] = (a & 0b0000000100) ? '1' : '0';
      binary_a[8] = (a & 0b0000000010) ? '1' : '0';
      binary_a[9] = (a & 0b0000000001) ? '1' : '0';
      binary_a[10] = 0;

      printf ("|%-10lX|%s|%10.2f|%-10.3f|\n",
              a, binary_a, b, c);
    }

  return !successful_input;
}
