#include <stdio.h>


int
main (int argc, char *argv[])
{
  double widths[]  = {3.0, 2.5, 5.0};
  double heights[] = {4.0, 3.0, 5.0};

  printf ("+-------+--------+-----------+--------+\n"
          "| width | height | perimeter |  area  |\n"
          "+-------+--------+-----------+--------+\n");

  int rect_index;
  for (rect_index = 0;
       rect_index < (sizeof (widths) / sizeof (widths)[0]);
       ++rect_index)
    {
      double width = widths[rect_index];
      double height = heights[rect_index];
      double perimeter = width * 2 + height * 2;
      double area = width * height;

      printf ("| %5.2lf | %6.2lf | %9.2lf | %6.2lf |\n",
              width, height, perimeter, area);
    }

  printf ("+-------+--------+-----------+--------+\n");

  return 0;
}
