import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Thread65 implements Runnable {
    private final FileReader fileReader;
    private final ArrayBlockingQueue autoArray;

    public Thread65 (FileReader fileReader, ArrayBlockingQueue autoArray) {
        this.fileReader = fileReader;
        this.autoArray = autoArray;
    }
    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String mark = null;
        try {
            mark = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Vehicle auto = new Auto(mark, 2);
        try {
            autoArray.put(auto);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Добавил в очередь " + auto.getMark());
        System.out.println("Размер очереди " + autoArray.size());
    }



    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(6);
        final String[] fileNames = {
                "auto0.txt",
                "auto1.txt",
                "auto2.txt",
                "auto3.txt",
                "auto4.txt",
        };
        for (String fileName : fileNames) {
            FileReader fileReader = new FileReader(fileName);
            Thread65 thread65 = new Thread65(fileReader,arrayBlockingQueue);
            new Thread(thread65).start();
        }
        while (arrayBlockingQueue.size()!=0){
            System.out.println("Забрал из очереди " + arrayBlockingQueue.take());
            System.out.println("В очереди " + arrayBlockingQueue.size());
        }
    }
}
