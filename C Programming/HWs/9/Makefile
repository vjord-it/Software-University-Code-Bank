CC = gcc
CFLAGS = -g -Wall
PROGRAMS = 01-swap_numbers 02-array_print 03-print_array_reversed 04-print_integer_address 05-create_new_integer 06-digit_hate 07-generic_memory_dump_function 08-generic_swap_function 09-clients 10-line_reading_function

all: $(PROGRAMS)

01-swap_numbers: 01-swap_numbers.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

02-array_print: 02-array_print.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

03-print_array_reversed: 03-print_array_reversed.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

04-print_integer_address: 04-print_integer_address.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

05-create_new_integer: 05-create_new_integer.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

06-digit_hate: 06-digit_hate.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

07-generic_memory_dump_function: 07-generic_memory_dump_function.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

08-generic_swap_function: 08-generic_swap_function.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

09-clients: 09-clients.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

10-line_reading_function: 10-line_reading_function.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

clean:
	$(RM) $(PROGRAMS)
