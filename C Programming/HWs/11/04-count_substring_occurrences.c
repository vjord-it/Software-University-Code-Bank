#include "homework_tools.c"
#include <ctype.h>


int
count_string_occurrences (char *text, size_t text_len,
                          char *search, size_t search_len)
{
  int occurrences = 0;

  int text_index;
  for (text_index = 0;
       text_index < text_len - search_len + 1;
       ++text_index)
    {
      int search_index;
      for (search_index = 0;
           search_index < search_len;
           ++search_index)
        {
          if (tolower (search[search_index]) !=
              tolower (text[text_index + search_index]))
            {
              break;
            }
        }

      if (search_index == search_len)
        {
          ++occurrences;
        }
    }

  return occurrences;
}


int
main (int argc, char *argv[])
{
  printf ("text: ");
  size_t text_len;
  char *text = input_line (&text_len);
  printf ("search: ");
  size_t search_len;
  char *search = input_line (&search_len);

  if (search_len < 1)
    {
      fprintf (stderr, "error: You must input a search string\n");
    }

  int string_occurrences = count_string_occurrences (text, text_len,
                                                     search, search_len);

  printf ("%d\n", string_occurrences);

  free (text);                  /* Pointless freeing of memory. */
  free (search);                /* Pointless freeing of memory. */

  return 0;
}
