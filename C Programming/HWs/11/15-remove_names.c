#include "homework_tools.c"


int
get_words (char **words, char *text, size_t text_len)
{
  int words_count = 0;
  char *text_end = text + text_len;
  char *word_begin = 0;

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
          *text = 0;
          words[words_count++] = word_begin;
          word_begin = 0;
        }

      ++text;
    }

  if (word_begin)
    {
      words[words_count++] = word_begin;
    }

  return words_count;
}


int
filter_words (char **words, int words_count,
              char **filters, int filters_count)
{
  int result_count = 0;

  int word_index;
  for (word_index = 0;
       word_index < words_count;
       ++word_index)
    {
      char *word = words[word_index];
      int keep_word = 1;

      int filter_index;
      for (filter_index = 0;
           filter_index < filters_count;
           ++filter_index)
        {
          if (!strcmp (word, filters[filter_index]))
            {
              keep_word = 0;
              break;
            }
        }

      if (keep_word)
        {
          words[result_count++] = word;
        }
    }

  return result_count;
}


void
print_words (char **words, int count)
{
  if (count > 0)
    {
      printf ("%s", words[0]);

      int word_index;
      for (word_index = 1;
           word_index < count;
           ++word_index)
        {
          printf (" %s", words[word_index]);
        }

      printf ("\n");
    }
}


int
main (int argc, char *argv[])
{
  printf ("names: ");
  size_t names_line_len;
  char *names_line = input_line (&names_line_len);

  printf ("remove names: ");
  size_t remove_names_line_len;
  char *remove_names_line = input_line (&remove_names_line_len);

  int names_count = count_words (names_line, names_line_len);
  int remove_names_count = count_words (remove_names_line, remove_names_line_len);

  char *names[names_count];
  char *remove_names[remove_names_count];

  get_words (names, names_line, names_line_len);
  get_words (remove_names, remove_names_line, remove_names_line_len);

  names_count = filter_words (names, names_count, remove_names, remove_names_count);
  print_words (names, names_count);

  free (names_line);            /* pointless freeing of memory */
  free (remove_names_line);     /* pointless freeing of memory */

  return 0;
}
