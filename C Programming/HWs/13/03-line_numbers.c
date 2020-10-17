#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("input file: ");
  char *in_filepath  = input_line (0);
  FILE *in_file = checked_fopen (in_filepath, "r");
  free (in_filepath);

  printf ("output file: ");
  char *out_filepath  = input_line (0);
  FILE *out_file = checked_fopen (out_filepath, "w");
  free (out_filepath);

  int lines_count = 0;

  while (!feof (in_file))
    {
      size_t line_len;
      char *line = get_line (in_file, &line_len);

      if (line_len)
        {
          fprintf (out_file, "%-3d ", ++lines_count);
          checked_fwrite (line, line_len, out_file);
        }

      free (line);
    }

  fclose (in_file);
  fclose (out_file);

  return 0;
}
