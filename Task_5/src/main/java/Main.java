import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
//        JustClass justClass = new JustClass(10, "Hello");
//        int len = Functions.getLength(justClass.getStringField());
//        System.out.println(len);
//
//        Object res = Functions.callMethod(justClass, "getIntField");
//        if (res != null) {
//            System.out.println("Res: " + (int) res);
//        }
//
//        Functions.changeField(justClass, "intField", 20);
//        res = Functions.callMethod(justClass, "getIntField");
//        if (res != null) {
//            System.out.println("Res: " + (int) res);
//        }
        List<ValueClass> valueClassList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            valueClassList.add(new ValueClass(Random.from(RandomGenerator.getDefault()).nextInt()));
        }
        ValueClass.sort(valueClassList);
        for (int i = 0; i < 20; i++) {
            System.out.println("i: " + i + " " + valueClassList.get(i));
        }
    }
}
