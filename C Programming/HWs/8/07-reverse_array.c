#include "homework_tools.c"


void
reverse_array (int *array, int len)
{
  int half_len = len / 2;
  int left_index;
  int right_index;

  for (left_index = 0, right_index = len - 1;
       left_index < half_len;
       ++left_index, --right_index)
    {
      int left_value = array[left_index];
      array[left_index] = array[right_index];
      array[right_index] = left_value;
    }
}


int
main (int argc, char *argv[])
{
  /* Too many nums will cause segmentation fault. */
  printf ("numbers count: ");
  int nums_len = input_int ();

  if (nums_len < 1)
    {
      fprintf (stderr, "error: Numbers count should be > 0\n");
      return 1;
    }

  int nums[nums_len];

  printf ("numbers:\n");
  input_array (nums, nums_len);
  reverse_array (nums, nums_len);
  print_array (nums, nums_len);

  return 0;
}
