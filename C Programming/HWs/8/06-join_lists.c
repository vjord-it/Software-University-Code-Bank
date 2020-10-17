#include "homework_tools.c"


int *
merge_arrays (int *dest, int *source_1, int len_1, int *source_2, int len_2)
{
  int len_sum = len_1 + len_2;

  {
    int index;
    for (index = 0;
         index < len_1;
         ++index)
      {
        dest[index] = source_1[index];
      }
  }

  {
    int index;
    for (index = len_1;
         index < len_sum;
         ++index)
      {
        dest[index] = source_2[index - len_1];
      }
  }

  return dest;
}


int
unique_array (int *array, int len)
{
  int last_num = array[0];
  int new_len = 1;

  int index;
  for (index = 1;
       index < len;
       ++index)
    {
      int num = array[index];
      if (num != last_num)
        {
          array[new_len++] = num;
          last_num = num;
        }
    }

  return new_len;
}


int
main (int argc, char *argv[])
{
  /* Too many nums will cause segmentation fault. */
  printf ("array A numbers count: ");
  int nums1_len = input_int ();
  if (nums1_len < 1)
    {
      fprintf (stderr, "error: Numbers count should be > 0\n");
      return 1;
    }
  int nums1[nums1_len];

  printf ("array B numbers count: ");
  int nums2_len = input_int ();
  if (nums2_len < 1)
    {
      fprintf (stderr, "error: Numbers count should be > 0\n");
      return 1;
    }
  int nums2[nums2_len];


  printf ("numbers:\n");
  input_array (nums1, nums1_len);
  input_array (nums2, nums2_len);

  int nums3_len = nums1_len + nums2_len;
  int nums3[nums3_len];

  merge_arrays (nums3, nums1, nums1_len, nums2, nums2_len);
  sort_array (nums3, nums3_len);
  nums3_len = unique_array (nums3, nums3_len);

  print_array (nums3, nums3_len);

  return 0;
}
