package nsu;

public class SomeClass {
    public int field = 10;

    public void someMethod(String text) {
        System.out.println("Text from C: " + text + "\n" +
                "Field value: " + this.field);
    }
}
