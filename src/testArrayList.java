import java.util.ArrayList;
public class testArrayList {
    public static void main(String[] args) {
        Model model = new Model("Porshe", 20000);
        Model model1 = new Model("Porsh", 2000);
        Model model2 = new Model("Pors", 200);
        Model model3 = new Model("Por", 20);
        ArrayList<Model> models = new ArrayList<>();
        models.add(model);
        models.add(model1);
        models.add(model2);
        models.add(model3);
        System.out.println(models);
    }
    }
    class Model {
    private final String modelName;
    private final double modelPrice;
     public Model (String modelName, double modelPrice) {
         this.modelName = modelName;
         this.modelPrice = modelPrice;
     }

    @Override
    public String toString() {
        return "Model{" +
                "modelName='" + modelName + '\'' +
                ", modelPrice=" + modelPrice +
                '}';
    }
}
