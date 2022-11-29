import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;
import java.util.Arrays;

public class ScooterTest {
    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {
        Vehicle Scooter = new Scooter("Stels",5);
        System.out.println(Arrays.toString(Scooter.getAllModelNames()));
        System.out.println(Scooter.getPriceModelByName("Stels0"));
        System.out.println(Arrays.toString(Scooter.getAllModelPrices()));
        Scooter.addModel("Lookk",222);
        System.out.println(Scooter);
    }
}
