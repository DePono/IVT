import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import IVT.Exeptions.NoSuchModelNameException;
import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.ModelPriceOutOfBoundsException;
public class Moped implements Vehicle, Serializable, Cloneable {
    // 1 поле типа String, хранящее марку автомобиля
    private String mark;

    public String getMark() {
        return mark;
    }

    private final LinkedList<Model> modelLinkedList;
    public void setMark(String mark) {
        this.mark = mark;
    }
    private class Model implements Serializable, Cloneable {
        private final String ModelName;
        private double ModelPrice;
        public String getModelName() {
            return ModelName;
        }
        public void setModelPrice(double modelPrice) {
            ModelPrice = modelPrice;
        }
        public double getModelPrice() {
            return ModelPrice;
        }
        public Model(String ModelName, double ModelPrice) {
            this.ModelName = ModelName;
            this.ModelPrice = ModelPrice;
        }
    }
    public Moped(String Mark, int n) {
        mark = Mark;
        modelLinkedList = new LinkedList<>();
        for (int i = 0; i < n; i++)
            modelLinkedList.add(new Model(mark + i, 200 + i));
    }
    public void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        double oldPrice = 0;
        for (Model model:modelLinkedList)
            if (Objects.equals(model.getModelName(), oldName))
                oldPrice=model.getModelPrice();
        modelLinkedList.removeIf(model -> Objects.equals(model.getModelName(), oldName));
        modelLinkedList.add(new Model(newName,oldPrice));
    }
    public String[] getAllModelNames() {
        int length = modelLinkedList.size();
        String[] NamesArray = new String[length];
        for (int i = 0; i < length; i++) {
            NamesArray[i] = modelLinkedList.get(i).getModelName();
        }
        return NamesArray;
    }
    public double getPriceModelByName(String modelName) throws NoSuchModelNameException {
        for (Model model : modelLinkedList)
            if (model.ModelName.equals(modelName))
                return model.ModelPrice;
        throw new NoSuchModelNameException(modelName);
    }
    public void setPriceModelByName(String modelName, double newPrice) throws NoSuchModelNameException {
        boolean isChange = true;
        if (newPrice < 0) throw new ModelPriceOutOfBoundsException();
        for (Model model : modelLinkedList)
            if (Objects.equals(model.getModelName(), modelName)) {
                model.setModelPrice(newPrice);
                isChange = false;
                break;
            }
        if (isChange) throw new NoSuchModelNameException(modelName);
    }
    public double[] getAllModelPrices() {
        int length = modelLinkedList.size();
        double[] PricesArray = new double[length];
        for (int i = 0; i < length; i++)
            PricesArray[i] = modelLinkedList.get(i).getModelPrice();
        return PricesArray;
    }
    public void addModel(String modelName, double modelPrice) throws DuplicateModelNameException {
        if (modelPrice < 0) throw new ModelPriceOutOfBoundsException();
        for (Model model : modelLinkedList)
            if (Objects.equals(model.getModelName(), modelName)) throw new DuplicateModelNameException(modelName);
        modelLinkedList.add(new Model(modelName, modelPrice));
    }
    public void deleteModel(String Name) throws NoSuchModelNameException {
        boolean flag = true;
        for (Model model : modelLinkedList)
            if (!Objects.equals(model.getModelName(), Name)) {
                flag=false;
                modelLinkedList.removeIf(nextModel -> nextModel.getModelName().equals(Name));
            }
        if (flag) throw new NoSuchModelNameException(Name);
    }
    public int getSizeModelArray() {
        return modelLinkedList.size();
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