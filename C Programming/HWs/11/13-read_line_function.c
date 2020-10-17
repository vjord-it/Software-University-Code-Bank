#include "homework_tools.c"


#define INITIAL_INPUT_LINE_BUFFER_SIZE 64


char *
read_line ()
{
  char *buffer = checked_malloc (INITIAL_INPUT_LINE_BUFFER_SIZE + 1);
  size_t buffer_size = INITIAL_INPUT_LINE_BUFFER_SIZE;
  size_t read_size = INITIAL_INPUT_LINE_BUFFER_SIZE;
  size_t buffer_offset = 0;
  size_t len;

  while (1)
    {
      buffer[buffer_size] = 1;

      if (!(fgets (buffer + buffer_offset, read_size + 1, stdin)))
        {
          len = buffer_size - read_size;
          break;
        }
      else if (buffer[buffer_size])
        {
          len = buffer_offset + strlen (buffer + buffer_offset);
          break;
        }

      buffer_offset += read_size;
      read_size = buffer_size;
      buffer_size += read_size;
      buffer = checked_realloc (buffer, buffer_size + 1);
    }

  len = delete_trailing_whitespace (buffer, len);
  buffer = checked_realloc (buffer, len + 1);

  return buffer;
}


int
main (int argc, char *argv[])
{
  char *line = read_line ();
  printf ("\"%s\"\n", line);
  free (line);

  return 0;
}
