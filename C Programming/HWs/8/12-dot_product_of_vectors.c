#include "homework_tools.c"


int
dot_product (int *vector_a, int *vector_b, int vector_len)
{
  int result = 0;

  int vector_index;
  for (vector_index = 0;
       vector_index < vector_len;
       ++vector_index)
    {
      result += vector_a[vector_index] * vector_b[vector_index];
    }

  return result;
}


int
main (int argc, char *argv[])
{
  /* Too many nums will cause segmentation fault. */
  printf ("vector length: ");
  int vector_len = input_int ();

  if (vector_len < 1)
    {
      fprintf (stderr, "error: Vector length should be > 0\n");
      return 1;
    }

  int vector_a[vector_len];
  printf ("vector A numbers:\n");
  input_array (vector_a, vector_len);

  int vector_b[vector_len];
  printf ("vector B numbers:\n");
  input_array (vector_b, vector_len);

  printf ("dot product: %d\n", dot_product (vector_a, vector_b, vector_len));

  return 0;
}
