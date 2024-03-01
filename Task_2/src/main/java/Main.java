import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Bean> beans = new ArrayList<>();
        int beansSize = 10;
        for (int i = 0; i < beansSize + 1; i++) {
            Bean bean;
            if (i != beansSize) {
                bean = new Bean();
                beans.add(bean);
                if (i != 0) {
                    bean.setLinkOn(beans.get((i - 1) % beansSize));
                }
            } else {
                beans.get(0).setLinkOn(beans.get(beansSize - 1));
            }
        }

        Runnable simpleTask = () -> {
            Singleton singleton = Singleton.getInstance();
            Bean bean = new Bean();
            while (true) {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable harmfulTask = () -> {
            List<Object> list = new ArrayList<>();
            while (true) {
                list.add(new ArrayList<>(1000000));
            }
        };

        for (int i = 0; i < 10; i++) {
            (new Thread(simpleTask)).start();
        }

        if (args.length > 0) {
            (new Thread(harmfulTask)).start();
        }
    }
}
