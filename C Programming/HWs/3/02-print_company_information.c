#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define FIELD_DEFAULT_SIZE 1024


char *
get_field (char *fieldname, char *missing_value)
{
  char *field_value = 0;
  printf ("%s: ", fieldname);

  /* TODO: Free memory if the process is long running. */
  char *user_input = malloc (FIELD_DEFAULT_SIZE);

  if (fgets (user_input, FIELD_DEFAULT_SIZE, stdin))
    {
      if (user_input[0] && user_input[0] != '\n')
        {
          int last_char_index = strnlen (user_input, FIELD_DEFAULT_SIZE) - 1;

          if (user_input[last_char_index] == '\n')
            {
              user_input[last_char_index] = 0;
            }

          field_value = user_input;
        }
      else
        {
          field_value = missing_value;
        }
    }

  return field_value;
}

int
main (int argc, char *argv[])
{
  char *company_name = get_field ("Company name", "???");
  char *company_address = get_field ("Company address", "(no address)");
  char *company_phone = get_field ("Phone number", "(no phone)");
  char *company_fax = get_field ("Fax number", "(no fax)");
  char *company_web = get_field ("Web site", "(no site)");
  char *manager_first_name = get_field ("Manger first name", "???");
  char *manager_last_name = get_field ("Manger last name", "???");
  char *manager_age = get_field ("Manager age", "???");
  char *manager_phone = get_field ("Manager number", "(no phone)");

  int exit_status = 0;

  if (company_name && company_address && company_phone &&
      company_fax && company_web && manager_first_name &&
      manager_last_name && manager_age && manager_phone)
    {
      printf ("%s\n", company_name);
      printf ("Address: %s\n", company_address);
      printf ("Tel. %s\n", company_phone);
      printf ("Fax: %s\n", company_fax);
      printf ("Web site: %s\n", company_web);
      printf ("Manager: %s %s (age: %s, tel. %s)\n",
              manager_first_name, manager_last_name,
              manager_age, manager_phone);
    }
  else
    {
      fprintf (stderr, "error: Missing fields\n");
      exit_status = 1;
    }

  return exit_status;
}
