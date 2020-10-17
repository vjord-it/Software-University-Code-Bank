#include <stdio.h>


int
main (int argc, char *argv[])
{
  int nums[] = {3, 2, -2, -1, 0};

  printf ("+------+------+\n"
          "|   n  | odd? |\n"
          "+------+------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       ++num_index)
    {
      int num = nums[num_index];
      printf ("| %4d | %4d |\n", num, !!(num % 2));
    }

  printf ("+------+------+\n");

  return 0;
}
