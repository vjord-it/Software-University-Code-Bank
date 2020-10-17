#include <stdio.h>


int
main (int argc, char *argv[])
{
  int numbers_count;
  printf ("How many numbers do you want?: ");
  scanf ("%d", &numbers_count);

  numbers_count += 2;

  int number_index;
  for (number_index = 2;
       number_index < numbers_count;
       ++number_index)
    {
      if (number_index % 2)
        {
          printf ("%d ", -number_index);
        }
      else
        {
          printf ("%d ", number_index);
        }

    }

  printf ("\n");

  return 0;
}
