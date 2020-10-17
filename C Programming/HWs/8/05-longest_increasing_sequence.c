#include "homework_tools.c"


void
copy_array (int *source, int source_len, int *dest)
{
  int current_index = 0;
  while (source_len--)
    {
      dest[current_index] = source[current_index];
      ++current_index;
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


  int longest_sequence[nums_len];
  int current_sequence[nums_len];
  int longest_sequence_len = 0;
  int current_sequence_len = 0;

  int previous_num = nums[0];
  printf ("%d ", previous_num);
  current_sequence[current_sequence_len++] = previous_num;

  {
    int num_index;
    for (num_index = 1;
         num_index < nums_len;
         ++num_index)
      {
        int num = nums[num_index];

        if (num <= previous_num)
          {
            printf ("\n");
            if (current_sequence_len > longest_sequence_len)
              {
                copy_array (current_sequence, current_sequence_len,
                            longest_sequence);
                longest_sequence_len = current_sequence_len;
              }
            current_sequence_len = 0;
          }

        printf ("%d ", num);
        current_sequence[current_sequence_len++] = num;
        previous_num = num;
      }

    printf ("\n");

    if (current_sequence_len > longest_sequence_len)
      {
        copy_array (current_sequence, current_sequence_len,
                    longest_sequence);
        longest_sequence_len = current_sequence_len;
      }
  }


  printf ("Longest: ");
  print_array (longest_sequence, longest_sequence_len);

  return 0;
}
