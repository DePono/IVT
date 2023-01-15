import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;
import java.util.Arrays;

public class ScooterTest {
    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {
        Vehicle Scooter = new Scooter("Stels",5);
        System.out.println(Arrays.toString(Scooter.getAllModelNames()));
        System.out.println(" Цена модели Stels0 " + Scooter.getPriceModelByName("Stels0"));
        System.out.println(Arrays.toString(Scooter.getAllModelPrices()));
        System.out.println("Добавим модель Lookk");
        Scooter.addModel("Lookk",222);
        System.out.println(Scooter);
        System.out.println("Заменим цену у Stels1 ");
        Scooter.setPriceModelByName("Stels1",999);
        System.out.println(" Цена модели несуществующей Stels1 " + Scooter.getPriceModelByName("Stels1"));
        System.out.println("Заменим цену у Stels1 ");
        Scooter.setPriceModelByName("Stels1",999);
        System.out.println(Scooter);
        System.out.println("Заменим модель Stels3 на Polop");
        Scooter.setModelName("Stels3","Polop");
        System.out.println(Scooter);
/*        System.out.println("Добавим опять модель Loоkk");
        Scooter.addModel("Lookk",222);
        System.out.println(Scooter);*//*
        System.out.println("Удалим модель Loоkk");
        Scooter.deleteModel("Lookk");
        System.out.println(Scooter);
        System.out.println("Удалим несуществующую модель Loоkk");
        Scooter.deleteModel("Lookk");
        System.out.println(Scooter);*/
        System.out.println("Заменим опять модель Stels3 на Polop");
        Scooter.setModelName("Stels3","Polop");
        System.out.println(Scooter);
    }
}
