import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        long usedMemory = 0, objectSize, maxMemory, freeMemory, totalMemory;

        var list = new ArrayList<AllocatedObject>(20000);
        var i = 1;
        Path path = Path.of("src/main/resources/data.csv");

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        FileWriter fileWriter = new FileWriter(String.valueOf(path), false);
        fileWriter.append("i,Max,Total,Free,Used (total-free),Object\n");

        try {
            while (true) {
                var v = new AllocatedObject();
                list.add(v);

                maxMemory = Runtime.getRuntime().maxMemory();
                totalMemory = Runtime.getRuntime().totalMemory();
                freeMemory = Runtime.getRuntime().freeMemory();

                objectSize = totalMemory - freeMemory - usedMemory;
                usedMemory = totalMemory - freeMemory;

                if (usedMemory != objectSize && objectSize != 0) {
                    fileWriter.append(String.valueOf(i++)).append(",");
                    fileWriter.append(String.valueOf(maxMemory)).append(",");
                    fileWriter.append(String.valueOf(totalMemory)).append(",");
                    fileWriter.append(String.valueOf(freeMemory)).append(",");
                    fileWriter.append(String.valueOf(usedMemory)).append(",");
                    fileWriter.append(String.valueOf(objectSize)).append("\n");
                }
            }
        } catch (Exception e) {
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
