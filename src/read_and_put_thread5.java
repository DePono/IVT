import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class read_and_put_thread5 implements Runnable {
    private final String fileName;
    private ArrayBlockingQueue<Object> auto_queue;

    public read_and_put_thread5(String fileName, BlockingQueue<String> auto_queue) {
        this.fileName = fileName;
        auto_queue = auto_queue;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String mark = null;
            try {
                mark = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Vehicle auto = new Auto(mark, 2);
            try {
                auto_queue.put(auto);
                System.out.println("Create and put Vehicle ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> auto_queue;
        final String[] fileNames = {
                "auto0.txt",
                "auto1.txt",
                "auto2.txt",
                "auto3.txt",
                "auto4.txt"};
        auto_queue = new ArrayBlockingQueue<String>(1,true);
        for (String fileName:fileNames) {
            new read_and_put_thread5(fileName,auto_queue);
        }
    }
}
