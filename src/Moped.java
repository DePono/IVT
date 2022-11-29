import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;

import java.util.Arrays;
import java.util.LinkedList;

public class Moped implements Vehicle{
    private String mark;
    private LinkedList<Model> modelArray;
    @Override
    public String getMark() {
        return mark;
    }

    @Override
    public void setMark(String mark) {
        this.mark=mark;

    }
    private class Model {
        private String modelName;
        private double modelPrice;

        public void setModelPrice(double ModelPrice) {
            modelPrice = ModelPrice;
        }

        public double getModelPrice() {
            return modelPrice;
        }

        public Model(String ModelName, double ModelPrice) {
            this.modelName = ModelName;
            this.modelPrice = ModelPrice;
        }
    }
    public Moped(String Mark, int n) {
        mark = Mark;
        modelArray = new LinkedList<>();
        for (int i = 0; i < n; i++)
            modelArray.add(new Model(mark + i, 200 + i));
        System.out.println(Arrays.toString(modelArray.toArray()));
    }
    @Override
    public void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        if (modelArray.contains(oldName));

    }

    @Override
    public String[] getAllModelNames() {
        return new String[0];
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
