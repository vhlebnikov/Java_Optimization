.PHONY: compileC
compileC:
	gcc ./src/main/c/nsu_Methods.c -shared -O3 -Wl,--add-stdcall-alias -o ./src/main/c/nativeLib.dll -I"C:\\Program Files\\Java\\jdk-19\\include" -I"C:\\Program Files\\Java\\jdk-19\\include\\win32"

.PHONY: generateHeader
generateHeader:
	javac -h ./src/main/c ./src/main/java/nsu/Methods.java ./src/main/java/nsu/SomeClass.java

.PHONY: run
run:
	javac ./src/main/java/nsu/*.java
	java -cp src/main/java -Djava.library.path="C:\Study\3_course\Java_Optimization\Task_3\src\main\c" -XX:NativeMemoryTracking=detail nsu.Main

.PHONY: memCheckstart
memCheckstart:
	jcmd $(PID) VM.native_memory baseline

.PHONY: memCheck
memCheck:
	jcmd $(PID) VM.native_memory detail.diff

.DEFAULT_GOAL := run