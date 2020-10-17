#include "homework_tools.c"


int
is_palindrome (char *word, size_t len)
{
  char *word_begin = word;
  char *word_end = word + len - 1;
  int result = 1;

  while (word_begin < word_end)
    {
      if (*word_begin != *word_end)
        {
          result = 0;
          break;
        }
      ++word_begin;
      --word_end;
    }

  return result;
}


int
get_palindromes (char **palindromes, int palindromes_max_count,
                 char *string, size_t string_len)
{
  int palindromes_count = 0;
  char *string_end = string + string_len;
  char *word_begin = 0;

  while (string < string_end)
    {
      if (isalnum (*string))
        {
          if (!word_begin)
            {
              word_begin = string;
            }
        }
      else if (word_begin)
        {
          *string = 0;

          if (is_palindrome (word_begin, string - word_begin))
            {
              palindromes[palindromes_count++] = word_begin;
            }

          word_begin = 0;
        }

      string++;
    }

  if (word_begin && is_palindrome (word_begin, string - word_begin))
    {
      palindromes[palindromes_count++] = word_begin;
    }

  return palindromes_count;
}


int
unique_words (char **words, int count)
{
  char *last_word = words[0];
  int new_len = 1;

  int word_index;
  for (word_index = 1;
       word_index < count;
       ++word_index)
    {
      char *word = words[word_index];
      if (strcmp (word, last_word))
        {
          words[new_len++] = word;
          last_word = word;
        }
    }

  return new_len;
}



int
main (int argc, char *argv[])
{
  printf ("text: ");
  size_t text_len;
  char *text = input_line (&text_len);

  int word_count = count_words (text, text_len);
  char *palindromes[word_count];
  int palindromes_count = get_palindromes (palindromes, word_count, text, text_len);
  sort_strings (palindromes, palindromes_count);
  palindromes_count = unique_words (palindromes, palindromes_count);

  int palindromes_index;
  for (palindromes_index = 0;
       palindromes_index < palindromes_count;
       ++palindromes_index)
    {
      printf ("%s\n", palindromes[palindromes_index]);
    }

  free (text);                  /* Pointless freeing of memory. */

  return 0;
}
