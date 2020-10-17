#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  int array_len = 10;
  int *array = checked_malloc (array_len * sizeof (int));
  *(array) = 5;
  *(array + 1) = 6;
  *(array + 2) = 7;
  *(array + 3) = 8;
  *(array + 4) = 9;
  *(array + 5) = 10;
  *(array + 6) = 11;
  *(array + 7) = 12;
  *(array + 8) = 13;
  *(array + 9) = 14;

  if (array_len > 0)
    {
      printf ("%d", *(array));

      int index;
      for (index = 1;
           index < array_len;
           ++index)
        {
          printf (" %d", *(array + index));
        }

      printf ("\n");
    }

  free (array);                 /* pointless freeing of memory */

  return 0;
}
