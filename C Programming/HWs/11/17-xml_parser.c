#include "homework_tools.c"


int
is_identifier_char (char byte)
{
  int result = 0;

  if ((byte >= 'a' && byte <= 'z') ||
      (byte >= 'A' && byte <= 'Z') ||
      (byte >= '0' && byte <= '9') ||
      byte == '_' ||
      byte == '-')
    {
      result = 1;
    }

  return result;
}


char *
get_tag_end (char *text, char *text_end)
{
  char *tag_end = 0;

  if (is_identifier_char(*(text++)))
    {
      while (text < text_end)
        {
          char byte = *text;

          if (!is_identifier_char(byte))
            {
              if (byte == '>')
                {
                  tag_end = text;
                }

              break;
            }

          ++text;
        }
    }

  return tag_end;
}


char *
get_opening_tag (char *text, char *text_end, size_t *opening_tag_len)
{
  char *opening_tag = 0;

  for (;
       text < text_end;
       ++text)
    {
      if (*text == '<')
        {
          opening_tag = text + 1;
          char *tag_end = get_tag_end (opening_tag, text_end);

          if (tag_end)
            {
              *opening_tag_len = tag_end - opening_tag;
            }
          else
            {
              opening_tag = 0;
            }

          break;
        }
    }

  return opening_tag;
}


char *
get_closing_tag (char *text, char *text_end, size_t *closing_tag_len)
{
  char *tag = 0;

  for (;
       text < text_end;
       ++text)
    {
      if (*text == '<' && (text + 1) < text_end && *(text + 1) == '/')
        {
          tag = text + 2;
          char *tag_end = get_tag_end (tag, text_end);

          if (tag_end)
            {
              *closing_tag_len = tag_end - tag;
            }
          else
            {

              tag = 0;
            }

          break;
        }
    }

  return tag;
}


void
parse_xml (char *text, size_t text_len)
{
  char *text_end = text + text_len;

  size_t opening_tag_len;
  char *opening_tag = get_opening_tag (text, text_end, &opening_tag_len);
  if (!opening_tag)
    {
      fprintf (stderr, "error: Invalid format\n");
      return;
    }
  text = opening_tag + opening_tag_len;

  char *data = text + 1;

  size_t closing_tag_len;
  char *closing_tag = get_closing_tag (text, text_end, &closing_tag_len);
  if (!closing_tag)
    {
      fprintf (stderr, "error: Invalid format\n");
      return;
    }

  if (memcmp (opening_tag, closing_tag, closing_tag_len))
    {
      fprintf (stderr, "error: Invalid format\n");
      return;
    }

  size_t data_len = (closing_tag - 2) - data;

  char opening_capital_char = (toupper(*opening_tag));

  printf ("%c%.*s: %.*s\n",
          opening_capital_char, (int) opening_tag_len - 1, opening_tag + 1,
          (int) data_len, data);
}


int
main (int argc, char *argv[])
{
  printf ("xml:\n");

  while (1)
    {
      size_t text_len;
      char *text = input_line (&text_len);

      if (text_len)
        {
          parse_xml (text, text_len);
        }
      else
        {
          break;
        }

      free (text);
    }


  return 0;
}
