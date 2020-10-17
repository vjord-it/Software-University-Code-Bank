#include <stdio.h>


int
main (int argc, char *argv[])
{
  float nums[] = {   0,      1,
                    -2,      0,
                    -1,      2,
                   1.5,     -1,
                  -1.5,   -1.5,
                   100,    -30,
                     0,      0,
                   0.2,   -0.8,
                   0.9,  -1.93,
                     1,  1.655};

  float radius = 2;
  float radius_squared = radius * radius;

  printf ("+---------+---------+----------+\n"
          "|    x    |    y    |  inside  |\n"
          "+---------+---------+----------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       num_index += 2)
    {
      float x = nums[num_index];
      float y = nums[num_index + 1];

      float distance_squared = x * x + y * y;
      char *inside;

      if (distance_squared <= radius_squared)
        {
          inside = "Yes";
        }
      else
        {
          inside = "No";
        }

      printf ("| %7.3f | %7.3f | %-8s |\n", x, y, inside);
    }

  printf ("+---------+---------+----------+\n");

  return 0;
}
