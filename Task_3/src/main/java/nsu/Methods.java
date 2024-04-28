package nsu;

public class Methods {
    static {
        System.loadLibrary("nativeLib");
    }

    public native void memoryEater();
    public native long allocateOneKB();
    public native void brokenChainOfMethods();
    public native int stringLength(String string);
    public native void callObjectMethod(SomeClass object);
    public native void changeObjectField(SomeClass object, int value);
    public native long allocateStructure();
    public native int getStructureField(long structure);
    public native void freeMemory(long structure);
}
