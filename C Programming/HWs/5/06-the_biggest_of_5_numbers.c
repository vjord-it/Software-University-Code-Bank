#include <stdio.h>


int
main (int argc, char *argv[])
{
  float a_nums[] = {5,  -2, -2,    0,   -3};
  float b_nums[] = {2, -22,  4, -2.5, -0.5};
  float c_nums[] = {2,   1,  3,    0, -1.1};
  float d_nums[] = {4,   0,  2,    5,   -2};
  float e_nums[] = {1,   0,  0,    5, -0.1};


  printf ("+---------+---------+---------+---------+---------+---------+\n"
          "|    a    |    b    |    c    |    d    |    e    | biggest |\n"
          "+---------+---------+---------+---------+---------+---------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (a_nums) / sizeof (a_nums)[0]);
       ++num_index)
    {
      float a = a_nums[num_index];
      float b = b_nums[num_index];
      float c = c_nums[num_index];
      float d = d_nums[num_index];
      float e = e_nums[num_index];

      float biggest = a;
      if (b > biggest) biggest = b;
      if (c > biggest) biggest = c;
      if (d > biggest) biggest = d;
      if (e > biggest) biggest = e;

      printf ("| %7.1f | %7.1f | %7.1f | %7.1f | %7.1f | %7.1f |\n",
              a, b, c, d, e, biggest);
    }

  printf ("+---------+---------+---------+---------+---------+---------+\n");

  return 0;
}
