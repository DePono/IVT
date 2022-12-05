public class Thread21 implements Runnable{

    private final VehicleSynchronizer vehicleSynchronizer;
    public Thread21(VehicleSynchronizer vehicleSynchronizer) {
        this.vehicleSynchronizer = vehicleSynchronizer;
    }
    @Override
    public void run() {
        while (vehicleSynchronizer.canPrintPrice()) {
            try {
                vehicleSynchronizer.printPrice();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
