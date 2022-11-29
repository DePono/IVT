package IVT.Exeptions;
public class DuplicateModelNameException  extends Exception {
    public DuplicateModelNameException(String name){
        super("Эта модель" + name + "уже существует");
    }
}
