#include <stdio.h>


size_t
my_strlen (char *string)
{
  size_t len = 0;

  while (*(string++))
    {
      ++len;
    }

  return len;
}


int
main (int argc, char *argv[])
{
  printf ("%lu\n", my_strlen ("Soft"));
  printf ("%lu\n", my_strlen ("SoftUni"));

  {
    char buffer[10] = {'C', 0, 'B', 'a' , 'b' ,'y'};
    printf ("%lu\n", my_strlen (buffer));
  }

  {
    /* What does this even do? */

    char buffer[] = {'D', 'e', 'r', 'p', '\0'};
    printf ("%lu\n", my_strlen (buffer));
  }

  return 0;
}
