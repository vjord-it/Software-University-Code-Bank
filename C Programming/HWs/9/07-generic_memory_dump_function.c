#include "homework_tools.c"


#define HEX_ADDR_MAXLEN (((int) (sizeof (size_t) * 2)) + 2)


void
mem_dump (void *memory_p, size_t size, int row_width)
{
  int rows_count = ((size - 1) / row_width) + 1;
  unsigned char *end = memory_p + size;

  int row;
  for (row = 0;
       row < rows_count;
       ++row)
    {
      unsigned char *row_p = memory_p + (row * row_width);
      unsigned char byte = *row_p;
      printf ("%-*p %02x", HEX_ADDR_MAXLEN, row_p, byte);

      size_t bytes_left = end - row_p;
      int current_row_width = (bytes_left < row_width) ? bytes_left : row_width;

      int col;
      for (col = 1;
           col < current_row_width;
           ++col)
        {
          byte = *(row_p + col);
          printf (" %02x", byte);
        }

      printf ("\n");
    }
}


int
main (int argc, char *argv[])
{
  char *text = "I love to break free";
  size_t text_size = strlen (text) + 1;
  mem_dump (text, text_size, 5);

  printf ("\n");

  int array[] = {7, 3, 2, 10, -5};
  mem_dump (array, sizeof (array), 4);

  return 0;
}
