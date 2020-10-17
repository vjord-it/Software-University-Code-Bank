#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int
main (int argc, char *argv[])
{
  printf ("Please choose a type:\n"
          "1 --> int\n"
          "2 --> double\n"
          "3 --> string\n");

  char input_buffer[2048];

  if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
    {
      fprintf (stderr, "error: No input given\n");
      return 1;
    }

  char *input_begin = input_buffer;
  char *input_end;

  errno = 0;
  long choice = strtol (input_begin, &input_end, 10);
  if (errno || input_end == input_begin || input_end[0] == '.')
    {
      fprintf (stderr, "error: Invalid integer given (errno: %d)\n", errno);
      return 1;
    }
  input_begin = input_end;

  switch (choice)
    {
    case 1:
      {
        printf ("Please enter an integer:\n");

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

        printf ("%ld\n", ++number);

        break;
      }
    case 2:
      {
        printf ("Please enter a double:\n");

        if (!(fgets (input_buffer, sizeof (input_buffer), stdin)))
          {
            fprintf (stderr, "error: No input given\n");
            return 1;
          }

        char *input_begin = input_buffer;
        char *input_end;

        errno = 0;
        double number = strtod (input_begin, &input_end);
        if (errno || input_end == input_begin)
          {
            fprintf (stderr, "error: Invalid number given (errno: %d)\n", errno);
            return 1;
          }

        printf ("%.2lf\n", ++number);

        break;
      }
    case 3:
      {
        printf ("Please enter a string:\n");

        /* Since we may want insert 1 more character to the input
           string, the allowed input by fgets is one byte less than
           the actual buffer (sizeof (input_buffer) - 1). */

        if (!(fgets (input_buffer, (sizeof (input_buffer) - 1), stdin)))
          {
            fprintf (stderr, "error: No input given\n");
            return 1;
          }

        size_t input_length = strnlen (input_buffer, sizeof (input_buffer));

        if (input_buffer[input_length - 2] <= ' ')
          {
            input_buffer[input_length - 2] = '*';
            input_buffer[input_length - 1] = 0;
          }
        else if (input_buffer[input_length - 1] <= ' ')
          {
            input_buffer[input_length - 1] = '*';
            input_buffer[input_length] = 0;
          }
        else
          {
            input_buffer[input_length] = '*';
            input_buffer[input_length + 1] = 0;
          }

        printf ("%s\n", input_buffer);

        break;
      }
    default:
      {
        fprintf (stderr, "error: Invalid choice\n");
        return 1;
      }
    }

  return 0;
}
