#include <stdio.h>


int
main (int argc, char *argv[])
{
  double a, b, c;

  if (3 == scanf ("%lf %lf %lf", &a, &b, &c))
    {
      double sum = a + b + c;
      printf ("%lf\n", sum);
    }
  else
    {
      fprintf (stderr, "error: You must supply 3 numbers separated by spaces\n");
    }

  return 0;
}
