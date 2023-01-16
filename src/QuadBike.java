import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import IVT.Exeptions.NoSuchModelNameException;
import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.ModelPriceOutOfBoundsException;
public class QuadBike implements Vehicle, Serializable, Cloneable {
    // 1 поле типа String, хранящее марку автомобиля
    private String mark;

    // 2 метод получения марки автомобиля
    public String getMark() {
        return mark;
    }

    // класс Автомобиль хранит массив моделей
    private ArrayList<Model> modelArrayList;

    // 3 метод для модификации марки автомобиля,
    public void setMark(String mark) {
        this.mark = mark;
    }
    //4 внутренний класс Модель, имеющий поля название модели (уникальное) и её цену, а также конструктор (класс Автомобиль хранит массив Моделей)

    private class Model implements Serializable, Cloneable {
        private String ModelName;
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

    // конструктор класса должен принимать Марку и размер массивов Моделей
    public QuadBike(String Mark, int n) {
        mark = Mark;
        modelArrayList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            modelArrayList.add(new Model(mark + i, 200 + i));
    }

    // 5 метод обновления названия модели
    public void setModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        int index;
        boolean isChange = true;
        double oldPrice = 0;
        for (QuadBike.Model model : modelArrayList)
            if (Objects.equals(model.getModelName(),newName)) {throw new DuplicateModelNameException(newName);}
            else
            if (Objects.equals(model.getModelName(), oldName)) {
                index = modelArrayList.indexOf(model);
                oldPrice = model.getModelPrice();
                modelArrayList.set(index, new Model(newName,oldPrice));
                isChange = false;

            }
        if (isChange) throw new NoSuchModelNameException(oldName);
    }

    // 6.	метод, возвращающий массив названий всех моделей
    public String[] getAllModelNames() {
        int length = modelArrayList.size();
        String[] NamesArray = new String[length];
        for (int i = 0; i < length; i++) {
            NamesArray[i] = modelArrayList.get(i).getModelName();
        }
        return NamesArray;
    }

    // 7 метод для получения значения цены модели по её названию
    public double getPriceModelByName(String modelName) throws NoSuchModelNameException {
        for (Model model : modelArrayList)
            if (model.ModelName.equals(modelName))
                return model.ModelPrice;
        throw new NoSuchModelNameException(modelName);

    }

    // 8.	метод для модификации значения цены модели по её названию,
    public void setPriceModelByName(String modelName, double newPrice) throws NoSuchModelNameException {
        boolean isChange = true;
        if (newPrice < 0) throw new ModelPriceOutOfBoundsException();
        for (Model model : modelArrayList)
            if (Objects.equals(model.getModelName(), modelName)) {
                model.setModelPrice(newPrice);
                isChange = false;
                break;
            }
        if (isChange) throw new NoSuchModelNameException(modelName);
    }

    // 9.	метод, возвращающий массив значений цен моделей
    public double[] getAllModelPrices() {
        int length = modelArrayList.size();
        double[] PricesArray = new double[length];
        for (int i = 0; i < length; i++)
            PricesArray[i] = modelArrayList.get(i).getModelPrice();
        return PricesArray;
    }

    // 10 метод добавления названия модели и её цены (путем создания нового массива Моделей), использовать метод Arrays.copyOf()
    public void addModel(String modelName, double modelPrice) throws DuplicateModelNameException {
        if (modelPrice < 0) throw new ModelPriceOutOfBoundsException();
        for (Model model : modelArrayList)
            if (Objects.equals(model.getModelName(), modelName)) throw new DuplicateModelNameException(modelName);
        modelArrayList.add(new Model(modelName, modelPrice));

    }

    //11 метод удаления модели по заданному имени, использовать методы System.arraycopy, Arrays.copyOf()
    public void deleteModel(String Name) throws NoSuchModelNameException {
        boolean flag = true;
        for (Model model : modelArrayList)
            if (!Objects.equals(model.getModelName(), Name)) {
                flag=false;
                modelArrayList.removeIf(nextModel -> nextModel.getModelName().equals(Name));
            }
        if (flag) throw new NoSuchModelNameException(Name);
    }

    // 12.метод для получения размера массива Моделей.
    public int getSizeModelArray() {
        return modelArrayList.size();
    }

    // 4 лабораторная работа
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
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