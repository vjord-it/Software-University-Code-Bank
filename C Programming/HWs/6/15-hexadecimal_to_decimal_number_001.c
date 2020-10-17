#include <stdio.h>


int
main (int argc, char *argv[])
{
  char hex_input[4096];

  printf ("hexadecimal: ");
  if (!(fgets (hex_input, sizeof (hex_input), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }


  long decimal_result = 0;
  int hex_index;

  for (hex_index = 0;
       hex_index < sizeof (hex_input);
       ++hex_index)
    {
      char hex_char = hex_input[hex_index];
      int hex_digit;

      if (hex_char >= '0' && hex_char <= '9')
        {
          hex_digit = hex_char - '0';
        }
      else if (hex_char >= 'A' && hex_char <= 'F')
        {
          hex_digit = hex_char - 'A' + 10;
        }
      else if (hex_char >= 'a' && hex_char <= 'f')
        {
          hex_digit = hex_char - 'a' + 10;
        }
      else
        {
          break;
        }

      decimal_result = decimal_result * 16 + hex_digit;
    }

  printf ("%ld\n", decimal_result);

  return 0;
}
