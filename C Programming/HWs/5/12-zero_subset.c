#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[2048];

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  char *input_begin = input_buffer;
  char *input_end;

  errno = 0;
  long a = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }
  input_begin = input_end;

  errno = 0;
  long b = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }
  input_begin = input_end;

  errno = 0;
  long c = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }
  input_begin = input_end;

  errno = 0;
  long d = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }
  input_begin = input_end;

  errno = 0;
  long e = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }


  int subsets_found = 0;

  if (a == 0) {printf ("%ld = 0\n", a); subsets_found = 1;}
  if (b == 0) {printf ("%ld = 0\n", b); subsets_found = 1;}
  if (c == 0) {printf ("%ld = 0\n", c); subsets_found = 1;}
  if (d == 0) {printf ("%ld = 0\n", d); subsets_found = 1;}
  if (e == 0) {printf ("%ld = 0\n", e); subsets_found = 1;}
  if ((a + b) == 0) {printf ("%ld + %ld = 0\n", a, b); subsets_found = 1;}
  if ((a + c) == 0) {printf ("%ld + %ld = 0\n", a, c); subsets_found = 1;}
  if ((a + d) == 0) {printf ("%ld + %ld = 0\n", a, d); subsets_found = 1;}
  if ((a + e) == 0) {printf ("%ld + %ld = 0\n", a, e); subsets_found = 1;}
  if ((b + c) == 0) {printf ("%ld + %ld = 0\n", b, c); subsets_found = 1;}
  if ((b + d) == 0) {printf ("%ld + %ld = 0\n", b, d); subsets_found = 1;}
  if ((b + e) == 0) {printf ("%ld + %ld = 0\n", b, e); subsets_found = 1;}
  if ((c + d) == 0) {printf ("%ld + %ld = 0\n", c, d); subsets_found = 1;}
  if ((c + e) == 0) {printf ("%ld + %ld = 0\n", c, e); subsets_found = 1;}
  if ((d + e) == 0) {printf ("%ld + %ld = 0\n", d, e); subsets_found = 1;}
  if ((a + b + c) == 0) {printf ("%ld + %ld + %ld = 0\n", a, b, c); subsets_found = 1;}
  if ((a + b + d) == 0) {printf ("%ld + %ld + %ld = 0\n", a, b, d); subsets_found = 1;}
  if ((a + b + e) == 0) {printf ("%ld + %ld + %ld = 0\n", a, b, e); subsets_found = 1;}
  if ((a + c + d) == 0) {printf ("%ld + %ld + %ld = 0\n", a, c, d); subsets_found = 1;}
  if ((a + c + e) == 0) {printf ("%ld + %ld + %ld = 0\n", a, c, e); subsets_found = 1;}
  if ((a + d + e) == 0) {printf ("%ld + %ld + %ld = 0\n", a, d, e); subsets_found = 1;}
  if ((b + c + d) == 0) {printf ("%ld + %ld + %ld = 0\n", b, c, d); subsets_found = 1;}
  if ((b + c + e) == 0) {printf ("%ld + %ld + %ld = 0\n", b, c, e); subsets_found = 1;}
  if ((b + d + e) == 0) {printf ("%ld + %ld + %ld = 0\n", b, d, e); subsets_found = 1;}
  if ((c + d + e) == 0) {printf ("%ld + %ld + %ld = 0\n", c, d, e); subsets_found = 1;}
  if ((a + b + c + d) == 0) {printf ("%ld + %ld + %ld + %ld = 0\n", a, b, c, d); subsets_found = 1;}
  if ((a + b + c + e) == 0) {printf ("%ld + %ld + %ld + %ld = 0\n", a, b, c, e); subsets_found = 1;}
  if ((a + b + d + e) == 0) {printf ("%ld + %ld + %ld + %ld = 0\n", a, b, d, e); subsets_found = 1;}
  if ((a + c + d + e) == 0) {printf ("%ld + %ld + %ld + %ld = 0\n", a, c, d, e); subsets_found = 1;}
  if ((b + c + d + e) == 0) {printf ("%ld + %ld + %ld + %ld = 0\n", b, c, d, e); subsets_found = 1;}
  if ((a + b + c + d + e) == 0) {printf ("%ld + %ld + %ld + %ld + %ld = 0\n", a, b, c, d, e); subsets_found = 1;}

  if (!subsets_found)
    {
      printf ("no zero subsets\n");
    }

  return 0;
}
