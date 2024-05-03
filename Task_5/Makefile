.PHONY: byteCode1
byteCode1:
	javac ./src/main/java/*.java
	javap -c -v src/main/java/Functions > bytecode.txt

.PHONY: byteCode2
byteCode2:
	javac ./src/main/java/*.java
	javap -c -v src/main/java/Main src/main/java/ValueClass > bytecode2.txt

.PHONY: recaf
recaf:
	java -jar recaf/recaf-2.21.14-J8-jar-with-dependencies.jar

.PHONY: run
run:
	java -cp src/main/java Main

.DEFAULT_GOAL := run

