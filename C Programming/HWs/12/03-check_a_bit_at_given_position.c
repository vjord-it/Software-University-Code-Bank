#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("integer: ");
  int number = input_int ();
  printf ("bit: ");
  unsigned int bit_position = input_uint ();

  int bit_found = number & (1 << bit_position);

  if (bit_found)
    {
      printf ("true\n");
    }
  else
    {
      printf ("false\n");
    }

  return 0;
}
