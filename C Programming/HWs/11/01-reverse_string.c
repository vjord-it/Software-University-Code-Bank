#include "homework_tools.c"


void
reverse_string (char *string, size_t len)
{
  char *left = string;
  char *right = string + len - 1;

  while (left < right)
    {
      char left_value = *left;
      *(left++) = *right;
      *(right--) = left_value;
    }
}


int
main (int argc, char *argv[])
{
  size_t input_len;
  char *input = input_line (&input_len);
  reverse_string (input, input_len);
  printf ("%s\n", input);

  free (input);                 /* Pointless freeing of memory. */

  return 0;
}
