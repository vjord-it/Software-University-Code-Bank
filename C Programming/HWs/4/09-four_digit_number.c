#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  int successful_input = 0;
  char input_buffer[512];

  if (fgets (input_buffer, sizeof (input_buffer), stdin))
    {
      char *input_end;
      errno = 0;
      long num = strtol (input_buffer, &input_end, 10);

      if (!errno)
        {
          if (input_end != input_buffer)
            {
              if (input_end[0] != '.')
                {
                  if (num >= 1000 && num <= 9999)
                    {
                      char num1 = num % 10;
                      char num2 = (num / 10) % 10;
                      char num3 = (num / 100) % 10;
                      char num4 = (num / 1000) % 10;

                      int sum = num1 + num2 + num3 + num4;
                      int reversed = (num1 * 1000 +
                                      num2 * 100 +
                                      num3 * 10 +
                                      num4);

                      int last_in_front = (num1 * 1000 +
                                           num4 * 100 +
                                           num3 * 10 +
                                           num2);

                      int second_and_third_swapped = (num4 * 1000 +
                                                      num2 * 100 +
                                                      num3 * 10 +
                                                      num1);

                      printf ("n: %4ld,  ", num);
                      printf ("sum: %4d,  ", sum);
                      printf ("reversed: %4d,  ", reversed);
                      printf ("last_in_front: %4d,  ", last_in_front);
                      printf ("2nd_and_3rd_swapped: %4d\n", second_and_third_swapped);
                    }
                  else
                    {
                      fprintf (stderr, "error: Number must be 4 digit long\n");
                    }
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


  return !successful_input;
}
