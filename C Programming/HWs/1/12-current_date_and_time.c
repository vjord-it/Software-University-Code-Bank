#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int
main (int argc, char *argv[])
{
  time_t current_time = time(NULL);

  char time_string[128];
  strftime (time_string, sizeof (time_string), "%d %B %Y %H:%M:%S",
            localtime (&current_time));

  printf ("%s\n", time_string);

  return 0;
}
