#include <stdio.h>


int
main (int argc, char *argv[])
{
  int nums[] = {2174, 169, 46};
  int digit_positions[] = {3, 2, 4};

  printf ("+--------+-----+--------+\n"
          "| number |  n  | result |\n"
          "+--------+-----+--------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       ++num_index)
    {
      int num = nums[num_index];
      int digit_position = digit_positions[num_index];
      int divider = 1;

      int divide_iteration;
      for (divide_iteration = 1;
           divide_iteration < digit_position;
           ++divide_iteration)
        {
          divider *= 10;
        }

      int digit = (num / divider) % 10;
      char digit_char;

      if (digit)
        {
          digit_char = digit + '0';
        }
      else
        {
          digit_char = '-';
        }

      printf ("| %6d | %3d | %6c |\n", num, digit_position, digit_char);
    }

  printf ("+--------+-----+--------+\n");

  return 0;
}
