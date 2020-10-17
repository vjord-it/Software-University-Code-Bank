#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("integer: ");
  int number = input_int ();
  printf ("bit: ");
  unsigned int bit_position = input_uint ();

  int bit = (number & (1 << bit_position)) >> bit_position;

  printf ("%d\n", bit);

  return 0;
}
