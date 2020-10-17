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

  while (!feof (in_file))
    {
      char buffer[4096];
      size_t bytes_read = checked_fread (buffer, sizeof (buffer), in_file);

      if (bytes_read)
        {
          checked_fwrite (buffer, bytes_read, out_file);
        }
    }

  fclose (in_file);
  fclose (out_file);

  return 0;
}
