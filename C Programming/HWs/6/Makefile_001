CC = gcc
CFLAGS = -g -Wall
PROGRAMS = 01-bigger_number 02-last_digit_of_number 03-last_occurrence_of_character 04-reverse_number 05-array_manipulation/main 06-first_larger_than_neighbors 07-recursive_string_reverse

all: $(PROGRAMS)

01-bigger_number: 01-bigger_number.c
	$(CC) $(CFLAGS) -o $@ $<

02-last_digit_of_number: 02-last_digit_of_number.c
	$(CC) $(CFLAGS) -o $@ $<

03-last_occurrence_of_character: 03-last_occurrence_of_character.c
	$(CC) $(CFLAGS) -o $@ $<

04-reverse_number: 04-reverse_number.c
	$(CC) $(CFLAGS) -o $@ $<

05-array_manipulation/main: 05-array_manipulation/main.c 05-array_manipulation/arr.c 05-array_manipulation/arr.h
	$(CC) $(CFLAGS) -o $@ $^

06-first_larger_than_neighbors: 06-first_larger_than_neighbors.c
	$(CC) $(CFLAGS) -o $@ $<

07-recursive_string_reverse: 07-recursive_string_reverse.c
	$(CC) $(CFLAGS) -o $@ $<

clean:
	$(RM) $(PROGRAMS)
