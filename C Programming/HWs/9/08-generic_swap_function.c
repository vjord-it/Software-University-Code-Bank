#include <stdio.h>
#include <string.h>


void
swap (void *a, void *b, size_t size)
{
  unsigned char tmp[size];
  memcpy (tmp, a, size);
  memcpy (a, b, size);
  memcpy (b, tmp, size);
}


int
main (int argc, char *argv[])
{
  char letter = 'B';
  char symbol = '+';
  printf ("%c %c\n", letter, symbol);
  swap (&letter, &symbol, sizeof (letter));
  printf ("%c %c\n", letter, symbol);

  int a = 10;
  int b = 6;
  printf ("%d %d\n", a, b);
  swap (&a, &b, sizeof (a));
  printf ("%d %d\n", a, b);

  double d = 3.14;
  double f = 1.234567;
  printf ("%.2lf %.2lf\n", d, f);
  swap (&d, &f, sizeof (d));
  printf ("%.2lf %.2lf\n", d, f);

  return 0;
}
