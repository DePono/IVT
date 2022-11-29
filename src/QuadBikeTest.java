import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;

import java.util.Arrays;
import java.util.List;

public class QuadBikeTest {
    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {
        Vehicle quadBike = new QuadBike("Porsche",6);
        System.out.println(quadBike);
    }
}
