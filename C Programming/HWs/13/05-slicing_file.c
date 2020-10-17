#include "homework_tools.c"


void
slice_file (char *src_filepath, char *part_filepath_prefix, int parts_count)
{
  FILE *src_file = checked_fopen (src_filepath, "r");

  fseek (src_file, 0, SEEK_END);
  long src_filesize = ftell (src_file);
  fseek (src_file, 0, SEEK_SET);

  long part_size = (src_filesize / parts_count) + 1;

  int part_number;
  for (part_number = 1;
       part_number <= parts_count;
       ++part_number)
    {
      char *part_filepath_format = "%s.part%d";
      size_t part_filepath_size = (strlen (part_filepath_prefix) +
                                   strlen (part_filepath_format) + 16);

      char part_filepath[part_filepath_size];
      sprintf (part_filepath, part_filepath_format,
               part_filepath_prefix, part_number);

      FILE *part_file = checked_fopen (part_filepath, "w");
      long part_size_left = part_size;

      while (part_size_left > 0 && !feof (src_file))
        {
          long buffer_size = 4096;

          if (part_size_left < buffer_size)
            {
              buffer_size = part_size_left;
            }

          char buffer[buffer_size];
          size_t bytes_read = checked_fread (buffer, buffer_size, src_file);

          if (bytes_read)
            {
              part_size_left -= checked_fwrite (buffer, bytes_read, part_file);
            }
        }

      fclose (part_file);
    }

  fclose (src_file);
}


void
assemble_files (char **part_filepaths, size_t part_filepaths_len, char *dest_filepath)
{
  FILE *dest_file = checked_fopen (dest_filepath, "w");

  int part_index;
  for (part_index = 0;
       part_index < part_filepaths_len;
       ++part_index)
    {
      FILE *part_file = checked_fopen (part_filepaths[part_index], "r");

      while (!feof (part_file))
        {
          char buffer[4096];
          size_t bytes_read = checked_fread (buffer, sizeof (buffer), part_file);

          if (bytes_read)
            {
              checked_fwrite (buffer, bytes_read, dest_file);
            }
        }

      fclose (part_file);
    }

  fclose (dest_file);
}


void
help_error_exit (char *program_name)
{
  fprintf (stderr, "error: Invalid arguments\n");
  fprintf (stderr, "Usage: %s src-file part-prefix slices\n", program_name);
  fprintf (stderr, "       %s -a part-file part-file ... dest-file\n", program_name);
  exit (1);
}


int
main (int argc, char *argv[])
{
  if (strcmp (argv[1], "-a") == 0)
    {
      if (argc >= 5)
        {
          char **part_filepaths = argv + 2;
          char *dest_filepath = argv[argc - 1];
          int part_filepaths_count = argc - 3;
          assemble_files (part_filepaths, part_filepaths_count, dest_filepath);
        }
      else
        {
          help_error_exit (argv[0]);
        }
    }
  else if (argc == 4)
    {
      char *src_filepath = argv[1];
      char *part_filepath_prefix = argv[2];
      int parts_count = parse_int(argv[3]);

      if (parts_count < 2 || parts_count > 9999)
        {
          fprintf (stderr, "error: Parts count must be between 2-9999\n");
          help_error_exit (argv[0]);
        }

      slice_file (src_filepath, part_filepath_prefix, parts_count);
    }
  else
    {
      help_error_exit (argv[0]);
    }

  return 0;
}
