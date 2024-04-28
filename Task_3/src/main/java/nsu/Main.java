package nsu;

import com.sun.jdi.NativeMethodException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Main {
    private record StreamGobbler(InputStream inputStream, Consumer<String> consumer) implements Runnable {

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }

    @SuppressWarnings("deprecation")
    public static void execCommand(String command) {
        long pid = ProcessHandle.current().pid();
        try {
            Process process = Runtime.getRuntime().exec(command);
            StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
            ExecutorService es = Executors.newSingleThreadExecutor();
            es.submit(streamGobbler);
            es.shutdown();
            es.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void memoryEater() {
        Methods methods = new Methods();
        try {
            methods.memoryEater();
        } catch (Throwable t) {
            // сюда не зайдёт потому что native код использует свою кучу
            t.printStackTrace();
        }
    }

    public static void allocateOneKB() {
        Methods methods = new Methods();

//        System.out.println("Max: " + Runtime.getRuntime().maxMemory());
//        System.out.println("Total: " + Runtime.getRuntime().totalMemory());
//        System.out.println("Free: " + Runtime.getRuntime().freeMemory());

        long pid = ProcessHandle.current().pid();
        execCommand("jcmd " + pid + " VM.native_memory baseline");
        long pointer = methods.allocateOneKB();
        System.out.println("Pointer: " + Long.toHexString(pointer));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        execCommand("jcmd " + pid + " VM.native_memory detail.diff");

//        System.out.println("Max: " + Runtime.getRuntime().maxMemory());
//        System.out.println("Total: " + Runtime.getRuntime().totalMemory());
//        System.out.println("Free: " + Runtime.getRuntime().freeMemory());

//        while (true) {
//            try {
//                Thread.sleep(100000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

    public static void brokenChainOfMethods() {
        Methods methods = new Methods();

//        long pid = ProcessHandle.current().pid();
//        execCommand("jstack " + pid + " > threadDump.txt");
        try {
            methods.brokenChainOfMethods();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stringLength() {
        Methods methods = new Methods();
        String string = "Hello";
        int length = methods.stringLength(string);
        System.out.println("String: " + string + "\nLength: " + length);
    }

    public static void callObjectMethod() {
        Methods methods = new Methods();
        SomeClass obj = new SomeClass();
        methods.callObjectMethod(obj);
    }

    public static void changeObjectField() {
        Methods methods = new Methods();

        SomeClass obj = new SomeClass();
        System.out.println("Old: " + obj.field);
        methods.changeObjectField(obj, 4);
        System.out.println("New: " + obj.field);
    }

    public static long allocateStructure() {
        Methods methods = new Methods();
        long pointer = methods.allocateStructure();
        System.out.println("Pointer: " + pointer);
        return pointer;
    }

    public static void getStructureField(long pointer) {
        Methods methods = new Methods();
        int field = methods.getStructureField(pointer);
        System.out.println("Value of struct from Java: " + field);
    }

    public static void freeMemory(long pointer) {
        Methods methods = new Methods();
        methods.freeMemory(pointer);
    }

    public static void main(String[] args) {
//        memoryEater();
//        allocateOneKB();
//        brokenChainOfMethods();
//        stringLength();
//        callObjectMethod();
//        changeObjectField();

//        long pointer = allocateStructure();
//        getStructureField(pointer);
//        freeMemory(pointer);
    }
}
