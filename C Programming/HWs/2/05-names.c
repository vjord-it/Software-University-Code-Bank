#include <stdio.h>


int
main (int argc, char *argv[])
{
  char first_name[7] = "Martin";
  char last_name[7] = "LibTec";

  printf ("%s %s\n", first_name, last_name);

  /* As I understand the code above is the expected answer, but the */
  /* following two variants are better in practice: */

  /* char first_name[] = "Martin"; */
  /* char last_name[] = "LibTec"; */

  /* char *first_name = "Martin"; */
  /* char *last_name = "LibTec"; */

  return 0;
}
