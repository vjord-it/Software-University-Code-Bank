#include <stdio.h>


void
my_strncpy (char *buffer, char *string, size_t len)
{
  int index;
  for (index = 0;
       index < len;
       ++index)
    {
      char current_char = string[index];

      if (!current_char)
        {
          break;
        }

      buffer[index] = current_char;
    }

  buffer[index] = 0;
}


/*
char *
my_buggy_strncpy (char *string, size_t len)
{
  char buffer[len + 1];

  int index;
  for (index = 0;
       index < len;
       ++index)
    {
      char current_char = string[index];

      if (!current_char)
        {
          break;
        }

      buffer[index] = current_char;
    }

  buffer[index] = 0;

  return buffer;
}
*/



int
main (int argc, char *argv[])
{
  char string[] = "SoftUni";
  size_t string_len = sizeof(string) - 1;
  char buffer[sizeof(string)];

  my_strncpy (buffer, string, string_len);
  printf ("\"%s\"\n", buffer);

  /*
    my_buggy_strncpy() won't work most of the time, because it returns
    a buffer made inside it and on the stack.  When my_buggy_strncpy()
    returns, the buffer it made will be overwritten by subsequent
    function calls.
  */

  /* char buggy_result = my_buggy_strncpy(string, string_len); */
  /* printf ("\"%s\"\n", buggy_result); */

  return 0;
}
