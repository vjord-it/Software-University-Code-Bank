#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  int successful_input = 0;
  char input_buffer[512];
  long num_count;

  if (fgets (input_buffer, sizeof (input_buffer), stdin))
    {
      char *invaid_input_part;
      errno = 0;
      num_count = strtol (input_buffer, &invaid_input_part, 10);

      if (!errno)
        {
          if (invaid_input_part != input_buffer)
            {
              if (invaid_input_part[0] != '.')
                {
                  successful_input = 1;
                }
              else
                {
                  fprintf (stderr, "error: Number isn't an integer\n");
                }
            }
          else
            {
              fprintf (stderr, "error: Invalid number given\n");
            }
        }
      else
        {
          if (errno == ERANGE)
            {
              fprintf (stderr, "error: Number is too big or too small\n");
            }
          else
            {
              fprintf (stderr, "error: Unknown error occurred (errno %d)\n", errno);
            }
        }
    }
  else
    {
      fprintf (stderr, "error: No input given\n");
    }

  double sum = 0;

  long num_index;
  for (num_index = 0;
       num_index < num_count;
       ++num_index)
    {
      char input_buffer[512];

      if (fgets (input_buffer, sizeof (input_buffer), stdin))
        {
          char *invaid_input_part;
          errno = 0;
          double num = strtod (input_buffer, &invaid_input_part);

          if (!errno)
            {
              if (invaid_input_part != input_buffer)
                {
                  successful_input = 1;
                  sum += num;
                }
              else
                {
                  fprintf (stderr, "error: Invalid number given\n");
                }
            }
          else
            {
              if (errno == ERANGE)
                {
                  fprintf (stderr, "error: Number size or precision is out of range\n");
                }
              else
                {
                  fprintf (stderr, "error: Unknown error occurred (errno %d)\n", errno);
                }
            }
        }
      else
        {
          fprintf (stderr, "error: No input given\n");
        }
    }


  printf ("%lf\n", sum);

  return !successful_input;
}
