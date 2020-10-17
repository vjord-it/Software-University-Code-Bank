#include <stdio.h>
#include <stdlib.h>
#include <errno.h>


int
main (int argc, char *argv[])
{
  char input_buffer[4096];
  char *input_end;

  printf ("matrix size: ");
  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long width =  strtol (input_buffer, &input_end, 10);

  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  long nums_count = width * width;
  long matrix[nums_count];

  int spacing = 1;
  {
    long digit_counter_operand = nums_count;
    while (digit_counter_operand)
      {
        ++spacing;
        digit_counter_operand /= 10; /* for base 10 matrix */
      }
  }

  long line_length = width;
  long num = 0;

  long x = -1;
  long y = 0;
  int x_direction = 1;
  int y_direction = 0;
  int direction = 0;

  while (line_length > 0)
    {
      long line_index = line_length;
      while (line_index--)
        {
          x += x_direction;
          y += y_direction;
          matrix[(y * width) + x] = ++num;
        }

      switch (++direction)
        {
        case 0:               /* RIGHT */
          x_direction = 1;
          y_direction = 0;
          break;
        case 1:               /* DOWN */
          --line_length;
          x_direction = 0;
          y_direction = 1;
          break;
        case 2:               /* LEFT */
          x_direction = -1;
          y_direction = 0;
          break;
        case 3:               /* UP */
          --line_length;
          direction = -1;
          x_direction = 0;
          y_direction = -1;
          break;
        }
    }


  /* PRINT MATRIX */
  {
    long m_index;
    for (m_index = 0;
         m_index < (width * width);
         ++m_index)
      {
        if (!(m_index % width))
          {
            printf ("\n");
          }

        long num = matrix[m_index];
        printf ("%*ld ", spacing - 1, num);
      }
    printf ("\n");
  }

  return 0;
}
