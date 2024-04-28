.PHONY: byteCode1
byteCode1:
	javac ./src/main/java/*.java
	javap -c src/main/java/Functions > bytecode.txt

.PHONY: byteCode2
byteCode2:
	javac ./src/main/java/*.java
	javap -c -v src/main/java/Main > bytecode2.txt

.PHONY: recaf
recaf:
	java -jar recaf/recaf-2.21.14-J8-jar-with-dependencies.jar

