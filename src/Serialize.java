import java.io.*;

public class Serialize implements DataType{
    private Vehicle vehicle;
    private Serialize() {}
    @Override
    public void set(Vehicle vehicle) {
        try{
            this.vehicle = vehicle;
            FileOutputStream fileOutputStream = new FileOutputStream("dataserialize.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(vehicle);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл" + e);
        }
    }

    @Override
    public void get() throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream("dataserialize.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            vehicle = (Vehicle) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (IOException e) {
            System.out.println("Ошибка при чтении из файла" + e);
        }
    }

    @Override
    public void print() {
        System.out.println("Вывод информации о машине...");
        String mark = vehicle.getMark();
        double[] prices = vehicle.getAllModelPrices();
        String[] models = vehicle.getAllModelNames();
        System.out.println("--------------------------------");
        System.out.println("Марка: " + mark + "  Количество моделей: " + vehicle.getSizeModelArray());
        for (int i = 0; i <  vehicle.getSizeModelArray(); i++) {
            System.out.println("       " + models[i] + "  " + prices[i]);
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
