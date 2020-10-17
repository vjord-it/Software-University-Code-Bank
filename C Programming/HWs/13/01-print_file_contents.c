#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("filename: ");
  char *filepath = input_line (0);
  FILE *text_file = checked_fopen (filepath, "r");
  free (filepath);

  while (!feof (text_file))
    {
      char buffer[4096];
      size_t bytes_read = checked_fread (buffer, sizeof (buffer), text_file);

      if (bytes_read)
        {
          checked_fwrite (buffer, bytes_read, stdout);
        }
    }

  fclose (text_file);

  return 0;
}
