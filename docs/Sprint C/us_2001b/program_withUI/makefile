us_2001b_UI: us_2001b_UI.o
	gcc us_2001b_UI.o -o us_2001b_UI

us_2001b.o : us_2001b_UI.c us_2001b_UI.h
	gcc -g -Wall -Wextra -Wpedantic -Wshadow -Wconversion -c us_2001b_UI.c -o us_2001b_UI.o

run : us_2001b_UI
	./us_2001b_UI

clean:
	rm -fv *.o us_2001b_UI