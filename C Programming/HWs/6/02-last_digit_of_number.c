#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include "homework_tools.c"


char *get_last_digit_as_word (long num);


int
main (int argc, char *argv[])
{
  printf ("num: ");
  long num = input_long_int ();

  printf ("%s\n", get_last_digit_as_word (num));

  return 0;
}


char *
get_last_digit_as_word (long num)
{
  char *word;

  switch (num % 10)
    {
    case 0:
      word = "zero";
      break;
    case 1:
      word = "one";
      break;
    case 2:
      word = "two";
      break;
    case 3:
      word = "three";
      break;
    case 4:
      word = "four";
      break;
    case 5:
      word = "five";
      break;
    case 6:
      word = "six";
      break;
    case 7:
      word = "seven";
      break;
    case 8:
      word = "eight";
      break;
    case 9:
      word = "nine";
      break;
    }

  return word;
}
