#include "homework_tools.c"


int
is_round (double num)
{
  int result = !(num - (int) num);

  return result;
}


void
print_nums_info (double *nums, int nums_len)
{
  if (nums_len > 0)
    {
      printf ("[");

      double min;
      double max;
      double sum;

      if (nums_len < 1)
        {
          return;
        }

      double num = nums[0];
      min = num;
      max = num;
      sum = num;
      printf (" %.*lf", (is_round (num) ? 0 : 3), num);

      int num_index;
      for (num_index = 1;
           num_index < nums_len;
           ++num_index)
        {
          double num = nums[num_index];
          sum += num;

          if (num < min)
            {
              min = num;
            }

          if (num > max)
            {
              max = num;
            }

          printf (" %.*lf", (is_round (num) ? 0 : 3), num);
        }

      double avg = sum / nums_len;

      printf ("] -> min: %.*lf, max: %.*lf, sum: %.*lf, avg: %.*lf\n",
              (is_round (min) ? 0 : 3), min,
              (is_round (max) ? 0 : 3), max,
              (is_round (sum) ? 0 : 3), sum,
              (is_round (avg) ? 0 : 3), avg);
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

  double round_nums[nums_len];
  double fraction_nums[nums_len];

  int round_nums_len = 0;
  int fraction_nums_len = 0;

  {
    printf ("numbers:\n");

    int num_index;
    for (num_index = 0;
         num_index < nums_len;
         ++num_index)
      {
        double num = input_double ();

        if (is_round (num))
          {
            round_nums[round_nums_len++] = num;
          }
        else
          {
            fraction_nums[fraction_nums_len++] = num;
          }
      }
  }

  print_nums_info (fraction_nums, fraction_nums_len);
  print_nums_info (round_nums, round_nums_len);

  return 0;
}
