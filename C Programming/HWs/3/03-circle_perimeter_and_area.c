#include <stdio.h>
#include <stdlib.h>
#include <errno.h>


#define PI 3.141592653589793
#define TAU 6.283185307179586


int
main (int argc, char *argv[])
{
  char input_buffer[512];

  if (fgets (input_buffer, sizeof (input_buffer), stdin))
    {
      char *invaid_input_part;
      errno = 0;
      double radius = strtod (input_buffer, &invaid_input_part);

      if (!errno)
        {
          if (invaid_input_part != input_buffer)
            {
              double perimeter = TAU * radius; /* circumference */
              double area = PI * radius * radius;

              printf ("perimeter: %.2f\n", perimeter);
              printf ("area: %.2f\n", area);
            }
          else
            {
              fprintf (stderr, "error: Invalid radius number given\n");
            }
        }
      else
        {
          if (errno == ERANGE)
            {
              fprintf (stderr, "error: Radius number has too may digits\n");
            }
          else
            {
              fprintf (stderr, "error: Unknown error occurred (errno %d)\n", errno);
            }
        }
    }
  else
    {
      fprintf (stderr, "error: No input given\n");
    }

  return 0;
}
