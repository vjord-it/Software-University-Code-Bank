#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int
main (int argc, char *argv[])
{
  srand(time(NULL));

  char input_buffer[4096];
  char *input_end;

  printf ("n: ");
  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  errno = 0;
  long nums_len = strtol (input_buffer, &input_end, 10);

  if (errno || input_end == input_buffer || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  int nums[nums_len];


  {
    int num_index;
    for (num_index = 0;
         num_index < nums_len;
         ++num_index)
      {
        nums[num_index] = num_index + 1;
      }
  }

  {
    int num_index;
    for (num_index = 0;
         num_index < nums_len;
         ++num_index)
      {
        int random_index = num_index + (rand() % (nums_len - num_index));
        printf ("%d ", nums[random_index]);
        nums[random_index] = nums[num_index];
      }
    printf ("\n");
  }


  /* The code below first shuffles and then prints the nums, using 2
     loops. */

  /* { */
  /*   int num_index; */
  /*   for (num_index = 0; */
  /*        num_index < (nums_len - 1); */
  /*        ++num_index) */
  /*     { */
  /*       int random_index = num_index + (rand() % (nums_len - num_index)); */
  /*       int tmp = nums[random_index]; */
  /*       nums[random_index] = nums[num_index]; */
  /*       nums[num_index] = tmp; */
  /*     } */
  /* } */

  /* { */
  /*   int num_index; */
  /*   for (num_index = 0; */
  /*        num_index < nums_len; */
  /*        ++num_index) */
  /*     { */
  /*       printf ("%d ", nums[num_index]); */
  /*     } */
  /*   printf ("\n"); */
  /* } */


  return 0;
}
