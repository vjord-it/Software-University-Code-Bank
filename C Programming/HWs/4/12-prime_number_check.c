#include <stdio.h>


int
main (int argc, char *argv[])
{
  int nums[] = {1, 2, 3, 4,9, 97, 51, -3, 0};

  printf ("+-------+-------+\n"
          "|   n   | prime |\n"
          "+-------+-------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (nums) / sizeof (nums)[0]);
       ++num_index)
    {
      int num = nums[num_index];
      char *is_prime = "true";

      if (num < 2 || num > 100)
        {
          is_prime = "false";
        }
      else if (num != 2)
        {
          is_prime = "true";

          int check_num;
          for (check_num = 2;
               check_num * check_num <= num;
               ++check_num)
            {
              if (num % check_num == 0)
                {
                  is_prime = "false";
                  break;
                }
            }
        }

      printf ("| %5d | %-5s |\n", num, is_prime);
    }

  printf ("+-------+-------+\n");

  return 0;
}
