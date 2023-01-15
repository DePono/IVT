import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    public static void main(String[] args) {
        // задание 1
/*        Vehicle auto = new Auto("Porsche", 50);
        Thread thread0 = new Thread0(auto);
        thread0.setPriority(Thread.MAX_PRIORITY);
        Thread thread1 = new Thread1(auto);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread0.start();*/
        // Задание 2
/*        Auto auto = new Auto("SomeMark",10);
        VehicleSynchronizer vehicleSynchronizer = new VehicleSynchronizer(auto);
        Thread20 thread20 = new Thread20(vehicleSynchronizer);
        Thread21 thread21 = new Thread21(vehicleSynchronizer);
        Thread thread = new Thread(thread20);
        Thread thread1 = new Thread(thread21);
        thread.start();
        thread1.start();*/
// Задание 3
/*        Lock lock = new ReentrantLock();
        Vehicle auto3 = new Auto("AUDI", 10);
        Thread thread30 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Поток 30+ начал свою работу");
                for (int i = 0; i < auto3.getSizeModelArray(); i++) {
                    System.out.println("Поток 30 выводит модель " + auto3.getAllModelNames()[i]);
                }
            } catch (Exception e) {
                throw new RuntimeException();
            } finally {
                String text = "Поток 30 завершил работу";
                System.out.println(text);
                lock.unlock();
            }
        });
        Thread thread31 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("Поток 31 начал свою работу");
                    for (int i = 0; i < auto3.getSizeModelArray(); i++) {
                        System.out.println("Поток 31 выводит цену модели и она равна " + auto3.getAllModelPrices()[i]);
                    }
                } catch (Exception e) {
                    throw new RuntimeException();
                } finally {
                    String text = "Поток 31 завершил работу";
                    System.out.println(text);
                    lock.unlock();
                }
            }
        });
        thread30.start();
        thread31.start();*/
        //Задание 5
/*        String [] names_of_auto = {"AUDI","Bentley","BMW","Jaguar","Renault",};
        BlockingQueue<String> drop = new ArrayBlockingQueue<>(1);*/
}
}







