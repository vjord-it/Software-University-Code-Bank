#include "homework_tools.c"


char *program_name;
char *program_usage = "Usage: %s src-file time-offset [dest-file]\n";


void
error_exit (void)
{
  fprintf (stderr, "%s: error: Invalid subtitle format\n", program_name);
  exit (1);
}


int
is_whitespace (char byte)
{
  int result = (byte == ' ' || byte == '\n' || byte == '\r');
  return result;
}


int
is_digit (char byte)
{
  int result = byte >= '0' && byte <= '9';
  return result;
}


int
is_line_end (char byte, FILE *src_file)
{
  int result = (byte == '\n' || (byte == '\r' && fgetc (src_file) == '\n'));
  return result;
}


int
parse_integer (FILE *src_file, char *last_byte)
{
  int byte = EOF;
  int result = 0;

  while (!feof (src_file))
    {
      byte = fgetc (src_file);

      if (is_digit (byte))
        {
          result += (byte - '0');
          result *= 10;
        }
      else
        {
          break;
        }
    }

  *last_byte = byte;
  result *= 0.1;

  return result;
}


int
parse_subtitle_time (FILE *src_file, char *last_byte)
{
  int time = 0;

  time += parse_integer (src_file, last_byte) * 3600000;
  if (*last_byte != ':') error_exit ();
  time += parse_integer (src_file, last_byte) * 60000;
  if (*last_byte != ':') error_exit ();
  time += parse_integer (src_file, last_byte) * 1000;
  if (*last_byte != ',') error_exit ();
  time += parse_integer (src_file, last_byte);

  return time;
}


void
parse_subtitle_text (FILE *dest_file, FILE *src_file)
{
  int line_end = 0;

  while (1)
    {
      int byte = fgetc (src_file);

      if (byte == EOF)
        {
          break;
        }

      if (byte == '\n')
        {
          fputc ('\n', dest_file);

          if (line_end)
            {
              break;
            }

          line_end = 1;
        }
      else if (byte != '\r')
        {
          fputc (byte, dest_file);
          line_end = 0;
        }
    }
}


void
write_time (FILE *dest_file, int time)
{
  int hours = (time / 3600000);
  int minutes = (time / 60000) % 60;
  int seconds = (time / 1000) % 60;
  int milliseconds = time % 1000;

  fprintf (dest_file, "%02d:%02d:%02d,%03d", hours, minutes, seconds, milliseconds);
}


void
offset_subitles (FILE *src_file, FILE *dest_file, int offset)
{
  while (!feof (src_file))
    {
      char last_byte = fgetc (src_file);

      while (is_whitespace (last_byte))
        {
          last_byte = fgetc (src_file);
        }

      if (last_byte == EOF)
        {
          break;
        }

      while (is_digit (last_byte))
        {
          fputc (last_byte, dest_file);
          last_byte = fgetc (src_file);
        }

      if (!is_line_end (last_byte, src_file)) error_exit ();
      fputc ('\n', dest_file);

      int start_time = parse_subtitle_time (src_file, &last_byte);
      if (last_byte != ' ' ||
          fgetc (src_file) != '-' ||
          fgetc (src_file) != '-' ||
          fgetc (src_file) != '>' ||
          fgetc (src_file) != ' ')
        {
          error_exit ();
        }

      int end_time = parse_subtitle_time (src_file, &last_byte);
      if (!is_line_end (last_byte, src_file)) error_exit ();

      write_time (dest_file, start_time + offset);
      fputs (" --> ", dest_file);
      write_time (dest_file, end_time + offset);
      fputc ('\n', dest_file);

      parse_subtitle_text (dest_file, src_file);
    }
}


int
main (int argc, char *argv[])
{
  FILE *dest_file;

  program_name = argv[0];

  if (argc == 2 && strcmp (argv[1], "--help") == 0)
    {
      printf (program_usage, program_name);
      return 0;
    }
  else if (argc == 3)
    {
      dest_file = stdout;
    }
  else if (argc == 4)
    {
      dest_file = checked_fopen (argv[3], "w");
    }
  else
    {
      fprintf (stderr, "%s: error: Invalid arguments\n", program_name);
      fprintf (stderr, program_usage, program_name);
      return 1;
    }

  FILE *src_file = checked_fopen (argv[1], "r");
  int offset = parse_int (argv[2]);
  offset_subitles (src_file, dest_file, offset);

  fclose (src_file);
  fclose (dest_file);

  return 0;
}
