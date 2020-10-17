#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[4096];
  char *input_begin = input_buffer;
  char *input_end;

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }


  int odd_product = 1;
  int even_product = 1;
  int odd_position;

  for (odd_position = 1;
       ;
       odd_position = !odd_position)
    {
      errno = 0;
      long num = strtol (input_begin, &input_end, 10);

      if (errno || input_end[0] == '.')
        {
          fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
          return 1;
        }
      else if (input_end == input_begin)
        {
          break;
        }

      input_begin = input_end;

      if (odd_position)
        {
          odd_product *= num;
        }
      else
        {
          even_product *= num;
        }
    }

  if (odd_product == even_product)
    {
      printf ("yes\n");
      printf ("product = %d\n", odd_product);
    }
  else
    {
      printf ("no\n");
      printf ("odd product = %d\n", odd_product);
      printf ("even product = %d\n", even_product);
    }

  return 0;
}
