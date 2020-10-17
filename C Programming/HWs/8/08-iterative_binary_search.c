#include "homework_tools.c"


int
binary_search (int *array, int len, int search)
{
  int begin = 0;

  while (begin < len)
    {
      int middle = begin + ((len - begin) / 2);
      int middle_value = array[middle];

      if (middle_value == search)
        {
          return middle;
        }
      else if (middle_value < search)
        {
          begin = middle + 1;
        }
      else
        {
          len = middle;
        }
    }

  return -1;
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

  int search_result_index = binary_search (nums, nums_len, search_num);
  printf ("%d\n", search_result_index);


  return 0;
}
