#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include "homework_tools.c"


long get_max (long a, long b);


int
main (int argc, char *argv[])
{
  printf ("a: ");
  long a = input_long_int ();
  printf ("b: ");
  long b = input_long_int ();

  long max = get_max(a, b);
  printf ("max: %ld\n", max);

  return 0;
}


long
get_max (long a, long b)
{
  return (a > b) ? a : b;
}
