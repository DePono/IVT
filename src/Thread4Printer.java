import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread4Printer implements Runnable {
    private final Vehicle vehicle;
    public Thread4Printer(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    @Override
    public void run() {
        {
            try {
                    System.out.println("Поток " + Thread.currentThread().getName() + "__" +vehicle.getMark());
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Vehicle auto = new Auto("VAZ",5);
        Vehicle auto1 = new Auto("AUDI",5);
        Vehicle moto = new Motorcycle("Suzuki",5);
        Vehicle moto1 = new Motorcycle("Polo's",5);
        threadPool.execute(new Thread4Printer(auto));
        threadPool.execute(new Thread4Printer(auto1));
        threadPool.execute(new Thread4Printer(moto));
        threadPool.execute(new Thread4Printer(moto1));
        threadPool.shutdown();
    }
    }
