#include "homework_tools.c"


void
swap (int *first, int *second)
{
  int tmp = *first;
  *first = *second;
  *second = tmp;
}


int
main (int argc, char *argv[])
{
  printf ("First number: ");
  int first = input_int ();
  printf ("Second number: ");
  int second = input_int ();

  swap (&first, &second);

  printf ("First: %d\n", first);
  printf ("Second: %d\n", second);

  return 0;
}
