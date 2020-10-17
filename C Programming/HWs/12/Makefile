CC = gcc
CFLAGS = -g -Wall
PROGRAMS = 01-1-first_bit 01-2-bitwise_extract_bit_3 02-extract_bit_from_integer 03-check_a_bit_at_given_position 04-bit_destroyer 05-modify_bit_at_given_position 06-bits_exchange 07-bits_exchange_advanced

all: $(PROGRAMS)

01-1-first_bit: 01-1-first_bit.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

01-2-bitwise_extract_bit_3: 01-2-bitwise_extract_bit_3.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

02-extract_bit_from_integer: 02-extract_bit_from_integer.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

03-check_a_bit_at_given_position: 03-check_a_bit_at_given_position.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

04-bit_destroyer: 04-bit_destroyer.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

05-modify_bit_at_given_position: 05-modify_bit_at_given_position.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

06-bits_exchange: 06-bits_exchange.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

07-bits_exchange_advanced: 07-bits_exchange_advanced.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

clean:
	$(RM) $(PROGRAMS)
