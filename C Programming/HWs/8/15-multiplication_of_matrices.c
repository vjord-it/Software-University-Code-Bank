#include "homework_tools.c"


void
multiply_matrices (int *result_matrix, int *matrix_a, int *matrix_b,
                   int matrix_a_cols, int matrix_a_rows)
{
  int dimension_len = matrix_a_rows;
  int vector_len = matrix_a_cols;

  int row;
  for (row = 0;
       row < dimension_len;
       ++row)
    {
      int col;
      for (col = 0;
           col < dimension_len;
           ++col)
        {
          int product = 0;

          int index;
          for (index = 0;
               index < vector_len;
               ++index)
            {
              int a = matrix_a[row * vector_len + index];
              int b = matrix_b[index * dimension_len + col];
              product += a * b;
            }

          result_matrix[row * dimension_len + col] = product;
        }
    }
}


int
main (int argc, char *argv[])
{
  /* Too many matrix rows and cols will cause segmentation fault. */
  printf ("number of matrix A rows and matrix B columns: ");
  int matrix_a_rows = input_int ();
  if (matrix_a_rows < 1)
    {
      fprintf (stderr, "error: Matrix rows/columns should be > 0\n");
      return 1;
    }

  printf ("number of matrix B rows and matrix A columns: ");
  int matrix_b_rows = input_int ();
  if (matrix_b_rows < 1)
    {
      fprintf (stderr, "error: Matrix rows/columns should be > 0\n");
      return 1;
    }

  int matrix_a_cols = matrix_b_rows;
  int matrix_b_cols = matrix_a_rows;

  int matrix_a[matrix_a_cols * matrix_a_rows];
  printf ("matrix A numbers:\n");
  input_matrix (matrix_a, matrix_a_cols, matrix_a_rows);

  int matrix_b[matrix_b_cols * matrix_b_rows];
  printf ("matrix B numbers:\n");
  input_matrix (matrix_b, matrix_b_cols, matrix_b_rows);

  int matrix_product[matrix_a_rows * matrix_b_cols];
  multiply_matrices (matrix_product, matrix_a, matrix_b, matrix_a_cols, matrix_a_rows);
  print_matrix (matrix_product, matrix_a_rows, matrix_b_cols);

  return 0;
}
