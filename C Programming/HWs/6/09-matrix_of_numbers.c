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


  int row;
  for (row = 1;
       row <= n;
       ++row)
    {
      int col;
      for (col = row;
           col < n + row;
           ++col)
        {
          printf ("%d ", col);
        }

      printf ("\n");
    }

  return 0;
}
