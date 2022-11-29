import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Scooter implements Vehicle{
    private String mark;
    double price;
    private HashMap<String,Double> marksAndPrices;

    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }

    public Scooter(String Mark, int n) {
        mark = Mark;
        marksAndPrices = new HashMap<>();
        for (int i = 0; i < n; i++)
            marksAndPrices.put(mark+i, (double) (200+i));
    }
    @Override
    public void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException  {

        marksAndPrices.remove(oldName);
        Double oldPrice;
        oldPrice = marksAndPrices.get(oldName);
        marksAndPrices.put(newName,oldPrice);
    }
    @Override
    public String[] getAllModelNames() {
        Set<String> keys = marksAndPrices.keySet();
        return keys.toArray(new String[0]);
    }
    @Override
    public double getPriceModelByName(String modelName) throws NoSuchModelNameException {
        return marksAndPrices.get(modelName);
    }
    @Override
    public void setPriceModelByName(String modelName, double price) throws NoSuchModelNameException, DuplicateModelNameException {
        marksAndPrices.replace(modelName,price);
    }

    @Override
    public double[] getAllModelPrices() {
        double[] pricesArray = new double[marksAndPrices.size()];
        ArrayList<Double> values = new ArrayList<>(marksAndPrices.values());
        for (int i = 0; i<marksAndPrices.size();i++)
            pricesArray[i] = values.get(i);
        return pricesArray;
    }

    @Override
    public void addModel(String modelName, double price) throws DuplicateModelNameException {
        marksAndPrices.put(modelName,price);
    }

    @Override
    public void deleteModel(String modelName) throws NoSuchModelNameException {
        marksAndPrices.remove(modelName);
    }

    @Override
    public int getSizeModelArray() {
        return marksAndPrices.size();
    }
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Марка ").append(getMark()).append("\n");
        for (int i = 0; i < getAllModelNames().length; i++) {
            stringBuffer.append("Модель ").append(getAllModelNames()[i]).append("\n");
        }
        for (int i = 0; i < getAllModelPrices().length; i++) {
            stringBuffer.append("Цена модели ").append(getAllModelPrices()[i]).append("\n");
        }
        return stringBuffer.toString();
    }
}