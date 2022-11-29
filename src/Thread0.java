public class Thread0 extends Thread {

    private final Vehicle vehicle;

    public Thread0 (Vehicle vehicle) {
        this.vehicle=vehicle;
    }
    public void run (){
        try {
            for (int i = 0; i < vehicle.getSizeModelArray(); i++) {
                System.out.println("Поток 0 " + vehicle.getAllModelNames()[i]);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
