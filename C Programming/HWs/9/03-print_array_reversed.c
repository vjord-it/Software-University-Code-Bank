#include "homework_tools.c"


void
reverse_array (int *array, int len)
{
  int *left = array;
  int *right = array + len - 1;

  while (left < right)
    {
      /* printf ("%d <-> %d\n", *left, *right); */
      int left_value = *left;
      *(left++) = *right;
      *(right--) = left_value;
    }
}


int
main (int argc, char *argv[])
{
  printf ("numbers count: ");
  int nums_len = input_int ();

  if (nums_len < 1)
    {
      fprintf (stderr, "error: Numbers count should be > 0\n");
      return 1;
    }

  int nums[nums_len];
  printf ("numbers: ");
  input_array_line (nums, nums_len);

  reverse_array (nums, nums_len);
  print_array (nums, nums_len);

  return 0;
}
