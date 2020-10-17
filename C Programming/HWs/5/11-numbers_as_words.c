#include <errno.h>
#include <stdio.h>
#include <stdlib.h>


int
main (int argc, char *argv[])
{
  char input_buffer[1024];

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  char *input_begin = input_buffer;
  char *input_end;

  errno = 0;
  long number = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }

  if (number < 0 || number > 999)
    {
      fprintf (stderr, "error: Number must be between 0 and 999\n");
      return 1;
    }


  char *ones_words[] = {"zero", "one", "two", "three", "four",
                        "five", "six", "seven", "eight", "nine"};

  char *tens_words[] = {"twenty", "thirty", "forty", "fifty",
                        "sixty", "seventy", "eighty", "ninety"};

  char *teens_words[] = {"ten", "eleven", "twelve", "thirteen", "fourteen",
                         "fifteen", "sixteen", "seventeen", "eighteen",
                         "nineteen"};

  int hundreds_digit = number / 100;
  int tens_digit = (number / 10) % 10;
  int ones_digit = number % 10;

  char *result[32] = {};
  int word_count = 0;

  if (number)
    {
      if (hundreds_digit)
        {
          result[word_count++] = ones_words[hundreds_digit];
          result[word_count++] = " hundred";

          if (ones_digit || tens_digit)
            {
              result[word_count++] = " and ";
            }
        }

      if (tens_digit == 1)
        {
          result[word_count++] = teens_words[ones_digit];
        }
      else
        {
          if (tens_digit >= 2)
            {
              result[word_count++] = tens_words[tens_digit - 2];

              if (ones_digit)
                {
                  result[word_count++] = " ";
                }
            }

          if (ones_digit)
            {
              result[word_count++] = ones_words[ones_digit];
            }
        }
    }
  else
    {
      result[word_count++] = "zero";
    }

  /* Print first word capitalized */
  printf ("%c%s", (result[0][0] - 32), (result[0] + 1));

  int word_index;
  for (word_index = 1;
       word_index < word_count;
       ++word_index)
    {
      printf ("%s", result[word_index]);
    }

  printf ("\n");

  return 0;
}
