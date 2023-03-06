JCC = javac
JCR = java
JFLAGS = -d out

main: all

all:
	mkdir out
	$(JCC) src/com/griffure/*.java -cp "./src/com/griffure/lib/jogl-all.jar:./src/com/griffure/lib/gluegen-rt.jar:." -d out

run:
	java -cp "./src/com/griffure/lib/jogl-all.jar:./src/com/griffure/lib/gluegen-rt.jar:./out:." Main

clear:
	touch out/lol.class
	rm out/*.class
	rm -d out

clean:
	clear
