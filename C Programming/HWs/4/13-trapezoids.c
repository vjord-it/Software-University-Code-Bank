#include <stdio.h>


int
main (int argc, char *argv[])
{
  float a_nums[] = {5,   2, 8.5, 100, 0.222};
  float b_nums[] = {7,   1, 4.3, 200, 0.333};
  float h_nums[] = {12, 33, 2.7, 300, 0.555};

  printf ("+---------+---------+---------+----------+\n"
          "|    a    |    b    |    h    |   area   |\n"
          "+---------+---------+---------+----------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (a_nums) / sizeof (a_nums)[0]);
       ++num_index)
    {
      float a = a_nums[num_index];
      float b = b_nums[num_index];
      float h = h_nums[num_index];

      float area = ((a + b) / 2.0) * h;

      printf ("| %7.3f | %7.3f | %7.3f | %8.2f |\n",
              a, b, h, area);
    }

  printf ("+---------+---------+---------+----------+\n");

  return 0;
}
