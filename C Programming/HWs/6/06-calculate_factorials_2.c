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


  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long k = strtol (input_buffer, &input_end, 10);
  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  long max = n > k ? n : k;
  long n_factorial = 1;
  long k_factorial = 1;

  long iteration;
  for (iteration = 1;
       iteration <= max;
       ++iteration)
    {
      if (iteration <= n)
        {
          n_factorial *= iteration;
        }

      if (iteration <= k)
        {
          k_factorial *= iteration;
        }
    }

  double result = (double) n_factorial / k_factorial;

  printf ("n!/k!: %lf\n", result);

  return 0;
}
