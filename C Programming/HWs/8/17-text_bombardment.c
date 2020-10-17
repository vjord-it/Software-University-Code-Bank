#include "homework_tools.c"
#include <string.h>


#define MAX_LINE_LEN 100
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
bomb_columns (char *text, int line_len, int rows_count,
              int *bombed_cols, int bombed_cols_len)
{
  int bombed_col_index;
  for (bombed_col_index = 0;
       bombed_col_index < bombed_cols_len;
       ++bombed_col_index)
    {
      int bombed_col = bombed_cols[bombed_col_index];
      int characters_are_destroyed = 0;

      int row;
      for (row = 0;
           row < rows_count;
           ++row)
        {
          int character_index = row * line_len + bombed_col;
          char text_character = text[character_index];
          if ((unsigned char) text_character > ' ')
            {
              text[character_index] = ' ';
              characters_are_destroyed = 1;
            }
          else if (characters_are_destroyed)
            {
              break;
            }
        }
    }
}


int
main (int argc, char *argv[])
{
  printf ("text (length <= %d):\n", MAX_TEXT_LEN);
  char input[MAX_TEXT_LEN + MAX_LINE_LEN + 1];
  input_string (input, MAX_TEXT_LEN + 1);
  int input_len = strnlen (input, MAX_TEXT_LEN + 1);
  input_len = delete_trailing_whitespace (input, input_len);


  printf ("line length (<= %d): ", MAX_LINE_LEN);
  int line_len = input_int ();
  if (line_len < 1 || line_len > MAX_LINE_LEN)
    {
      fprintf (stderr, "error: Line length must be between 1 and %d\n",
               MAX_LINE_LEN);
      return 1;
    }

  int trailing_row_space = (line_len - (input_len % line_len)) % line_len;
  memset (input + input_len, ' ', trailing_row_space);
  input[input_len + trailing_row_space] = 0;

  int rows_count = ((input_len - 1) / line_len) + 1;


  printf ("columns to bomb (0 to %d): ", line_len - 1);
  int bombed_cols[line_len];
  int bombed_cols_len = input_int_line (bombed_cols, line_len);


  bomb_columns (input, line_len, rows_count, bombed_cols, bombed_cols_len);
  /* print_text_matrix (input, line_len, rows_count); */
  printf ("%.*s\n", input_len, input);

  return 0;
}
