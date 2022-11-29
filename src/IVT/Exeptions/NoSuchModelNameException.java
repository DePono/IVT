package IVT.Exeptions;
public class NoSuchModelNameException extends Exception {
    public NoSuchModelNameException(String name) {
        super("В массиве нет такой модели " + name);
    }
}
