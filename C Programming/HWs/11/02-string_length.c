#include <stdio.h>
#include <string.h>


#define MAX_INPUT_LEN 20


size_t
delete_trailing_whitespace (char *string, size_t len)
{
  size_t index = len;

  while (index--)
    {
      if ((unsigned char) string[index] >= ' ')
        {
          break;
        }
    }

  size_t new_len = index + 1;
  string[new_len] = 0;

  return new_len;
}


int
main (int argc, char *argv[])
{
  char input_buffer[MAX_INPUT_LEN + 1];

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return (0);
    }

  size_t input_len = strnlen (input_buffer, MAX_INPUT_LEN);
  input_len = delete_trailing_whitespace (input_buffer, input_len);

  while (input_len < MAX_INPUT_LEN)
    {
      input_buffer[input_len++] = '*';
    }

  input_buffer[input_len] = 0;

  printf ("%s\n", input_buffer);

  return 0;
}
