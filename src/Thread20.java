public class Thread20 implements Runnable {
    private final VehicleSynchronizer vehicleSynchronizer;
    public Thread20(VehicleSynchronizer vehicleSynchronizer) {
        this.vehicleSynchronizer = vehicleSynchronizer;
    }
    @Override
    public void run() {
        while (vehicleSynchronizer.canPrintModel()) {
            try {
                vehicleSynchronizer.printModel();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
