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
  long x = strtol (input_buffer, &input_end, 10);
  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  long n_factorial = 1;
  long x_exp_sum = x;
  double sum = 1;
  sum += 1.0 / x;

  long iteration;
  for (iteration = 2;
       iteration <= n;
       ++iteration)
    {
      n_factorial *= iteration;
      x_exp_sum *= x;
      sum += (double) n_factorial / x_exp_sum;
    }

  printf ("%.5lf\n", sum);

  return 0;
}
