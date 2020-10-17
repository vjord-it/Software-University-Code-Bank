#include "homework_tools.c"


char *
remove_digits (char *string, int len)
{
  char *result = checked_malloc (len);
  char *result_p = result;

  char *end = string + len;
  while (string < end)
    {
      char string_character = *string;

      if (string_character >= '0' && string_character <= '9')
        {
          *result_p = '/';
        }
      else
        {
          *result_p = string_character;
        }

      ++result_p;
      ++string;
    }

  return result;
}


int
main (int argc, char *argv[])
{
  char input[4096];
  printf ("text: ");
  int input_len = input_string (input, sizeof (input));

  char *no_digits_input = remove_digits (input, input_len);
  printf ("%s\n", no_digits_input);

  free (no_digits_input);        /* Unuseful freeing of memory */

  return 0;
}
