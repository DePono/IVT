import java.lang.reflect.*;
public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Auto auto = new Auto("Porsche", 2);
        System.out.println("Изначальный класс");
        System.out.println(auto);
        if (args.length == 4) {
            try {
                Class<?> cl = Class.forName(args[0]);
                System.out.println(cl);
                Class<?>[] param = new Class[]{String.class, double.class};
                Method setPriceModelByNameMethod = cl.getMethod(args[1], param);
                System.out.println(setPriceModelByNameMethod);
                setPriceModelByNameMethod.invoke(auto, args[2], Double.parseDouble(args[3]));
                System.out.println("Измененный класс" + auto);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}