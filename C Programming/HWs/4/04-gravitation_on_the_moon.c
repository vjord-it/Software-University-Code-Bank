#include <stdio.h>


int
main (int argc, char *argv[])
{
  double weights[] = {86, 74.6, 53.7};

  printf ("+--------+--------------------+\n"
          "| weight | weight on the moon |\n"
          "+--------+--------------------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (weights) / sizeof (weights)[0]);
       ++num_index)
    {
      double weight = weights[num_index];
      double weight_on_moon = weight * 0.17;

      printf ("| %6.2f | %18.4f |\n", weight, weight_on_moon);
    }

  printf ("+--------+--------------------+\n");

  return 0;
}
