#include <stdio.h>


int
main (int argc, char *argv[])
{
  int nums[] = {63, 17, 22, 23, 20};

  printf ("+--------+--------+\n"
          "|    n   | Result |\n"
          "+--------+--------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       ++num_index)
    {
      int num = nums[num_index];
      int is_odd = !!(num % 2);
      int is_big = num > 20;

      printf ("| %6d | %6d |\n", num, (is_odd && is_big));
    }

  printf ("+--------+--------+\n");

  return 0;
}
