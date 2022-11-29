import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class BlockingQueueExample
{
    private final BlockingQueue<String> drop;

    private final String DONE = "done";
    private final String[] createFiles = {
            "auto",
            "auto2",
            "auto3",
            "auto4",
            "auto5"};
    public BlockingQueueExample()
    {
        drop = new ArrayBlockingQueue<>(1, true);
        (new Thread(new Producer())).start();
        (new Thread(new Consumer())).start();
    }

    class Producer implements Runnable
    {
        public void run() {
            try {
                int cnt = 0;
                for (String createFile : createFiles) {
                    drop.put(createFile);
                    if (++cnt < 3)
                        Thread.sleep(2000);
                }
                drop.put(DONE);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    class Consumer implements Runnable
    {
        public void run() {
            try {
                String msg;
                while (!((msg = drop.take()).equals(DONE)))
                    System.out.println(msg);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new BlockingQueueExample();
    }
}