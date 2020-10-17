#include <stdio.h>


int
main (int argc, char *argv[])
{
  char input_buffer[4096];

  printf ("binary: ");
  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }


  long decimal_result = 0;
  int bit_index;

  for (bit_index = 0;
       bit_index < sizeof (input_buffer);
       ++bit_index)
    {
      int bit = input_buffer[bit_index] - '0';

      if (bit == 1)
        {
          decimal_result = decimal_result * 2 + bit;
        }
      else if (bit == 0)
        {
          decimal_result = decimal_result * 2;
        }
      else
        {
          break;
        }
    }

  printf ("%ld\n", decimal_result);

  return 0;
}
