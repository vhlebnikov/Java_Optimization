import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Bean> beans = new ArrayList<>();
        int beansSize = 10;
        beans.add(new Bean());
        for (int i = 1; i < beansSize; i++) {
            Bean bean = new Bean();
            beans.add(bean);
            bean.setLinkOn(beans.get(i - 1));
        }
        beans.get(0).setLinkOn(beans.get(beansSize - 1));

        Runnable sleepingTask = () -> {
            Singleton singleton = Singleton.getInstance();
            Bean bean = new Bean();
            while (true) {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    System.err.println(Thread.currentThread().threadId() + " has been stopped");
                    return;
                }
            }
        };

        Runnable harmfulTask = () -> {
            List<Object> list = new ArrayList<>();
            while (true) {
                list.add(new ArrayList<>(100000));
            }
        };

        for (int i = 0; i < 10; i++) {
            (new Thread(sleepingTask)).start();
        }

        if (args.length > 0) {
            (new Thread(harmfulTask)).start();
        }
//        while (true) {
//            try {
//                Thread.sleep(Long.MAX_VALUE);
//            } catch (InterruptedException e) {
//                System.err.println(Thread.currentThread().threadId() + " has been stopped");
//                return;
//            }
//        }
    }
}
