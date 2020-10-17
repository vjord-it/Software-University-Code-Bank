CC = gcc
CFLAGS = -g -Wall
PROGRAMS = 03-print_hello 04-print_name 05-print_numbers 06-print_first_and_last_name 07-square_root 08-print_sequence 12-current_date_and_time 13-age_after_10_years

all: $(PROGRAMS)

03-print_hello: 03-print_hello.c
	$(CC) $(CFLAGS) -o $@ $<

04-print_name: 04-print_name.c
	$(CC) $(CFLAGS) -o $@ $<

05-print_numbers: 05-print_numbers.c
	$(CC) $(CFLAGS) -o $@ $<

06-print_first_and_last_name: 06-print_first_and_last_name.c
	$(CC) $(CFLAGS) -o $@ $<

07-square_root: 07-square_root.c
	$(CC) $(CFLAGS) -o $@ $< -lm

08-print_sequence: 08-print_sequence.c
	$(CC) $(CFLAGS) -o $@ $<

12-current_date_and_time: 12-current_date_and_time.c
	$(CC) $(CFLAGS) -o $@ $<

13-age_after_10_years: 13-age_after_10_years.c
	$(CC) $(CFLAGS) -o $@ $<

clean:
	$(RM) $(PROGRAMS)
