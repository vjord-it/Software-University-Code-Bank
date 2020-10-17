#include "homework_tools.c"


void
cross_product (int *result_vector, int *vector_a, int *vector_b)
{
  result_vector[0] = vector_a[1] * vector_b[2] - vector_a[2] * vector_b[1];
  result_vector[1] = vector_a[2] * vector_b[0] - vector_a[0] * vector_b[2];
  result_vector[2] = vector_a[0] * vector_b[1] - vector_a[1] * vector_b[0];
}


int
main (int argc, char *argv[])
{
  int vector_len = 3;

  int vector_a[vector_len];
  printf ("vector A numbers:\n");
  input_array (vector_a, vector_len);

  int vector_b[vector_len];
  printf ("vector B numbers:\n");
  input_array (vector_b, vector_len);

  int cross_product_vector[vector_len];
  cross_product (cross_product_vector, vector_a, vector_b);
  print_array (cross_product_vector, vector_len);

  return 0;
}
