us_2001b: us_2001b.o
	gcc us_2001b.o -o us_2001b

us_2001b.o : us_2001b.c us_2001b.h
	gcc -g -Wall -Wextra -Wpedantic -Wshadow -Wconversion -c us_2001b.c -o us_2001b.o

run : us_2001b
	./us_2001b

clean:
	rm -fv *.o us_2001b

utests.o : ../../testes/utests.c ../../testes/minunit.h
	gcc -g -Wall -Wextra -Wpedantic -Wshadow -Wconversion  -c ../../testes/utests.c -o utests.o
