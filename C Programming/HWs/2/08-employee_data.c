#include <stdio.h>
#include <stdint.h>


int
main (int argc, char *argv[])
{
  char *first_name = "Amanda";
  char *last_name = "Jonson";
  unsigned char age = 27;
  unsigned char is_female = 1;
  uint64_t personal_id = 8306112507;
  /* 27560000 is added to the employee number so to save memory space. ;) */
  uint16_t short_employee_number = 3571;
  /* A more simple and less hacky version: */
  /* uint32_t employee_number = 27563571; */

  printf ("First name: %s\n"
          "Last name: %s\n"
          "Age: %d\n",
          first_name,
          last_name,
          age);

  if (is_female)
    {
      printf ("Gender: f\n");
    }
  else
    {
      printf ("Gender: m\n");
    }

  printf ("Personal ID: %ld\n"
          "Unique Employee number: %d\n",
          personal_id,
          27560000 + short_employee_number);

  return 0;
}
