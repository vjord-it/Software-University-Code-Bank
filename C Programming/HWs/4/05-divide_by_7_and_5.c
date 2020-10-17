#include <stdio.h>


int
main (int argc, char *argv[])
{
  int nums[] = {3, 0, 5, 7, 35, 140};

  printf ("+-------+---------------------+\n"
          "|   n   | divided by 7 and 5? |\n"
          "+-------+---------------------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       ++num_index)
    {
      int num = nums[num_index];
      int result = num ? (!(num % 7) && !(num % 5)) : 0;

      printf ("| %5d | %19d |\n", num, result);
    }

  printf ("+-------+---------------------+\n");

  return 0;
}
