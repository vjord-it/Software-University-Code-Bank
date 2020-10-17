#include <stdio.h>


int
main (int argc, char *argv[])
{
  int nums[] = {5, 701, 9703, 877, 777877, 9999799};

  printf ("+-----------+----------------+\n"
          "|     n     | 3rd digit is 7 |\n"
          "+-----------+----------------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       ++num_index)
    {
      int a = nums[num_index];
      char *result  = ((a / 100) % 10) == 7 ? "true" : "false" ;

      printf ("| %9d | %-14s |\n", a, result);
    }

  printf ("+-----------+----------------+\n");

  return 0;
}
