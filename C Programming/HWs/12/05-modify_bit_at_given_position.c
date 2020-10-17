#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("number: ");
  int number = input_int ();

  printf ("bit position: ");
  unsigned int bit_position = input_uint ();

  printf ("bit value: ");
  int bit_value = input_int ();

  if (bit_value && bit_value != 1)
    {
      fprintf (stderr, "error: Bit value must be 1 or 0\n");
    }


  unsigned int bit_mask = (1 << bit_position);

  if (bit_value)
    {
      number |= bit_mask;
    }
  else
    {
      number &= ~bit_mask;
    }

  printf ("%d\n", number);

  return 0;
}
