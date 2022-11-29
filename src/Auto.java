import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import IVT.Exeptions.NoSuchModelNameException;
import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.ModelPriceOutOfBoundsException;
public class Auto implements Vehicle, Serializable, Cloneable {
    // 1 поле типа String, хранящее марку автомобиля
    private String mark;

    // 2 метод получения марки автомобиля
    public String getMark() {
        return mark;
    }

    // класс Автомобиль хранит массив моделей
    private Model[] ModelArray;

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

        // 4 лабораторная работа
        public int hashCode() {
            int result = ModelName == null ? 0 : ModelName.hashCode();
            result = (int) (result + ModelPrice);
            return result;
        }

        @Override
        public Model clone() throws CloneNotSupportedException {
            Model clone = (Model) super.clone();
            return new Model(ModelName,ModelPrice);
        }
    }

    // конструктор класса должен принимать Марку и размер массивов Моделей
    public Auto(String Mark, int n) {
        mark = Mark;
        ModelArray = new Model[n];
        for (int i = 0; i < n; i++)
            ModelArray[i] = new Model(mark + i, 200 + i);
    }

    @Override
    public Auto clone() throws CloneNotSupportedException {
        Auto clone = (Auto) super.clone();
        clone.ModelArray = this.ModelArray.clone();
        for (int i = 0; i < ModelArray.length; i++) {
            clone.ModelArray[i] = this.ModelArray[i].clone();
        }
        return clone;
    }

    // 5 метод обновления названия модели
    public void setModelName(String oldName, String modelName) throws DuplicateModelNameException, NoSuchModelNameException {
        if (hasModelByName(modelName)) throw new DuplicateModelNameException(modelName);
        int index = getIndexByName(oldName);
        if (index != -1) ModelArray[index].ModelName = modelName;
        else {
            throw new NoSuchModelNameException(oldName);
        }
    }

    // 6.	метод, возвращающий массив названий всех моделей
    public String[] getAllModelNames() {
        int length = ModelArray.length;
        String[] NamesArray = new String[length];
        for (int i = 0; i < length; i++) {
            NamesArray[i] = ModelArray[i].getModelName();
        }
        return NamesArray;
    }

    // 7 метод для получения значения цены модели по её названию
    public double getPriceModelByName(String modelName) throws NoSuchModelNameException {
        for (Model model : ModelArray)
            if (model.ModelName.equals(modelName))
                return model.ModelPrice;
        throw new NoSuchModelNameException(modelName);

    }

    // 8.	метод для модификации значения цены модели по её названию, добавить проверку на цену
    public void setPriceModelByName(String modelName, double newPrice) throws NoSuchModelNameException {
        boolean isChange = true;
        if (newPrice < 0) throw new ModelPriceOutOfBoundsException();
        for (Model model : ModelArray)
            if (Objects.equals(model.getModelName(), modelName)) {
                model.setModelPrice(newPrice);
                isChange = false;
                break;
            }
        if (isChange) throw new NoSuchModelNameException(modelName);
    }

    // 9.	метод, возвращающий массив значений цен моделей
    public double[] getAllModelPrices() {
        int lenght = ModelArray.length;
        double[] PricesArray = new double[lenght];
        for (int i = 0; i < lenght; i++)
            PricesArray[i] = ModelArray[i].getModelPrice();
        return PricesArray;
    }

    // 10 метод добавления названия модели и её цены (путем создания нового массива Моделей), использовать метод Arrays.copyOf()
    public void addModel(String modelName, double modelPrice) throws DuplicateModelNameException {
        if (modelPrice < 0) throw new ModelPriceOutOfBoundsException();
        for (Model model : ModelArray)
            if (Objects.equals(model.getModelName(), modelName)) throw new DuplicateModelNameException(modelName);
        ModelArray = Arrays.copyOf(ModelArray, ModelArray.length + 1);
        ModelArray[ModelArray.length - 1] = new Model(modelName, modelPrice);

    }

    // проверяем, есть ли модель в списке
    public boolean hasModelByName(String modelName) {
        return Arrays.asList(getAllModelNames()).contains(modelName);
    }

    // получаем индекс из массива по имени
    public int getIndexByName(String modelName) {
        if (ModelArray != null) {
            return Arrays.asList(getAllModelNames()).indexOf(modelName);
        } else {
            return -1;
        }
    }

    //11 метод удаления модели по заданному имени, использовать методы System.arraycopy, Arrays.copyOf()
    public void deleteModel(String Name) throws NoSuchModelNameException {
        boolean flug = true;
        for (int i = 0; i < ModelArray.length; i++)
            if (Objects.equals(ModelArray[i].getModelName(), Name)) {
                flug = false;
                System.arraycopy(ModelArray, i + 1, ModelArray, i, ModelArray.length - i - 1);
                ModelArray = Arrays.copyOf(ModelArray, ModelArray.length - 1);
            }
        if (flug) throw new NoSuchModelNameException(Name);
    }

    // 12.метод для получения размера массива Моделей.
    public int getSizeModelArray() {
        return ModelArray.length;
    }

    // 4 лабораторная работа
    public String toString() {
        /*        StringBuilder sb = new StringBuilder();*/
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

    // рапсписать через цикл исправить, добавить модели,
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Auto)) return false;
        if (Objects.equals(this.mark, ((Auto) o).mark)) {
                return Arrays.equals(getAllModelPrices(),((Auto) o).getAllModelPrices())
                        && Arrays.equals(getAllModelNames(),((Auto) o).getAllModelNames());
            }
        return false;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mark);
        result = 31 * result + Arrays.hashCode(ModelArray);
        return result;
    }

}