us_2001.o : ../program/us_2001.c ../program/us_2001.h
	gcc -g -w -c ../program/us_2001.c -o us_2001.o

us_2001_test.o : ../program/us_2001.c ../program/us_2001.h
	gcc -g -w -DTESTING -c ../program/us_2001.c -o us_2001_test.o

utests: us_2001_test.o utests.o
	gcc us_2001_test.o utests.o -o utests

utests.o : utests.c minunit.h ../program/us_2001.h
	gcc -g -w -c utests.c -o utests.o

run: utests
	./utests

clean:
	rm -fv *.o utests us_2001