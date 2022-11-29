import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;

import java.util.*;

public class QuadBike implements  Vehicle{
    private String mark;
    private double price;
    private List<String> modelArray;
    public class Model {
        String modelName;
        double modelPrice;

        public Model(String modelName, double modelPrice) {
            this.modelName = modelName;
            this.modelPrice = modelPrice;
        }
    }
    public QuadBike (String Mark, int n) {
        mark = Mark;
        for (int i = 0; i < n; i++) {
        modelArray = new ArrayList<>();
        modelArray.add(new Model(mark+i,200+i).toString());
        }
    }

    @Override
    public String getMark() {
        return null;
    }

    @Override
    public void setMark(String mark) {
    }

    @Override
    public void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        if (modelArray.contains(oldName)) throw new DuplicateModelNameException(newName);
        int index = modelArray.indexOf(oldName);
/*        modelArray.set(index,newName);*/
    }

    @Override
    public String[] getAllModelNames() {
        int length = modelArray.size();
        String[] NamesArray = new String[length];
        for (int i = 0; i < length; i++) {
            NamesArray[i] = modelArray.get(i).toString();
        }
        return NamesArray;
    }

    @Override
    public double getPriceModelByName(String modelName) throws NoSuchModelNameException {
        return 0;
    }

    @Override
    public void setPriceModelByName(String modelName, double price) throws NoSuchModelNameException, DuplicateModelNameException {

    }

    @Override
    public double[] getAllModelPrices() {
        return new double[0];
    }

    @Override
    public void addModel(String modelName, double price) throws DuplicateModelNameException {

    }

    @Override
    public void deleteModel(String modelName) throws NoSuchModelNameException {

    }

    @Override
    public int getSizeModelArray() {
        return 0;
    }
    public String toString() {
        /*StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Марка ").append(getMark()).append("\n");
        for (int i = 0; i < getAllModelNames().length; i++) {
            stringBuffer.append("Модель ").append(getAllModelNames()[i]).append("\n");
        }
        for (int i = 0; i < getAllModelPrices().length; i++) {
            stringBuffer.append("Цена модели ").append(getAllModelPrices()[i]).append("\n");
        }
        return stringBuffer.toString();*/
        return "Model {" + " mark= " + mark + ", price= " + price + "}";
    }

}
