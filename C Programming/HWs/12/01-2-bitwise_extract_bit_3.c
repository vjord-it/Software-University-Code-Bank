#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("unsigned integer: ");
  unsigned int number = input_uint ();

  int bit = (number & 0b1000) >> 3;

  printf ("%u\n", bit);

  return 0;
}
