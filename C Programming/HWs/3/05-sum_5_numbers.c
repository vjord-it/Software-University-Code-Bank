#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


#define NUMBERS_COUNT 5


int
main (int argc, char *argv[])
{
  int exit_status = 1;

  double sum;
  char input_buffer[512];
  int input_numbers_count = 0;
  int valid_input = 1;

  if (fgets (input_buffer, sizeof (input_buffer), stdin))
    {
      char *input_field_start = input_buffer;
      char *input_field_end;

      while (valid_input)
        {
          errno = 0;
          double input_number = strtod (input_field_start, &input_field_end);

          if (!errno)
            {
              if (input_field_start != input_field_end)
                {
                  ++input_numbers_count;
                  sum += input_number;
                  input_field_start = input_field_end;
                }
              else
                {
                  break;
                }
            }
          else
            {
              valid_input = 0;

              if (errno == ERANGE)
                {
                  fprintf (stderr, "error: Number is out of range\n");
                }
              else
                {
                  fprintf (stderr, "error: Unknown error occurred (errno %d)\n", errno);
                }
            }
        }

      if (valid_input)
        {
          if (input_numbers_count == NUMBERS_COUNT)
            {
              printf ("%lf\n", sum);
              exit_status = 0;
            }
          else
            {
              fprintf (stderr, "error: You must supply exactly 5 numbers\n");
            }
        }
    }
  else
    {
      fprintf (stderr, "error: No input given\n");
    }

  return exit_status;
}
