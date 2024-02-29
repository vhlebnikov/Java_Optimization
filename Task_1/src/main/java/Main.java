import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        long usedMemory = 0, objectSize;

//        List<AllocatedObject> list = new ArrayList<>();
        List<AllocatedObject> list = new ArrayList<>(20000);
        Path path = Path.of("src/main/resources/data.csv");

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        FileWriter fileWriter = new FileWriter(String.valueOf(path), false);
        fileWriter.append("Max, Total, Free, Used (total-free), Object\n");

        try {
            while (true) {

                list.add(new AllocatedObject());

                long maxMemory = Runtime.getRuntime().maxMemory();
                long totalMemory = Runtime.getRuntime().totalMemory();
                long freeMemory = Runtime.getRuntime().freeMemory();

                objectSize = totalMemory - freeMemory - usedMemory;
                usedMemory = totalMemory - freeMemory;

                fileWriter.append(String.valueOf(maxMemory)).append(", ");
                fileWriter.append(String.valueOf(totalMemory)).append(", ");
                fileWriter.append(String.valueOf(freeMemory)).append(", ");
                fileWriter.append(String.valueOf(usedMemory)).append(", ");
                fileWriter.append(String.valueOf(objectSize)).append("\n");
            }
        } catch (Exception e) {
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
