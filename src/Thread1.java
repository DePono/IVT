public class Thread1 extends Thread{
    private final Vehicle vehicle;

    public Thread1 (Vehicle vehicle) {
        this.vehicle=vehicle;
    }
    public void run (){
        try {
            System.out.println("Поток " + Thread.currentThread().getName()  + " начал работу");
            for (int i = 0; i < vehicle.getSizeModelArray(); i++) {
                System.out.println(Thread.currentThread().getName() + " выводит цену " + vehicle.getAllModelPrices()[i]);
            }
        } catch (Exception e) {

            throw new RuntimeException();
        } finally {
            System.out.println(Thread.currentThread().getName() + " завершил работу");
        }
    }
}
