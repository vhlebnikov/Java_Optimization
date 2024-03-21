import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        runCCode();
        runJavaCode();
    }

    @SuppressWarnings("deprecation")
    public static void runCCode() throws IOException, InterruptedException {
        String cCodePath = "src/main/java/main.c";
        String exePath = "app.exe";


        Runtime.getRuntime().exec(String.format("cmd /c gcc %s -o %s", cCodePath, exePath));
        Thread.sleep(2000);

        Process process = Runtime.getRuntime().exec("./" + exePath);

        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(streamGobbler);
        es.shutdown();
        es.close();
    }

    public static void runJavaCode() {
        int[] dimensions = new int[]{128, 1024};
        System.out.println("Test from Java code:");
        for (int dimension : dimensions) {
            int[][] matrix = new int[dimension][dimension];
            int[][] result = new int[dimension][dimension];

            for (int i = 0; i < dimension; i++) {
                matrix[i] = new int[dimension];
                result[i] = new int[dimension];
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = i * dimension + j + 1;
                }
            }
            long start = System.nanoTime();

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < dimension; k++) {
                        result[i][j] += matrix[i][k] * matrix[k][j];
                    }
                }
            }

            double elapsed_time = (double) (System.nanoTime() - start) / 1000000000;
            System.out.printf("Result for %d x %d matrix multiplication: %f seconds\n", dimension, dimension, elapsed_time);
        }
    }

    private record StreamGobbler(InputStream inputStream, Consumer<String> consumer) implements Runnable {

        @Override
            public void run() {
                new BufferedReader(new InputStreamReader(inputStream)).lines()
                        .forEach(consumer);
            }
        }
}

