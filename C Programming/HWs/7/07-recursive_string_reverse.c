#include <stdio.h>


void
reverse (char *input, char *output, int begin, int end)
{
  if (end--)
    {
      output[begin] = input[end];
      reverse (input, output, ++begin, end);
    }
}


int
main (int argc, char *argv[])
{
  char input[] = "Recursion";
  int input_len = sizeof (input) - 1;
  char output[sizeof(input)] = {};

  reverse (input, output, 0, input_len);

  printf ("%s\n", output);

  return 0;
}
