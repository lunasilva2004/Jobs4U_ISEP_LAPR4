us_2001_withUI: us_2001_withUI.o
	gcc us_2001_withUI.o -o us_2001_withUI

us_2001.o : ../program/us_2001_withUI.c ../program/us_2001_withUI.h
	gcc -g -w -c us_2001_withUI.c -o us_2001_withUI.o

run : us_2001_withUI
	./us_2001_withUI

clean:
	rm -fv *.o us_2001_withUI

utests.o : ../../testes/utests.c ../../testes/minunit.h
	gcc -g -w -c ../../testes/utests.c -o utests.o