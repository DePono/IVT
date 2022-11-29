import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WriterAndCreatorThread5 implements Runnable{
    private final String fileName;

    public WriterAndCreatorThread5(String fileName, ArrayBlockingQueue arrayBlockingQueue) {
        this.fileName = fileName;
        BlockingQueue<String> drop = new ArrayBlockingQueue<>(5);
    }

    @Override
    public void run() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Vehicle motor = (Vehicle) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
