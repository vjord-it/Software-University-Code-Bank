#include "homework_tools.c"


void
add_matrices (int *result_matrix, int *matrix_a, int *matrix_b, int len)
{
  int index;
  for (index = 0;
       index < len;
       ++index)
    {
      result_matrix[index] = matrix_a[index] + matrix_b[index];
    }
}


int
main (int argc, char *argv[])
{
  /* Too many matrix rows and cols will cause segmentation fault. */
  printf ("number of matrix rows: ");
  int matrix_rows = input_int ();
  if (matrix_rows < 1)
    {
      fprintf (stderr, "error: Matrix rows should be > 0\n");
      return 1;
    }

  printf ("number of matrix columns: ");
  int matrix_cols = input_int ();
  if (matrix_cols < 1)
    {
      fprintf (stderr, "error: Matrix columns should be > 0\n");
      return 1;
    }

  int matrix_len = matrix_rows * matrix_cols;

  int matrix_a[matrix_len];
  printf ("matrix A numbers:\n");
  input_matrix (matrix_a, matrix_cols, matrix_rows);

  int matrix_b[matrix_len];
  printf ("matrix B numbers:\n");
  input_matrix (matrix_b, matrix_cols, matrix_rows);

  int matrix_sum[matrix_len];
  add_matrices (matrix_sum, matrix_a, matrix_b, matrix_len);
  print_matrix (matrix_sum, matrix_cols, matrix_rows);

  return 0;
}
