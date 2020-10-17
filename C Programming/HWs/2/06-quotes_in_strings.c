#include <stdio.h>


int
main (int argc, char *argv[])
{
  char *message = "The \"use\" of quotations causes difficulties. \\n, \\t and \\ are also special characters.";
  printf ("%s\n", message);

  return 0;
}
