#include <stdio.h>


int
main (int argc, char *argv[])
{
  float a_nums[] = {5, -2, -2,    0,   -1};
  float b_nums[] = {2, -2,  4, -2.5, -0.5};
  float c_nums[] = {2,  1,  3,    4, -5.1};

  printf ("+---------+---------+---------+--------+\n"
          "|    a    |    b    |    c    | result |\n"
          "+---------+---------+---------+--------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (a_nums) / sizeof (a_nums)[0]);
       ++num_index)
    {
      float a = a_nums[num_index];
      float b = b_nums[num_index];
      float c = c_nums[num_index];

      char result;

      if (!a || !b || !c)
        {
          result = '0';
        }
      else
        {
          int negatives_count = (a < 0) + (b < 0) + (c < 0);

          if (negatives_count % 2) /* odd number of negatives */
            {
              result = '-';
            }
          else
            {
              result = '+';
            }
        }

      printf ("| %7.1f | %7.1f | %7.1f |    %c   |\n", a, b, c, result);
    }

  printf ("+---------+---------+---------+--------+\n");

  return 0;
}
