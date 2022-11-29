public class Thread1 extends Thread{
    private final Vehicle vehicle;

    public Thread1 (Vehicle vehicle) {
        this.vehicle=vehicle;
    }
    public void run (){
        try {
            for (int i = 0; i < vehicle.getSizeModelArray(); i++) {
                System.out.println("Поток 1 " + vehicle.getAllModelPrices()[i]);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
