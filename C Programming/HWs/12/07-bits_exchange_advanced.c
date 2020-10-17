#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("number: ");
  u32 number = input_uint ();
  printf ("bits a: ");
  u32 bits_a = input_uint ();
  printf ("bits b: ");
  u32 bits_b = input_uint ();
  printf ("bits count: ");
  int bits_count = input_int ();

  if (bits_count < 1)
    {
      fprintf (stderr, "error: Bits count must be > 0\n");
    }

  int left_bits_begin;
  int right_bits_begin;

  if (bits_a < bits_b)
    {
      left_bits_begin = bits_b;
      right_bits_begin = bits_a;
    }
  else
    {
      left_bits_begin = bits_a;
      right_bits_begin = bits_b;
    }

  if (left_bits_begin + bits_count > 32)
    {
      fprintf (stderr, "out of range\n");
      return 0;
    }

  int distance_between = left_bits_begin - right_bits_begin;

  if ((distance_between - bits_count) < 0)
    {
      fprintf (stderr, "overlapping\n");
      return 0;
    }

  u32 bitmask = (1 << bits_count) - 1;
  u32 left_bitmask = bitmask << left_bits_begin;
  u32 right_bitmask = bitmask << right_bits_begin;
  u32 left_bits = number & left_bitmask;
  u32 right_bits = number & right_bitmask;

  number &= ~(left_bitmask | right_bitmask);
  number |= left_bits >> distance_between;
  number |= right_bits << distance_between;

  printf ("%u\n", number);

  return 0;
}
