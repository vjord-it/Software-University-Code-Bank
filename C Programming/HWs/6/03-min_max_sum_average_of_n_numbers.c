#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[1024];
  char *input_begin = input_buffer;
  char *input_end;

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long nums_count = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  long sum = 0;
  long min;
  long max;

  long num_index;
  for (num_index = 0;
       num_index < nums_count;
       ++num_index)
    {
      char input_buffer[1024];
      char *input_begin = input_buffer;
      char *input_end;

      if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
        {
          fprintf (stderr, "error: No input given\n");
          return 1;
        }

      errno = 0;
      long num = strtol (input_begin, &input_end, 10);
      if (errno || input_end == input_begin || input_end[0] == '.')
        {
          fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
          return 1;
        }

      sum += num;

      if (num_index == 0)
        {
          min = num;
          max = num;
        }
      else
        {
          min = num < min ? num : min;
          max = num > max ? num : max;
        }
    }

  double avg = (double) sum / nums_count;

  printf ("min = %ld\n", min);
  printf ("max = %ld\n", max);
  printf ("sum = %ld\n", sum);
  printf ("avg = %.2lf\n", avg);

  return 0;
}
