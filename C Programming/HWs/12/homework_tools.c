#include <ctype.h>
#include <errno.h>
#include <limits.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define INITIAL_INPUT_LINE_BUFFER_SIZE 64
#define ARRAY_LEN(array) (sizeof (array) / sizeof ((array)[0]))


typedef int32_t   b32;
typedef int8_t     s8;
typedef int16_t   s16;
typedef int32_t   s32;
typedef int64_t   s64;
typedef uint8_t    u8;
typedef uint16_t  u16;
typedef uint32_t  u32;
typedef uint64_t  u64;
typedef float     r32;
typedef double    r64;


void *
checked_malloc (size_t size)
{
  void *result = malloc (size);

  if (!result)
    {
      fprintf (stderr, "error: Failed to allocate memory\n");
      exit (1);
    }

  return result;
}


void *
checked_realloc (void *mem_block, size_t size)
{
  void *result = realloc (mem_block, size);

  if (!result)
    {
      fprintf (stderr, "error: Failed to reallocate memory\n");
      exit (1);
    }

  return result;
}


char
input_char (void)
{
  int result = getc (stdin);

  if (result == EOF)
    {
      fprintf (stderr, "error: No input given\n");
      exit (1);
    }
  else if (result <= ' ')
    {
      fprintf (stderr, "error: Invalid input given\n");
      exit (1);
    }

  while (1)
    {
      int trailing_input = getc (stdin);
      if (trailing_input == EOF || trailing_input == '\n')
        {
          break;
        }
    }

  return (char) result;
}


int
has_text_characters (char *string)
{
  int result = 0;

  int byte_index;
  for (byte_index = 0;
       string[byte_index];
       ++byte_index)
    {
      if ((unsigned char) string[byte_index] > ' ')
        {
          result = 1;
          break;
        }
    }

  return result;
}


size_t
delete_trailing_whitespace (char *string, size_t len)
{
  size_t index = len;

  while (index--)
    {
      if ((unsigned char) string[index] > ' ')
        {
          break;
        }
    }

  size_t new_len = index + 1;
  string[new_len] = 0;

  return new_len;
}


char *
input_line (size_t *length)
{
  char *buffer = checked_malloc (INITIAL_INPUT_LINE_BUFFER_SIZE + 1);
  size_t buffer_size = INITIAL_INPUT_LINE_BUFFER_SIZE;
  size_t read_size = INITIAL_INPUT_LINE_BUFFER_SIZE;
  size_t buffer_offset = 0;
  size_t len;

  while (1)
    {
      buffer[buffer_size] = 1;

      if (!(fgets (buffer + buffer_offset, read_size + 1, stdin)))
        {
          len = buffer_size - read_size;
          break;
        }
      else if (buffer[buffer_size])
        {
          len = buffer_offset + strlen (buffer + buffer_offset);
          break;
        }

      buffer_offset += read_size;
      read_size = buffer_size;
      buffer_size += read_size;
      buffer = checked_realloc (buffer, buffer_size + 1);
    }

  len = delete_trailing_whitespace (buffer, len);
  buffer = checked_realloc (buffer, len + 1);

  if (length)
    {
      *length = len;
    }

  return buffer;
}


long
input_long_int (void)
{
  char *input = input_line (0);
  char *input_end;
  errno = 0;
  long result = strtol (input, &input_end, 10);

  if (errno || input_end == input || has_text_characters (input_end))
    {
      fprintf (stderr, "error: Invalid integer input given\n");
      free (input);
      exit (1);
    }

  free (input);

  return result;
}


int
input_int (void)
{
  long long_num = input_long_int();

  if (long_num > INT_MAX || long_num < INT_MIN)
    {
      fprintf (stderr, "error: Integer input is out of range\n");
      exit (1);
    }

  int result = (int) long_num;

  return result;
}


unsigned int
input_uint (void)
{
  long long_num = input_long_int();

  if (long_num < 0)
    {
      fprintf (stderr, "error: Unsigned integer input is a negative number\n");
      exit (1);
    }

  if (long_num > UINT_MAX)
    {
      fprintf (stderr, "error: Unsigned integer input is out of range\n");
      exit (1);
    }

  unsigned int result = (unsigned int) long_num;

  return result;
}


double
input_double (void)
{
  char *input = input_line (0);
  char *input_end;
  errno = 0;
  double result = strtod (input, &input_end);

  if (errno || input_end == input || has_text_characters (input_end))
    {
      fprintf (stderr, "error: Invalid input number given\n");
      free (input);
      exit (1);
    }

  free (input);

  return result;
}


void
input_array (int *array, int len)
{
  int index;
  for (index = 0;
       index < len;
       ++index)
    {
      array[index] = input_int ();
    }
}


void
input_array_line (int *array, int len)
{
  /* Inputs into an ARRAY exactly LEN amount of integers. */

  char *input = input_line (0);
  char *input_begin = input;
  char *input_end;

  int index;
  for (index = 0;
       index < len;
       ++index)
    {
      errno = 0;
      long long_num = strtol (input_begin, &input_end, 10);

      if (errno || input_end == input_begin)
        {
          fprintf (stderr, "error: Invalid integer input\n");
          free (input);
          exit (1);
        }

      if (long_num > INT_MAX || long_num < INT_MIN)
        {
          fprintf (stderr, "error: Integer input is out of range\n");
          free (input);
          exit (1);
        }

      array[index] = (int) long_num;
      input_begin = input_end;
    }

  if (has_text_characters (input_end))
    {
      fprintf (stderr, "error: Invalid integer line input\n");
      free (input);
      exit (1);
    }

  free (input);
}


int
input_int_line (int *array, int max_len)
{
  /* Inputs into an ARRAY a variable amount of integers up MAX_LEN. */

  char *input = input_line (0);
  char *input_begin = input;
  char *input_end;

  int index;
  for (index = 0;
       index < max_len;
       ++index)
    {
      errno = 0;
      long long_num = strtol (input_begin, &input_end, 10);

      if (errno)
        {
          fprintf (stderr, "error: Invalid integer input\n");
          free (input);
          exit (1);
        }

      if (input_end == input_begin)
        {
          break;
        }

      if (long_num > INT_MAX || long_num < INT_MIN)
        {
          fprintf (stderr, "error: Integer input is out of range\n");
          free (input);
          exit (1);
        }

      array[index] = (int) long_num;
      input_begin = input_end;
    }

  if (has_text_characters (input_end))
    {
      fprintf (stderr, "error: Invalid integer line input\n");
      free (input);
      exit (1);
    }

  if (index == 0)
    {
      fprintf (stderr, "error: Empty integer line input\n");
      free (input);
      exit (1);
    }

  free (input);

  return index;
}


void
input_matrix (int *matrix, int width, int height)
{
  int row;
  for (row = 0;
       row < height;
       ++row)
    {
      int *matrix_row = matrix + row * width;
      input_array_line (matrix_row, width);
    }
}


void
print_binary (void *data, size_t bytes_count)
{
  u8 buffer[bytes_count * 9];
  u8 *buffer_p = buffer;
  u8 *byte_p = data + bytes_count - 1;

  while (bytes_count--)
    {
      u8 bit_mask = 0b10000000;
      u8 byte = *(byte_p--);

      while (bit_mask)
        {
          *(buffer_p++) = (byte & bit_mask) ? '1' : '0';
          bit_mask >>= 1;
        }

      *(buffer_p++) = ' ';
    }

  buffer_p[-1] = 0;

  printf ("%s\n", buffer);
}


void
print_array (int *array, int len)
{
  if (len > 0)
    {
      printf ("%d", array[0]);

      int index;
      for (index = 1;
           index < len;
           ++index)
        {
          printf (" %d", array[index]);
        }
      printf ("\n");
    }
}


void
print_matrix (int *matrix, int width, int height)
{
  int row;
  for (row = 0;
       row < height;
       ++row)
    {
      int *matrix_row = matrix + row * width;
      print_array (matrix_row, width);
    }
}


void
quick_sort_ints (int *array, int start_index, int end_index)
{
  if (start_index < end_index)
    {
      /* All values smaller than the pivot will be put behind the
         divider index. */
      int divider_index = start_index;

      {
        int end_value = array[end_index]; /* pivot */
        int index;
        for (index = start_index;
             index < end_index;
             ++index)
          {
            int value = array[index];
            if (value < end_value)
              {
                array[index] = array[divider_index];
                array[divider_index] = value;
                ++divider_index;
              }
          }

        array[end_index] = array[divider_index];
        array[divider_index] = end_value;
      }

      quick_sort_ints (array, start_index, divider_index - 1);
      quick_sort_ints (array, divider_index + 1, end_index);
    }
}


void
sort_ints (int *array, int len)
{
  quick_sort_ints (array, 0, len - 1);
}


void
quick_sort_strings (char **array, int start_index, int end_index)
{
  if (start_index < end_index)
    {
      /* All values smaller than the pivot will be put behind the
         divider index. */
      int divider_index = start_index;

      {
        char *end_value = array[end_index]; /* pivot */
        int index;
        for (index = start_index;
             index < end_index;
             ++index)
          {
            char *value = array[index];
            if (strcasecmp (value, end_value) < 0)
              {
                array[index] = array[divider_index];
                array[divider_index] = value;
                ++divider_index;
              }
          }

        array[end_index] = array[divider_index];
        array[divider_index] = end_value;
      }

      quick_sort_strings (array, start_index, divider_index - 1);
      quick_sort_strings (array, divider_index + 1, end_index);
    }
}


void
sort_strings (char **strings, int strings_count)
{
  quick_sort_strings (strings, 0, strings_count - 1);
}


int
count_words (char *string, size_t string_len)
{
  int word_count = 0;
  char *string_end = string + string_len;
  int in_word = 0;

  while (string < string_end)
    {
      char string_char = *(string++);

      if (isalnum (string_char))
        {
          in_word = 1;
        }
      else if (in_word)
        {
          ++word_count;
          in_word = 0;
        }
    }

  if (in_word)
    {
      ++word_count;
    }

  return word_count;
}
