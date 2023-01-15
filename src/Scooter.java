import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.ModelPriceOutOfBoundsException;
import IVT.Exeptions.NoSuchModelNameException;

import java.util.*;
import java.util.concurrent.TransferQueue;

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
    public void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        boolean found = marksAndPrices.containsKey(newName);
        boolean found2 = marksAndPrices.containsKey(oldName);
        if (!found2) throw new NoSuchModelNameException(oldName);
        Double oldPrice;
        oldPrice = marksAndPrices.get(oldName);
        if (found) throw new DuplicateModelNameException(newName);
        else marksAndPrices.remove(oldName);
        marksAndPrices.put(newName,oldPrice);
    }
    @Override
    public String[] getAllModelNames() {
        Set<String> keys = marksAndPrices.keySet();
        return keys.toArray(new String[0]);
    }
    @Override
    public double getPriceModelByName(String modelName) throws NoSuchModelNameException {
        boolean found = marksAndPrices.containsKey(modelName);
        marksAndPrices.get(modelName);
        if (!found) throw new NoSuchModelNameException(modelName);
        return marksAndPrices.get(modelName);
    }
    @Override
    public void setPriceModelByName(String modelName, double newPrice) throws NoSuchModelNameException {
        if (newPrice<0) throw new ModelPriceOutOfBoundsException();
        boolean found = marksAndPrices.containsKey(modelName);
        marksAndPrices.replace(modelName,newPrice);
        if (!found) throw new NoSuchModelNameException(modelName);
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
    public void addModel(String modelName, double modelPrice) throws DuplicateModelNameException {
        if (modelPrice<0) throw new ModelPriceOutOfBoundsException();
        boolean found = marksAndPrices.containsKey(modelName);
        if (found) throw new DuplicateModelNameException(modelName);
        marksAndPrices.put(modelName,modelPrice);
    }

    @Override
    public void deleteModel(String modelName) throws NoSuchModelNameException {
        boolean found = marksAndPrices.containsKey(modelName);
        if (found) marksAndPrices.remove(modelName);
        else throw new NoSuchModelNameException(modelName);
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