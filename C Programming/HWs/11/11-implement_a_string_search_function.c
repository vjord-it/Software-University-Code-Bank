#include <stdio.h>


int
string_search (char *text, char *searched)
{
  int result = 0;

  while (*text)
    {
      char *text_p = text;
      char *searched_p = searched;

      while (*text_p && *text_p == *searched_p)
        {
          ++text_p;
          ++searched_p;
        }

      if (!(*searched_p))
        {
          result = 1;
          break;
        }

      ++text;
    }

  return result;
}


int
main (int argc, char *argv[])
{
  printf ("%d\n", string_search ("SoftUni", "Soft"));
  printf ("%d\n", string_search ("Hard Rock", "Rock"));
  printf ("%d\n", string_search ("Ananas", "nasa"));

  return 0;
}
