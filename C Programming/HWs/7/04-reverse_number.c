#include "homework_tools.c"


double reverse (char *num_string, int *error);


int
main (int argc, char *argv[])
{
  char num_string[4096];
  printf ("num: ");
  input_string (num_string, sizeof (num_string));

  int error;
  double reversed_num = reverse (num_string, &error);

  if (error)
    {
      fprintf (stderr, "Invalid format\n");
    }
  else
    {
      printf ("%.3lf\n", reversed_num);
    }

  return 0;
}


double
reverse (char *num_string, int *error)
{
  /* Parse and copy string ot a buffer */
  char num_buffer[128];
  int num_index = 0;
  int float_point_index = -1;
  int is_round = 1;

  while (1)
    {
      if (num_index < sizeof (num_buffer))
        {
          char num_char = num_string[num_index];

          if (num_char >= '0' && num_char <= '9')
            {
              if (float_point_index != -1 && num_char != '0')
                {
                  is_round = 0;
                }
            }
          else if (num_char == '.' && float_point_index == -1)
            {

              float_point_index = num_index;
            }
          else if (num_char <= ' ')
            {
              break;
            }
          else
            {
              *error = 1;
              return -1;
            }

          num_buffer[num_index++] = num_char;
        }
      else
        {
          *error = 2;
          return -1;
        }
    }

  int num_length = num_index;

  if (is_round && float_point_index != -1)
    {
      num_length = float_point_index;
    }

  num_buffer[num_length] = 0;


  /* Reverse */
  int begin = 0;
  int end = num_length - 1;
  int half_length = num_length / 2;
  while (half_length--)
    {
      int tmp_num = num_buffer[end];
      num_buffer[end--] = num_buffer[begin];
      num_buffer[begin++] = tmp_num;
    }


  /* Convert to double */
  char *input_end;
  errno = 0;
  double result = strtod (num_buffer, &input_end);

  if (errno || input_end == num_buffer)
    {
      *error = 3;
    }

  return result;
}
