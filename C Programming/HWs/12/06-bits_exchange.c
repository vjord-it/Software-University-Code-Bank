#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("number: ");
  u32 number = input_uint ();

  u32 left_bits  = (number & 0b00000111000000000000000000000000) >> 21;
  u32 right_bits = (number & 0b00000000000000000000000000111000) << 21;
  number &=                  0b11111000111111111111111111000111;

  number |= left_bits | right_bits;
  printf ("%u\n", number);

  return 0;
}
