#include "homework_tools.c"


typedef struct {
  char *name;
  unsigned int age;
  double balance;
} Client;


typedef int (*Comparator) (Client *, Client *);


int
age_comparator (Client *client_a, Client *client_b)
{
  int result = 0;

  if (client_a->age > client_b->age)
    {
      result = 1;
    }
  else if (client_a->age < client_b->age)
    {
      result = -1;
    }

  return result;
}


int
balance_comparator (Client *client_a, Client *client_b)
{
  int result = 0;

  if (client_a->balance > client_b->balance)
    {
      result = 1;
    }
  else if (client_a->balance < client_b->balance)
    {
      result = -1;
    }

  return result;
}


int
name_comparator (Client *client_a, Client *client_b)
{
  int result = strcmp (client_a->name, client_b->name);

  return result;
}


void
quick_sort_clients (Client *clients, int start_index, int end_index,
                    Comparator comparator)
{
  if (start_index < end_index)
    {
      /* All values smaller than the pivot will be put behind the
         divider index. */
      int divider_index = start_index;

      {
        Client *end_client = clients + end_index; /* pivot */
        int index;
        for (index = start_index;
             index < end_index;
             ++index)
          {
            Client *client = clients + index;
            if (comparator (client, end_client) < 0)
              {
                Client client_tmp = *client;
                clients[index] = clients[divider_index];
                clients[divider_index] = client_tmp;
                ++divider_index;
              }
          }

        Client end_client_tmp = *end_client;
        clients[end_index] = clients[divider_index];
        clients[divider_index] = end_client_tmp;
      }

      quick_sort_clients (clients, start_index, divider_index - 1, comparator);
      quick_sort_clients (clients, divider_index + 1, end_index, comparator);
    }
}


void
sort_clients (Client *clients, int len, Comparator comparator)
{
  quick_sort_clients (clients, 0, len - 1, comparator);
}


void
print_clients (Client *clients, int len)
{
  printf ("+------------------+-----+-----------------+\n"
          "|       name       | age |     balance     |\n"
          "+------------------+-----+-----------------+\n");

  int index;
  for (index = 0;
       index < len;
       ++index)
    {
      Client *client = clients + index;
      printf ("| %16s | %3d | %15.2lf |\n",
              client->name, client->age, client->balance);;
    }

  printf ("+------------------+-----+-----------------+\n");
}


int
main (int argc, char *argv[])
{
  Client clients[] = {
    {"Richard Stallman", 62, 14030.81},
    {"Marilyn Manson", 46, 789123456.78},
    {"Ton Roosendaal", 55, 4418.00},
    {"Guts", 32, 230.30},
    {"Vash", 131, 120000000000.00},
    {"Finn", 16, 3404.40},
    {"Jake", 34, 6595.63},
  };

  printf ("\n* Unsorted\n");
  print_clients (clients, ARRAY_LEN (clients));

  printf ("\n* By Age\n");
  sort_clients (clients, ARRAY_LEN (clients), age_comparator);
  print_clients (clients, ARRAY_LEN (clients));

  printf ("\n* By Balance\n");
  sort_clients (clients, ARRAY_LEN (clients), balance_comparator);
  print_clients (clients, ARRAY_LEN (clients));

  printf ("\n* By Name\n");
  sort_clients (clients, ARRAY_LEN (clients), name_comparator);
  print_clients (clients, ARRAY_LEN (clients));

  return 0;
}
