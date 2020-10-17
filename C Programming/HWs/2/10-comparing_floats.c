#include <stdio.h>


void
safe_compare (double a, double b)
{
  double diff = a - b;

  if (diff <= 0.000001 && diff >= -0.000001)
    {
      printf ("EQUAL\n");
    }
  else
    {
      printf ("NOT EQUAL\n");
    }
}


int
main (int argc, char *argv[])
{
  safe_compare (5.3, 6.01);
  safe_compare (5.00000001, 5.00000003);
  safe_compare (5.00000005, 5.00000001);
  safe_compare (-0.0000007, 0.00000007);
  safe_compare (-4.999999, -4.999998);
  safe_compare (4.999999, 4.999998);

  return 0;
}
