JCC = javac
JCR = java
JFLAGS = -d out

main: all

all:
	mkdir out
	$(JCC) src/com/animware/*.java -d out

run:
	java -cp "./out" Main

clear:
	touch out/lol.class
	rm out/*.class
	rm -d out

clean:
	clear
