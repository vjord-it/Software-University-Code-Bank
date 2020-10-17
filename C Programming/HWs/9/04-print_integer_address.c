#include <stdio.h>


void
print (int num)
{
  printf ("in print(): %p\n", &num);
}


int
main (int argc, char *argv[])
{
  int num = 5;
  printf ("in main():  %p\n", &num);
  print (num);

  printf ("\n"
          "The address of the same value is different in main() and\n"
          "and print() because all values are copied when we pass\n"
          "them as arguments or are returned from a function.  If\n"
          "we want to pass a value without coping it, we must pass\n"
          "a pointer to that value instead.\n");

  return 0;
}
