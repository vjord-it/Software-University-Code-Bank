#include "homework_tools.c"


#define PALINDROME_MATRIX_CELL_SIZE 4 /* 3 letters + (' ' or '\n' or '\0') */


char *
new_palindrome_matrix (int width, int height)
{
  char *buffer = checked_malloc (width * height * PALINDROME_MATRIX_CELL_SIZE);
  char *buffer_p = buffer;

  int row;
  for (row = 0;
       row < height;
       ++row)
    {
      char row_char = 'a' + row;
      char cell[PALINDROME_MATRIX_CELL_SIZE] = {row_char, row_char, row_char, 0};

      int col;
      for (col = 0;
           col < width;
           ++col)
        {
          sprintf (buffer_p, "%s ", cell);
          buffer_p += sizeof (cell);
          ++cell[1];
        }

      buffer_p[-1] = '\n';
    }

  buffer_p[-1] = 0;

  return buffer;
}


int
main (int argc, char *argv[])
{
  printf ("rows: ");
  int rows = input_int ();

  if (rows < 1)
    {
      fprintf (stderr, "error: Rows must be > 0\n");
      return 1;
    }

  printf ("cols: ");
  int cols = input_int ();

  if (cols < 1)
    {
      fprintf (stderr, "error: Cols must be > 0\n");
      return 1;
    }

  char *palindrome_matrix = new_palindrome_matrix (cols, rows);
  printf ("%s\n", palindrome_matrix);
  free (palindrome_matrix);

  return 0;
}
