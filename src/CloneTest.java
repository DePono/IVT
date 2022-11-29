public class CloneTest {
    public static void main(String[] args) throws Exception {
/*        Auto auto = new Auto("Porsche",1);
        System.out.println("Оригинал \n" + auto);
        Auto autoClone = auto.clone();
        System.out.println("Клон \n" + autoClone);
        autoClone.setModelName("Porsche0","Poo");
        System.out.println("Изменили Porsche0 на Poo \n" + autoClone);
        System.out.println("Оригинал \n" + auto);*/
        Motorcycle motorcycle = new Motorcycle("Suzuki",1);
        System.out.println("Оригинал \n" + motorcycle);
        Motorcycle motorcycleClone = motorcycle.clone();
        System.out.println("Клон \n" + motorcycleClone);
        motorcycleClone.setModelName("Suzuki0","Audi");
        System.out.println("Изменили Suzuki0 на Audi \n" + motorcycleClone);
        System.out.println("Оригинал \n" + motorcycle);
    }
}
