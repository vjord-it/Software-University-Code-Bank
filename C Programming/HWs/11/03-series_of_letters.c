#include "homework_tools.c"


void
unique_chars (char *string, size_t len)
{
  int uniq_chars_len = 1;

  int char_index;
  for (char_index = 1;
       char_index < len;
       ++char_index)
    {
      char current_char = string[char_index];
      char previous_char = string[char_index - 1];
      if (current_char != previous_char)
        {
          string[uniq_chars_len++] = current_char;
        }
    }

  string[uniq_chars_len] = 0;
}


int
main (int argc, char *argv[])
{
  size_t input_len;
  char *input = input_line (&input_len);
  unique_chars (input, input_len);

  printf ("%s\n", input);
  free (input);                 /* Pointless freeing of memory. */

  return 0;
}
