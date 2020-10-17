#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[4096];
  char *input_end;


  printf ("n: ");
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


  int exponent_product = 1;
  int trailing_zeros_total = 0;
  int trailing_zeros = 0;

  do
    {
      exponent_product *= 5;
      trailing_zeros = n / exponent_product;
      trailing_zeros_total += trailing_zeros;
    }
  while (trailing_zeros);

  printf ("%d\n", trailing_zeros_total);

  return 0;
}
