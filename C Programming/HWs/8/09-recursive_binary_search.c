#include "homework_tools.c"


int
recursive_binary_search (int *array, int begin, int end, int search)
{
  if (begin < end)
    {
      int middle = begin + ((end - begin) / 2);
      int middle_value = array[middle];

      if (middle_value == search)
        {
          return middle;
        }
      else if (middle_value < search)
        {
          return recursive_binary_search (array, middle + 1, end, search);
        }
      else
        {
          return recursive_binary_search (array, begin, middle, search);
        }
    }
  else
    {
      return -1;
    }
}


int
binary_search (int *array, int len, int search)
{
  int result = recursive_binary_search (array, 0, len, search);
  return result;
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
