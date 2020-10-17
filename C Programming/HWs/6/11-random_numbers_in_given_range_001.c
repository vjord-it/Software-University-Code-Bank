#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>


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


  printf ("min: ");
  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long min = strtol (input_buffer, &input_end, 10);

  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  printf ("max: ");
  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long max = strtol (input_buffer, &input_end, 10);

  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  srand(time(NULL));

  long num_index;
  for (num_index = 0;
       num_index < n;
       ++num_index)
    {
      int rand_num = (rand() % (max - min + 1)) + min;
      printf ("%d\n", rand_num);
    }


  return 0;
}
