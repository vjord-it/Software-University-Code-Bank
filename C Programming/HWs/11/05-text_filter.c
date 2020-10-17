#include "homework_tools.c"


void
filter_text (char *text, size_t text_len, char *filter, size_t filter_len)
{
  while ((text = strstr (text, filter)))
    {
      int filtered_index;
      for (filtered_index = 0;
           filtered_index < filter_len;
           ++filtered_index)
        {
          text[filtered_index] = '*';
        }

      text = text + filter_len;
    }
}


int
main (int argc, char *argv[])
{
  printf ("filters: ");
  size_t filters_input_len;
  char *filters_input = input_line (&filters_input_len);

  printf ("text: ");
  size_t text_len;
  char *text = input_line (&text_len);

  char *filter_begin = filters_input;

  while (1)
    {
      char *filter_end = strstr (filter_begin, ", ");

      if (!filter_end || !filter_end[0])
        {
          char *filters_end = filters_input + filters_input_len;
          filter_text (text, text_len, filter_begin, filters_end - filter_begin);
          break;
        }

      filter_end[0] = 0;
      filter_text (text, text_len, filter_begin, filter_end - filter_begin);
      filter_begin = filter_end + 2;
    }

  printf ("%s\n", text);

  free (filters_input);         /* Pointless freeing of memory. */
  free (text);                  /* Pointless freeing of memory. */

  return 0;
}
