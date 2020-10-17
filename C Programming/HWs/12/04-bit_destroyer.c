#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("integer: ");
  int number = input_int ();

  printf ("remove bit: ");
  unsigned int bit_position = input_uint ();

  number &= ~(1 << bit_position);

  printf ("%d\n", number);

  return 0;
}
