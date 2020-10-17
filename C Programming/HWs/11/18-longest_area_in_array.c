#include "homework_tools.c"


int
main (int argc, char *argv[])
{
  printf ("strings count: ");
  int strings_count = input_int ();

  if (strings_count < 1)
    {
      fprintf (stderr, "error: Strings count must be > 0\n");
    }

  size_t current_sequence_string_len;
  char *current_sequence_string = input_line (&current_sequence_string_len);
  int current_sequence_len = 1;

  char *longest_sequence_string = current_sequence_string;
  int longest_sequence_len = 1;

  int string_index;
  for (string_index = 1;
       string_index < strings_count;
       ++string_index)
    {
      size_t string_len;
      char *string = input_line (&string_len);

      if (string_len == current_sequence_string_len &&
          !memcmp (string, current_sequence_string, string_len))
        {
          ++current_sequence_len;
        }
      else
        {
          printf ("CURRENT_SEQUENCE_LEN: %d\n", current_sequence_len);
          printf ("LONGEST_SEQUENCE_LEN: %d\n", longest_sequence_len);
          if (current_sequence_len > longest_sequence_len)
            {
              longest_sequence_string = current_sequence_string;
              longest_sequence_len = current_sequence_len;
            }

          current_sequence_string_len = string_len;
          current_sequence_string = string;
          current_sequence_len = 1;
        }
    }

  if (current_sequence_len > longest_sequence_len)
    {
      longest_sequence_string = current_sequence_string;
      longest_sequence_len = current_sequence_len;
    }


  {
    printf ("%d\n", longest_sequence_len);

    int string_index;
    for (string_index = 0;
         string_index < longest_sequence_len;
         ++string_index)
      {
        printf ("%s\n", longest_sequence_string);
      }
  }

  return 0;
}
