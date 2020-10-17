#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  int successful_input = 0;
  char input_buffer[512];

  long num_start;

  if (fgets (input_buffer, sizeof (input_buffer), stdin))
    {
      char *invaid_input_part;
      errno = 0;
      num_start = strtol (input_buffer, &invaid_input_part, 10);

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


  if (successful_input)
    {
      successful_input = 0;

      if (fgets (input_buffer, sizeof (input_buffer), stdin))
        {
          char *invaid_input_part;
          errno = 0;
          long num_end = strtol (input_buffer, &invaid_input_part, 10);

          if (!errno)
            {
              if (invaid_input_part != input_buffer)
                {
                  if (invaid_input_part[0] != '.')
                    {
                      successful_input = 1;

                      long num;
                      for (num = num_start;
                           num <= num_end;
                           ++num)
                        {
                          if (!(num % 5))
                            {
                              printf ("%ld ", num);
                            }
                        }

                      printf ("\n");
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
    }

  return !successful_input;
}
