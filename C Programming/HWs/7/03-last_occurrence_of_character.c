#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include "homework_tools.c"


int
find_last_char (char *string, char search)
{
  int index_result = -1;

  int string_index;
  for (string_index = 0;
       string[string_index];
       ++string_index)
    {
      if (string[string_index] == search)
        {
          index_result = string_index;
        }
    }

  return index_result;
}


int
main (int argc, char *argv[])
{
  printf ("string: ");
  char input_buffer[4096];
  input_string (input_buffer, sizeof (input_buffer));

  printf ("search char: ");
  char searched_char = input_char ();

  printf ("%d\n", find_last_char (input_buffer, searched_char));

  return 0;
}
