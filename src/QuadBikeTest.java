import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;

import java.util.Arrays;

public class QuadBikeTest {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {
        QuadBike quadBike = new QuadBike("Polo",2);
        System.out.println(quadBike);
        quadBike.setModelName("Polo1","Poller4");
        System.out.println(quadBike);
        System.out.println(Arrays.toString(quadBike.getAllModelNames()));
        System.out.println(quadBike.getPriceModelByName("Polo0"));
        quadBike.setPriceModelByName("Polo0",1000);
        System.out.println(quadBike);
        System.out.println(Arrays.toString(quadBike.getAllModelPrices()));
        quadBike.addModel("Lop",323);
        System.out.println(quadBike);
        System.out.println(quadBike);
    }
}
