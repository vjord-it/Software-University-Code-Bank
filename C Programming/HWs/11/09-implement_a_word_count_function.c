#include <stdio.h>


int
count_words (char *string, char delimiter)
{
  int word_count = 1;

  while (1)
    {
      char current_char = *string;

      if (!current_char)
        {
          break;
        }

      if (current_char == delimiter)
        {
          ++word_count;
        }

      ++string;
    }

  return word_count;
}


int
main (int argc, char *argv[])
{
  printf ("%d\n", count_words ("Hard Rock, Hallelujah!", ' '));
  printf ("%d\n", count_words ("Hard Rock, Hallelujah!", ','));
  printf ("%d\n", count_words ("Uncle Sam wants you Man", ' '));
  printf ("%d\n", count_words ("Beat the beat!", '!'));

  return 0;
}
