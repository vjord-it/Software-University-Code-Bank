#include <stdio.h>


int
main (int argc, char *argv[])
{
  int nums[] = {121, 1263, 26, 23, 81, 1287};

  printf ("+--------+--------+\n"
          "|    n   | Result |\n"
          "+--------+--------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       ++num_index)
    {
      int num = nums[num_index];
      int is_pure = (!(num % 9) || !(num % 11) || !(num % 13));

      printf ("| %6d | %6d |\n", num, is_pure);
    }

  printf ("+--------+--------+\n");

  return 0;
}
