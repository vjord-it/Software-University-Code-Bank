CC = gcc
CFLAGS = -g -Wall
PROGRAMS = 01-print_file_contents 02-odd_lines 03-line_numbers 04-copy_binary_file 05-slicing_file 06-fix_subtitles

all: $(PROGRAMS)

01-print_file_contents: 01-print_file_contents.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

02-odd_lines: 02-odd_lines.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

03-line_numbers: 03-line_numbers.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

04-copy_binary_file: 04-copy_binary_file.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

05-slicing_file: 05-slicing_file.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

06-fix_subtitles: 06-fix_subtitles.c homework_tools.c
	$(CC) $(CFLAGS) -o $@ $<

clean:
	$(RM) $(PROGRAMS)
