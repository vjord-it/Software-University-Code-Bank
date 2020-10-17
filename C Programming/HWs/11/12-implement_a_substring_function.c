#include "homework_tools.c"


char *
substr (char *text, size_t begin, size_t len)
{
  size_t text_len = strlen (text);
  char *result;

  if (begin < text_len)
    {
      size_t remaining_text_len = text_len - begin;

      if (remaining_text_len < len)
        {
          len = remaining_text_len;
        }

      result = checked_malloc (len + 1);
      strncpy (result, text + begin, len);
    }
  else
    {
      result = checked_malloc (1);
      *result = 0;
    }

  return result;
}

int
main (int argc, char *argv[])
{
  printf ("%s\n", substr ("Breaking Bad", 0, 2));
  printf ("%s\n", substr ("Maniac", 3, 3));
  printf ("%s\n", substr ("Maniac", 3, 5));
  printf ("%s\n", substr ("Master Yoda", 13000, 5));

  return 0;
}
