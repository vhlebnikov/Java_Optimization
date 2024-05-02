import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
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