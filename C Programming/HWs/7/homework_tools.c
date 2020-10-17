#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


char
input_char (void)
{
  int result = getc (stdin);

  if (result == EOF)
    {
      fprintf (stderr, "error: No input given\n");
      exit (1);
    }
  else if (result <= ' ')
    {
      fprintf (stderr, "error: Invalid input given\n");
      exit (1);
    }

  while (1)
    {
      int trailing_input = getc (stdin);
      if (trailing_input == EOF || trailing_input == '\n')
        {
          break;
        }
    }

  return (char) result;
}


void
input_string (char *buffer, size_t buffer_size)
{
  if (!(fgets (buffer, buffer_size, stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      exit (1);
    }
}


long
input_long_int (void)
{
  char input_buffer[4096];
  input_string (input_buffer, sizeof (input_buffer));

  char *input_end;
  errno = 0;
  long result = strtol (input_buffer, &input_end, 10);

  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      exit (1);
    }

  return result;
}


double
input_double (void)
{
  char input_buffer[4096];
  input_string (input_buffer, sizeof (input_buffer));

  char *input_end;
  errno = 0;
  double result = strtod (input_buffer, &input_end);

  if (errno || input_end == input_buffer)
    {
      fprintf (stderr, "error: Invalid number given (errno: %d)\n", errno);
      exit (1);
    }

  return result;
}
