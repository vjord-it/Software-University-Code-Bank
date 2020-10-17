#include <stdio.h>


int
main (int argc, char *argv[])
{
  char *special_chars[] = {"NUL", "SOH", "STX", "ETX", "EOT", "ENQ", "ACK",
                           "BEL", " BS", " HT", " LF", " VT", " FF", " CR",
                           " SO", " SI", "DLE", "DC1", "DC2", "DC3", "DC4",
                           "NAK", "SYN", "ETB", "CAN", " EM", "SUB", "ESC",
                           " FS", " GS", " RS", " US"};

  int ascii_index = 0;

  for (;
       ascii_index < 32;
       ++ascii_index)
    {
      printf ("%s ", special_chars[ascii_index]);
    }
  printf ("\n");

  for (;
       ascii_index < 64;
       ++ascii_index)
    {
      printf ("%3c ", ascii_index);
    }
  printf ("\n");

  for (;
       ascii_index < 96;
       ++ascii_index)
    {
      printf ("%3c ", ascii_index);
    }
  printf ("\n");

  for (;
       ascii_index < 127;
       ++ascii_index)
    {
      printf ("%3c ", ascii_index);
    }
  printf ("DEL\n");

  return 0;
}
