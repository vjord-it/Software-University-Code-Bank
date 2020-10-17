#include <stdio.h>


int
main (int argc, char *argv[])
{
  float nums[] = {   1,     2,
                   2.5,     2,
                     0,     1,
                   2.5,     1,
                     2,     0,
                     4,     0,
                   2.5,   1.5,
                     2,   1.5,
                     1,   2.5,
                  -100,  -100};

  float circle_x = 1;
  float circle_y = 1;
  float circle_radius = 1.5;
  float circle_radius_squared = circle_radius * circle_radius;

  float rect_top = 1;
  float rect_left = -1;
  float rect_width = 6;
  float rect_height = 2;

  float rect_right = rect_left + rect_width;
  float rect_bottom = rect_top - rect_height;

  printf ("+-----------+-----------+----------------+\n"
          "|     x     |     y     |  in K & out R  |\n"
          "+-----------+-----------+----------------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       num_index += 2)
    {
      float x = nums[num_index];
      float y = nums[num_index + 1];

      float x_len = circle_x - x;
      float y_len = circle_y - y;
      float distance_squared = x_len * x_len + y_len * y_len;
      int inside_circle = distance_squared <= circle_radius_squared;

      int inside_rectangle = (x >= rect_left && x <= rect_right &&
                              y >= rect_bottom && y <= rect_top);

      char *inside;

      if (inside_circle && !inside_rectangle)
        {
          inside = "Yes";
        }
      else
        {
          inside = "No";
        }

      printf ("| %9.3f | %9.3f | %-14s |\n", x, y, inside);
    }

  printf ("+-----------+-----------+----------------+\n");

  return 0;
}
