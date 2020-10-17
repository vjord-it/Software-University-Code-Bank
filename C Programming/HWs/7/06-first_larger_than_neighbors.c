#include <stdio.h>


int first_larger_than_neighbor (int *array, int len);


int
main (int argc, char *argv[])
{
  int sequence_one[] = {1, 3, 4, 5, 1, 0, 5};
  int sequence_two[] = {1, 2, 3, 4, 5, 6, 6};
  int sequence_three[] = {1, 1, 1};

  int sequence_one_len = sizeof (sequence_one) / sizeof (*sequence_one);
  int sequence_two_len = sizeof (sequence_two) / sizeof (*sequence_two);
  int sequence_three_len = sizeof (sequence_three) / sizeof (*sequence_three);

  printf ("%d\n", first_larger_than_neighbor (sequence_one, sequence_one_len));
  printf ("%d\n", first_larger_than_neighbor (sequence_two, sequence_two_len));
  printf ("%d\n", first_larger_than_neighbor (sequence_three, sequence_three_len));

  return 0;
}


int
first_larger_than_neighbor (int *array, int len)
{
  int result_index = -1;

  /* Check all elements except the first and last, since they don't
     have elements on both sides. */

  int index;
  for (index = 1;
       index < len - 1;
       ++index)
    {
      int element = array[index];
      if (element > array[index - 1] &&
          element > array[index + 1])
        {
          result_index = index;
          break;
        }
    }

  return result_index;
}
