#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[4096];
  char *input_end;

  printf ("decimal: ");
  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long decimal_input = strtol (input_buffer, &input_end, 10);

  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  if (decimal_input)
    {
      char output_buffer[sizeof (decimal_input) * 8] = {};
      int output_index = 0;

      while (decimal_input)
        {
          output_buffer[output_index++] = '0' + (decimal_input % 2);
          decimal_input /= 2;
        }

      while (output_index--)
        {
          printf ("%c", output_buffer[output_index]);
        }
    }
  else
    {
      printf ("0");
    }

  printf ("\n");


  return 0;
}
