.PHONY: build
build:
	javac ./src/main/java/*.java -d src/main/java/classes
	jar cvfe a.jar Main ./src/main/java/classes/*.class -C src/main/java/classes .
	7z d -tzip a.jar src/

.PHONY: javap
javap:
	javap -classpath a_out_max.jar -c -v Main a > a_out_max_bytecode.txt

.DEFAULT_GOAL := build