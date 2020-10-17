#include "homework_tools.c"


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
  sort_array (nums, nums_len);
  print_array (nums, nums_len);

  return 0;
}
