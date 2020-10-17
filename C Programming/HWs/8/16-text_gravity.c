#include "homework_tools.c"
#include <string.h>


#define MAX_LINE_LEN 30
#define MAX_TEXT_LEN 1000


void
print_text_matrix (char *text, int width, int height)
{
  char horizontal_border[width + 1];
  horizontal_border[width] = 0;
  memset (horizontal_border, '-', width);

  printf ("+%s+\n", horizontal_border);

  int row;
  for (row = 0;
       row < height;
       ++row)
    {
      printf ("|");

      int col;
      for (col = 0;
           col < width;
           ++col)
        {
          char current_character = text[row * width + col];
          printf ("%c", current_character);
        }
      printf ("|\n");
    }

  printf ("+%s+\n", horizontal_border);
}


void
drop_characters (char *text, int line_len, int rows_count)
{
  /* Don't consider the last row, since it's already on the ground. */
  --rows_count;

  int first_active_row = 0;
  for (first_active_row = 0;
       first_active_row < rows_count;
       ++first_active_row)
    {
      int row = rows_count;
      while (--row >= first_active_row)
        {
          int col;
          for (col = 0;
               col < line_len;
               ++col)
            {
              int underneath_index = (row + 1) * line_len + col;

              if ((unsigned char) text[underneath_index] <= ' ')
                {
                  int current_index = row * line_len + col;
                  text[underneath_index] = text[current_index];
                  text[current_index] = ' ';
                }
            }
        }
    }
}


int
main (int argc, char *argv[])
{
  printf ("line length (<= %d): ", MAX_LINE_LEN);
  int line_len = input_int ();
  if (line_len < 1 || line_len > MAX_LINE_LEN)
    {
      fprintf (stderr, "error: Line length must be between 1 and %d\n",
               MAX_LINE_LEN);
      return 1;
    }

  printf ("text (length <= %d):\n", MAX_TEXT_LEN);
  char input[MAX_TEXT_LEN + line_len + 1];
  input_string (input, MAX_TEXT_LEN + 1);
  int input_len = strnlen (input, MAX_TEXT_LEN + 1);
  input_len = delete_trailing_whitespace (input, input_len);

  int trailing_row_space = (line_len - (input_len % line_len)) % line_len;
  memset (input + input_len, ' ', trailing_row_space);
  input[input_len + trailing_row_space] = 0;

  int rows_count = ((input_len - 1) / line_len) + 1;
  drop_characters (input, line_len, rows_count);
  print_text_matrix (input, line_len, rows_count);

  return 0;
}
