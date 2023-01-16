import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;

import java.util.Arrays;

public class MopedTest {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException {
        Moped moped = new Moped("Stills",2);
        System.out.println(moped);
        moped.setModelName("Stills1","Stills90");
        System.out.println(moped);
        System.out.println(Arrays.toString(moped.getAllModelNames()));
        System.out.println(moped.getPriceModelByName("Stills0"));
        moped.setPriceModelByName("Stills0",1000);
        System.out.println(moped);
        System.out.println(Arrays.toString(moped.getAllModelPrices()));
        moped.addModel("Lop",923);
        System.out.println(moped);
        moped.deleteModel("Stills0");
        System.out.println(moped);
        moped.addModel("Lop",923);
        System.out.println(moped);
    }
}
