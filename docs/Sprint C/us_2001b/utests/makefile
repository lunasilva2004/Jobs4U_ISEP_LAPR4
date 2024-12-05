us_2001b.o : ../program ../program
	gcc -g -w -c ../program/us_2001b.c -o us_2001b.o

us_2001b_test.o : ../program ../program
	gcc -g -w -DTESTING -c ../program/us_2001b.c -o us_2001b_test.o

utests: us_2001b_test.o utests.o
	gcc us_2001b_test.o utests.o -o utests

utests.o : utests.c minunit.h ../program
	gcc -g -w -c utests.c -o utests.o

run: utests
	./utests

clean:
	rm -fv *.o utests us_2001b