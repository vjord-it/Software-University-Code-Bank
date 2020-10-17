#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define INITIAL_READ_LINE_BUFFER_SIZE 64


char *
read_line (void)
{
  char *buffer = malloc (INITIAL_READ_LINE_BUFFER_SIZE + 1);

  if (!buffer)
    {
      fprintf (stderr, "error: Failed to allocate memory\n");
      exit (1);
    }

  char *buffer_p = buffer;
  size_t buffer_size = INITIAL_READ_LINE_BUFFER_SIZE;
  size_t read_size = buffer_size;
  size_t len;

  while (1)
    {
      buffer[buffer_size] = 1;

      if (!(fgets (buffer_p, read_size + 1, stdin)) || buffer[buffer_size])
        {
          len = buffer_size - read_size + strnlen (buffer_p, read_size + 1);
          break;
        }

      buffer_p += read_size;
      read_size = buffer_size;
      buffer_size += read_size;
      buffer = realloc (buffer, buffer_size + 1);

      if (!buffer)
        {
          fprintf (stderr, "error: Failed to reallocate memory\n");
          exit (1);
        }
    }

  buffer = realloc (buffer, len + 1);

  if (!buffer)
    {
      fprintf (stderr, "error: Failed to reallocate memory\n");
      exit (1);
    }

  return buffer;
}


int
main (int argc, char *argv[])
{
  char *line = read_line ();
  puts (line);
  free (line);          /* Processor time-wasting freeing of memory */

  return 0;
}
