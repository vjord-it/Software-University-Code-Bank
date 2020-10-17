#include <stdio.h>
#include <stdint.h>


int
main (int argc, char *argv[])
{
  char *first_name = "FirstName";
  char *middle_name = "MiddleName";
  char *last_name = "LastName";
  long double balance = -0.50;
  char *bank_name = "The Bank Name";
  char *iban = "1234 BANK 0987654321";
  uint64_t credit_card_numbers[3] = {1234567890, 2345678901, 3456789012};

  printf ("%s %s %s:\n"
          "  %s (%s)\n"
          "    Credit Cards: %ld, %ld, %ld\n"
          "    Balance: %Lf\n",
          first_name, middle_name, last_name,
          bank_name, iban,
          credit_card_numbers[0],
          credit_card_numbers[1],
          credit_card_numbers[2],
          balance);

  return 0;
}
