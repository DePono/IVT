import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
public class BlockingQueueExample {
    public static void main(String[] args) {

    final String[] fileNames = {
            "auto0.txt",
            "auto1.txt",
            "auto2.txt",
            "auto3.txt",
            "auto4.txt",
    };
        ArrayBlockingQueue <Object> autoQueue = new ArrayBlockingQueue<>(1);

        new Thread(() -> {
            try {
                for (String fileName : fileNames) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
                    String mark = bufferedReader.readLine();
                    Vehicle auto = new Auto(mark, 2);
                    autoQueue.put(auto);
                    System.out.println("Добавил в очередь " + auto.getMark());
                    System.out.println("размер очереди " + autoQueue.size());
                }
            } catch (IOException | InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }).start();
        new Thread(() -> {
            while (true){
                try {
                    Vehicle auto = (Vehicle) autoQueue.take();
                    System.out.println("Забрал из очереди марку авто " + auto.getMark());
                    System.out.println("размер очереди " + autoQueue.size());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }}}
        ).start();
    }
    }
