#include <stdio.h>


int
main (int argc, char *argv[])
{

  int card_num;
  for (card_num = 2;
       card_num <= 14;
       ++card_num)
    {
      char card_num_string[3] = {};

      switch (card_num)
        {
        case 10:
          card_num_string[0] = '1';
          card_num_string[1] = '0';
          break;
        case 11:
          card_num_string[0] = 'J';
          break;
        case 12:
          card_num_string[0] = 'Q';
          break;
        case 13:
          card_num_string[0] = 'K';
          break;
        case 14:
          card_num_string[0] = 'A';
          break;
        default:
          card_num_string[0] = '0' + card_num;
        }

      int card_color;
      for (card_color = 0;
           card_color < 4;
           ++card_color)
        {
          switch (card_color)
            {
            case 0:
              printf ("%sC ", card_num_string);
              break;
            case 1:
              printf ("%sD ", card_num_string);
              break;
            case 2:
              printf ("%sH ", card_num_string);
              break;
            case 3:
              printf ("%sS ", card_num_string);
              break;
            }
        }
      printf ("\n");
    }

  return 0;
}
