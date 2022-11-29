public class VehicleSynchronizer {
        private Vehicle vehicle;
        private volatile int current = 0;
        private Object lock = new Object();
        private boolean set = false;

        public VehicleSynchronizer(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        public double printPrice() throws InterruptedException {
            double val;
            synchronized(lock) {
                double [] p = vehicle.getAllModelPrices();
                if (!canPrintPrice()) throw new InterruptedException();
                while (!set)
                    lock.wait();
                val = p[current++];
                System.out.println("Print price: " + val);
                set = false;
                lock.notifyAll();
            }
            return val;
        }

        public void printModel() throws InterruptedException {
            synchronized(lock) {
                String [] s = vehicle.getAllModelNames();
                if (!canPrintModel()) throw new InterruptedException();
                while (set)
                    lock.wait();
                System.out.println("Print model: " + s[current]);
                set = true;
                lock.notifyAll();
            }
        }

        public boolean canPrintPrice() {
            return current < vehicle.getSizeModelArray();
        }

        public boolean canPrintModel() {
            return (!set && current < vehicle.getSizeModelArray()) || (set && current < vehicle.getSizeModelArray() - 1);
        }
    }

