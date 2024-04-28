.PHONY: build
build:
	javac ./src/main/java/*.java
	jar cvf a.jar ./src/main/java/Main.class ./src/main/java/ClassOne.class \
 		./src/main/java/ClassTwo.class ./src/main/java/ClassThree.class ./src/main/java/ClassFour.class ./src/main/java/ClassFive.class

.DEFAULT_GOAL := build