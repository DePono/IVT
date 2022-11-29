package IVT.Exeptions;
public class ModelPriceOutOfBoundsException extends RuntimeException {
    public ModelPriceOutOfBoundsException(){
        super("Задана неверная цена");
    }
}
