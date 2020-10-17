#include "homework_tools.c"


int
linear_search (int *array, int len, int search)
{
  int num_found = 0;

  int array_index;
  for (array_index = 0;
       array_index < len;
       ++array_index)
    {
      if (array[array_index] == search)
        {
          num_found = 1;
          break;
        }
    }

  return num_found;
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
  printf ("numbers: ");
  input_array_line (nums, nums_len);

  printf ("search: ");
  int search_num = input_int ();

  if (linear_search (nums, nums_len, search_num))
    {
      printf ("yes\n");
    }
  else
    {
      printf ("no\n");
    }

  return 0;
}
