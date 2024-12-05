us_2001: us_2001.o
	gcc us_2001.o -o us_2001

us_2001.o : ../program/us_2001.c ../program/us_2001.h
	gcc -g -w -c us_2001.c -o us_2001.o

run : us_2001
	./us_2001

clean:
	rm -fv *.o us_2001

utests.o : ../../testes/utests.c ../../testes/minunit.h
	gcc -g -w -c ../../testes/utests.c -o utests.o