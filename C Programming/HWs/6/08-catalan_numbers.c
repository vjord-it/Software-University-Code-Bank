#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[1024];
  char *input_end;

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long n = strtol (input_buffer, &input_end, 10);
  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  long double n_factorial = 1;
  long double n_plus_1_factorial = 1;
  long double n_times_2_factorial = 1;

  {
    long iteration;
    for (iteration = 1;
         iteration <= (n + n);
         ++iteration)
      {
        if (iteration <= n)
          {
            n_factorial *= iteration;
          }

        if (iteration <= n + 1)
          {
            n_plus_1_factorial *= iteration;
          }

        n_times_2_factorial *= iteration;
      }
  }

  /* printf ("n!:     %Lf\n", n_factorial); */
  /* printf ("(n+1)!: %Lf\n", n_plus_1_factorial); */
  /* printf ("(2n)!:  %Lf\n", n_times_2_factorial); */

  long double result = n_times_2_factorial / (n_plus_1_factorial * n_factorial);

  printf ("%Lf\n", result);

  return 0;
}
