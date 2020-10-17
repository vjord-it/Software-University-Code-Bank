#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  /* Too many nums will cause segmentation fault. */
  printf ("matrix size: ");
  int matrix_width = input_int ();

  if (matrix_width < 1)
    {
      fprintf (stderr, "error: Matrix size should be > 0\n");
      return 1;
    }

  int matrix[matrix_width * matrix_width];
  input_matrix (matrix, matrix_width, matrix_width);

  int row;
  for (row = 0;
       row < matrix_width;
       ++row)
    {
      int col;
      for (col = 0;
           col <= row;
           ++col)
        {
          int num = matrix[row * matrix_width + col];
          printf ("%d ", num);
        }

      printf ("\n");
    }

  return 0;
}
