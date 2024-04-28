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

    public static class ValueClass {
        public int value;

        public ValueClass(int value) {
            this.value = value;
        }

        public static void sort(List<ValueClass> values) {
            for (int i = 0; i < values.size(); i++) {
                for (int j = i + 1; j < values.size(); j++) {
                    if (values.get(i).value > values.get(j).value) {
                        int tmp = values.get(i).value;
                        values.get(i).value = values.get(j).value;
                        values.get(j).value = tmp;
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "value=" + value + ';';
        }
    }
}