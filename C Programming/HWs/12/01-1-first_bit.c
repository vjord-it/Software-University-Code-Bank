#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("number: ");
  int number = input_int ();

  unsigned int bit = (number & 0b10) >> 1;
  printf ("%u\n", bit);

  return 0;
}
