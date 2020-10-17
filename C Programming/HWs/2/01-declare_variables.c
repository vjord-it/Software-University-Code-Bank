#include <stdio.h>


int
main (int argc, char *argv[])
{
  unsigned short a = 52130;
  unsigned long b = 8942492113;
  char c = -115;
  unsigned long d = 4825932;
  unsigned char e = 97;
  short f = -10000;
  long long g = -35982859328592389;

  printf ("%u, %lu, %d, %lu, %u, %d, %lld\n",
          a, b, c, d, e, f, g);

  return 0;
}
