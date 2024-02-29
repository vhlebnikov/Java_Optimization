import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.Reference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.lang.instrument.Instrumentation;

public class Main {
    public static void main(String[] args) throws IOException {
        long usedMemory = 0, objectSize;

        List<Object> list = new ArrayList<>();
        Path path = Path.of("src/main/resources/data.csv");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        FileWriter fileWriter = new FileWriter(String.valueOf(path), false);
        fileWriter.append("Max, total, free, used, object\n");
        try {
            while (true) {
                list.add(new Integer(2));
                long maxMemory = Runtime.getRuntime().maxMemory();
                long totalMemory = Runtime.getRuntime().totalMemory();
                long freeMemory = Runtime.getRuntime().freeMemory();
                objectSize = totalMemory - freeMemory - usedMemory;
                usedMemory = totalMemory - freeMemory;
                if (objectSize != 0){
                    fileWriter.append(String.valueOf(maxMemory)).append(", ");
                    fileWriter.append(String.valueOf(totalMemory)).append(", ");
                    fileWriter.append(String.valueOf(freeMemory)).append(", ");
                    fileWriter.append(String.valueOf(usedMemory)).append(", ");
                    fileWriter.append(String.valueOf(objectSize)).append("\n");
                }
            }
        } catch (Exception e) {
            fileWriter.flush();
            fileWriter.close();
        }
    }
}
