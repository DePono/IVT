import java.io.*;

public class Text implements DataType{
    private Vehicle vehicle;
    private String mark;
    private int count;
    private double[] prices;
    private String[] models;

    public void set(Vehicle vehicle){
        this.vehicle = vehicle;
        try{
            FileWriter writer = new FileWriter("data.txt");
            writer.write("" + vehicle.getMark());
            writer.write("\n" + vehicle.getSizeModelArray());
            for (int i = 0; i< vehicle.getSizeModelArray();i++){
                writer.write("\n" + vehicle.getAllModelNames()[i]);
                writer.write("\n" + vehicle.getAllModelPrices()[i]);
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Возникла ошибка при записи" + e);
        }
    }
    public void get() {
        try{
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            mark = bufferedReader.readLine();
            count = Integer.parseInt(bufferedReader.readLine());
            models = new String[count];
            prices = new double[count];
            for (int i = 0; i<count; i++){
                models[i] = bufferedReader.readLine();
                prices[i] = Double.parseDouble(bufferedReader.readLine());
            }
        } catch (IOException e){
            System.out.println("Возникла ошибка при чтении" + e);
        }
    }
    public void print() {
        System.out.println("Вывод информации о технике...");
        System.out.println("--------------------------------");
        System.out.println("Марка: " + mark + "  Количество моделей: " + count);
        for (int i = 0; i <  count; i++) {
            System.out.println("       " + models[i] + "  " + prices[i]);
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
