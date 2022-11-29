import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Object> arrayBlockingQueue = new ArrayBlockingQueue<>(5);
        //Producer
        new Thread (() -> {
            try {
                try {
                    FileReader fileReader = new FileReader("auto0.txt");
                    try {
                        arrayBlockingQueue.put(VehicleStaticClass.readVehicle(fileReader));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            } finally {

            }
        });
    }
}
