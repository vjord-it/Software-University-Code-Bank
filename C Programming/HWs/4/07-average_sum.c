#include <stdio.h>


int
main (int argc, char *argv[])
{
  int a_nums[] = {45, 22};
  int b_nums[] = {41, 52};
  int c_nums[] = {20, 60};

  printf ("+-----+-----+-----+-----------+\n"
          "|  a  |  b  |  c  |  average  |\n"
          "+-----+-----+-----+-----------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (a_nums) / sizeof (a_nums)[0]);
       ++num_index)
    {
      int a = a_nums[num_index];
      int b = b_nums[num_index];
      int c = c_nums[num_index];
      double average = (a + b + c) / 3.0;

      printf ("| %3d | %3d | %3d | %9.5lf |\n",
              a, b, c, average);
    }

  printf ("+-----+-----+-----+-----------+\n");

  return 0;
}
