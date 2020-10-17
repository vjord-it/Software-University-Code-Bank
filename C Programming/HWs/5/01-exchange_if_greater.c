#include <stdio.h>


int
main (int argc, char *argv[])
{
  float a_nums[] = {5, 3, 5.5};
  float b_nums[] = {2, 4, 4.5};

  printf ("+---------+---------+-----------+\n"
          "|    a    |    b    |   result  |\n"
          "+---------+---------+-----------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (a_nums) / sizeof (a_nums)[0]);
       ++num_index)
    {
      float a = a_nums[num_index];
      float b = b_nums[num_index];

      printf ("| %7.1f | %7.1f | ", a, b);

      if (a > b)
        {
          float tmp = a;
          a = b;
          b = tmp;
        }


      printf ("%4.1f %4.1f |\n", a, b);
    }

  printf ("+---------+---------+-----------+\n");

  return 0;
}
