#include <stdio.h>


int
new_integer (void)
{
  int num = 5;

  return num;
}


int *
new_integer_ptr (void)
{
  int num = 107;
  int *num_ptr = &num;

  return num_ptr;
}


int
main (int argc, char *argv[])
{
  int num = new_integer();
  int *num_ptr = new_integer_ptr();

  printf ("*num_ptr:  %d\n", *num_ptr);
  printf ("num:       %d\n", num);
  printf ("---after calling other functions---\n");
  printf ("*num_ptr:  %d <-- may or may not change unpredictably\n", *num_ptr);
  printf ("num:       %d\n", num);

  printf ("\n"
          "Since the value (the memory) pointed by num_ptr was\n"
          "allocated on the stack in a function which has returned,\n"
          "this value (the memory) MAY be overwritten by subsequent\n"
          "functions.  It's not safe to rely that value pointed by\n"
          "num_ptr will change or not, because it may depened on\n"
          "various factors, such type of operating system, processor\n"
          "type or which compiler was used.  Using the value pointed\n"
          "by num_ptr like this is considered \"undefined behavior\".\n");

  return 0;
}
