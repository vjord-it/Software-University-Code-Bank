#include <math.h>
#include <stdio.h>


int
main (int argc, char *argv[])
{
  int user_input;
  printf ("Input an integer: ");
  scanf ("%d", &user_input);

  double result = sqrt(user_input);
  printf ("%f\n", result);

  return 0;
}
