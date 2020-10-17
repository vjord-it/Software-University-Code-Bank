#include <stdio.h>


int
main (int argc, char *argv[])
{
  double a = 34.567839023;
  float b = 12.345;
  double c = 8923.1234857;
  double d = 3456.091;

  printf ("%.9lf, %.3f, %.7lf, %.3lf\n",
          a, b, c, d);

  return 0;
}
