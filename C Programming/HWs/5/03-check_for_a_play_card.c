#include <errno.h>
#include <stdio.h>


int
main (int argc, char *argv[])
{
  char card[4];
  int is_valid_card = 0;

  if (fgets (card, sizeof (card), stdin))
    {
      if (card[1] <= ' ')
        {
          if ((card[0] >= '2' && card[0] <= '9') ||
              (card[0] == 'J') ||
              (card[0] == 'Q') ||
              (card[0] == 'K') ||
              (card[0] == 'A'))
            {
              is_valid_card = 1;
            }
        }
      else if (card[2] <= ' ')
        {
          if (card[0] == '1' && card[1] == '0')
            {
              is_valid_card = 1;
            }
        }

      if (is_valid_card)
        {
          printf ("yes\n");
        }
      else
        {
          printf ("no\n");
        }
    }
  else
    {
      fprintf (stderr, "error: No input given\n");
    }

  return !is_valid_card;
}
