#include <stdio.h>
#include <stdlib.h>
#include <errno.h>

/* unistd.h has usleep() which is needed for the matrix print
   animation, but it's not part of the C standard library, so it may
   not be available on some systems: */

#include <unistd.h>


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
  int spacing = 1;

  {
    long digit_counter_operand = nums_count;
    while (digit_counter_operand)
      {
        ++spacing;
        digit_counter_operand /= 0x10; /* for base 16 matrix */
      }
  }

  long line_length = width;
  long num = 0;

  long x = -1;
  long y = 0;
  int x_direction = 1;
  int y_direction = 0;
  int direction = 0;            /* right, down, left, up */

  printf ("\e[2J");             /* clear screen */
  printf ("\e[?25l");           /* hide cursor */

  while (line_length > 0)
    {
      long line_index = line_length;
      while (line_index--)
        {
          x += x_direction;
          y += y_direction;

          long draw_x = x * spacing + 1;
          long draw_y = y + 1;

          printf ("\e[%ld;%ldH", draw_y, draw_x);
          printf ("%.*lx", (spacing - 1), ++num);
          fflush (stdout);
          usleep(300000 / width);
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

  printf ("\e[%ld;1H", width + 1); /* set cursor below matrix */
  printf ("\e[?25h");              /* unhide cursor */

  return 0;
}
