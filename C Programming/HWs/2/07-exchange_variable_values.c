#include <stdio.h>


int
main (int argc, char *argv[])
{
  int a = 5;
  int b = 10;

  printf ("Before:\n"
          "a = %d\n"
          "b = %d\n",
          a, b);

  int tmp = a;
  a = b;
  b = tmp;

  printf ("After:\n"
          "a = %d\n"
          "b = %d\n",
          a, b);

  return 0;
}
