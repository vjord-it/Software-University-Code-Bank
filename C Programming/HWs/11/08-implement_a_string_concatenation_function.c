#include <stdio.h>
#include <string.h>


void
my_strncat (char *buffer, char *src, size_t src_len)
{
  char *buffer_string_end = buffer + strlen (buffer);

  int index;
  for (index = 0;
       index < src_len;
       ++index)
    {
      char src_char = src[index];

      if (!src_char)
        {
          break;
        }

      buffer_string_end[index] = src_char;
    }

  buffer_string_end[index] = 0;
}


int
main (int argc, char *argv[])
{
  {
    char buffer[10] = "Soft";
    my_strncat (buffer, "Uni", 7);
    printf ("\"%s\"\n", buffer);
  }

  {
    /* The buffer overflows here. */

    /* char buffer[5] = "Soft"; */
    /* my_strncat (buffer, "ware University", 15); */
    /* printf ("\"%s\"\n", buffer); */
  }

  {
    char buffer[10] = "C";
    my_strncat (buffer, " is cool", 8);
    printf ("\"%s\"\n", buffer);
  }

  {
    /*
      You can't write to the "buffer" here.  String literals are just
      pointers to memory and typically that memory is read-only.  Any
      attempts to change that memory will lead to a Segmentation fault
      or undefined behavior.

      On the other hand, when a string literal is used to initialize
      an array (e.g. char buffer[] = "text"), the string is actually
      copied on the stack and buffer[] acts as a pointer to that copy.
      Since the string copy is on the stack, you can modify it.
    */

    /* char *buffer = "C"; */
    /* my_strncat (buffer, " is cool", 8); */
    /* printf ("\"%s\"\n", buffer); */
  }

  return 0;
}
