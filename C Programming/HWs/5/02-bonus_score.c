#include <stdio.h>


int
main (int argc, char *argv[])
{
  int scores[] = {2, 4, 9, -1, 10};

  printf ("+---------+----------------+\n"
          "|  score  |     result     |\n"
          "+---------+----------------+\n");

  int num_index;
  for (num_index = 0;
       num_index < (sizeof (scores) / sizeof (scores)[0]);
       ++num_index)
    {
      int score = scores[num_index];
      int result = 0;

      if (score >= 1 && score <= 3)
        {
          result = score * 10;
        }
      else if (score >= 4 && score <= 6)
        {
          result = score * 100;
        }
      else if (score >= 7 && score <= 9)
        {
          result = score * 1000;
        }

      if (result)
        {
          printf ("| %7d | %-14d |\n", score, result);
        }
      else
        {
          printf ("| %7d | invalid score  |\n", score);
        }
    }

  printf ("+---------+----------------+\n");

  return 0;
}
