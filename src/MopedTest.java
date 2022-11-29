import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;

import java.util.Arrays;

public class MopedTest {
    public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException {
        Vehicle Moped = new Moped("Look",5);
        System.out.println(Moped);
    }
}
