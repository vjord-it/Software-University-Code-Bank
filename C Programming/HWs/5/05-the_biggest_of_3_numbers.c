#include <stdio.h>


int
main (int argc, char *argv[])
{
  float a_nums[] = {5, -2, -2,    0, -0.1};
  float b_nums[] = {2, -2,  4, -2.5, -0.5};
  float c_nums[] = {2,  1,  3,    5, -1.1};

  printf ("+---------+---------+---------+---------+\n"
          "|    a    |    b    |    c    | biggest |\n"
          "+---------+---------+---------+---------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (a_nums) / sizeof (a_nums)[0]);
       ++num_index)
    {
      float a = a_nums[num_index];
      float b = b_nums[num_index];
      float c = c_nums[num_index];

      float biggest = a;
      biggest = b > biggest ? b : biggest;
      biggest = c > biggest ? c : biggest;

      printf ("| %7.1f | %7.1f | %7.1f | %7.1f |\n", a, b, c, biggest);
    }

  printf ("+---------+---------+---------+---------+\n");

  return 0;
}
