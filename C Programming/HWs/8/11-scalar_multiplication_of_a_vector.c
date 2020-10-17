#include "homework_tools.c"


void
scalar_multiply (int *vector, int vector_len, int scalar)
{
  int vector_index;
  for (vector_index = 0;
       vector_index < vector_len;
       ++vector_index)
    {
      vector[vector_index] *= scalar;
    }
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

  printf ("scalar: ");
  int scalar = input_int ();

  int vector[vector_len];
  printf ("vector numbers:\n");
  input_array (vector, vector_len);

  scalar_multiply (vector, vector_len, scalar);
  print_array (vector, vector_len);

  return 0;
}
