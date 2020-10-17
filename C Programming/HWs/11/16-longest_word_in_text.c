#include "homework_tools.c"



void
print_longest_word (char *text, size_t len)
{
  int longest_word_len = 0;
  char *longest_word;

  char *word_begin = 0;
  char *text_end = text + len + 1;

  while (text < text_end)
    {
      if (isalnum (*text))
        {
          if (!word_begin)
            {
              word_begin = text;
            }
        }
      else if (word_begin)
        {
          int word_len = text - word_begin;

          if (word_len > longest_word_len)
            {
              longest_word = word_begin;
              longest_word_len = word_len;
            }

          word_begin = 0;
        }

      ++text;
    }

  printf ("\"%.*s\"\n", longest_word_len, longest_word);
}



int
main (int argc, char *argv[])
{
  printf ("text: ");
  size_t text_len;
  char *text = input_line (&text_len);

  print_longest_word (text, text_len);

  free (text);     /* pointless freeing of memory */

  return 0;
}
