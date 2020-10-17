#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[4096];
  char *input_end;


  printf ("a: ");
  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long a = strtol (input_buffer, &input_end, 10);

  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  printf ("b: ");
  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long b = strtol (input_buffer, &input_end, 10);

  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  while (b)
    {
      long tmp = a;
      a = b;
      b = tmp % b;
    }

  printf ("%ld\n", a < 0 ? -a : a);

  return 0;
}
