import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;

import java.util.Arrays;

public class QuadBikeTest {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {
        QuadBike quadBike = new QuadBike("Polosak",2);
        System.out.println("Выведем полученный массив данных");
        System.out.println(quadBike);
        quadBike.setModelName("Polosak1","Poller4");
        System.out.println("Заменим Polosak1 на Poller4 и выведм на экран");
        System.out.println(quadBike);
        System.out.println(Arrays.toString(quadBike.getAllModelNames()));
        System.out.println(quadBike.getPriceModelByName("Polosak0"));
        quadBike.setPriceModelByName("Polosak0",1000);
        System.out.println(quadBike);
        System.out.println(Arrays.toString(quadBike.getAllModelPrices()));
        quadBike.addModel("Loposa",323);
        System.out.println(quadBike);
        quadBike.deleteModel("Polosak0");
        System.out.println(quadBike);
    }
}
