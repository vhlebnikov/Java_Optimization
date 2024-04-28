package nsu;

import com.sun.jdi.NativeMethodException;

public class Main {
    public static void main(String[] args) {
        Methods methods = new Methods();

//        try {
//            methods.memoryEater();
//        } catch (OutOfMemoryError e) {
//            // сюда не зайдёт потому что native код использует свою кучу
//            System.err.println("Memory limit exceeded");
//        }

//        System.out.println("Max: " + Runtime.getRuntime().maxMemory());
//        System.out.println("Total: " + Runtime.getRuntime().totalMemory());
//        System.out.println("Free: " + Runtime.getRuntime().freeMemory());
//        long pointer = methods.allocateOneKB();
//        System.out.println("Pointer: " + pointer);
//        System.out.println("Max: " + Runtime.getRuntime().maxMemory());
//        System.out.println("Total: " + Runtime.getRuntime().totalMemory());
//        System.out.println("Free: " + Runtime.getRuntime().freeMemory());

        try {
            methods.brokenChainOfMethods();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        SomeClass someClass = new SomeClass();
//        methods.callObjectMethod(someClass);

//        SomeClass obj = new SomeClass();
//        System.out.println("Old: " + obj.field);
//        methods.changeObjectField(obj, 4);
//        System.out.println("New: " + obj.field);

    }
}
