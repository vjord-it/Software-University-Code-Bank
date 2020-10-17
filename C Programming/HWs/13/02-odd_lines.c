#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("filename: ");
  char *filepath  = input_line (0);
  FILE *text_file = checked_fopen (filepath, "r");
  free (filepath);

  int odd = 0;

  while (!feof (text_file))
    {
      size_t line_len;
      char *line = get_line (text_file, &line_len);

      if (line_len && odd)
        {
          checked_fwrite (line, line_len, stdout);
        }

      free (line);
      odd = !odd;
    }

  fclose (text_file);

  return 0;
}
