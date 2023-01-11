import IVT.Exeptions.DuplicateModelNameException;
import IVT.Exeptions.NoSuchModelNameException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException, IOException, ClassNotFoundException {
        System.out.println("Создаем 3 класса Vehicle");
/*        Auto auto = new Auto("Audi", 2);
        System.out.println(auto);
        Auto auto1 = new Auto("Audi",2);
        System.out.println(auto1);*/
        //Задание 6
        Vehicle auto = new Auto("Pot",3);
        System.out.println(auto);
        Vehicle auto1 = new Auto("Pot",3);
        System.out.println(auto1);
        Vehicle auto2 = new Auto("Pot",3);
        System.out.println(auto2);
        System.out.println("Средняя цена за все автомобили в сумме " + VehicleStaticClass.getVehicleAveragePrices(auto,auto1,auto2));
/*        FileWriter fileWriter = new FileWriter("data.txt");
        // Задание 7
        VehicleStaticClass.writesVehicle(auto,fileWriter);
        VehicleStaticClass.readsVehicle();*/
/*        System.out.println("Количество моделей в массиве равно = " + auto.getSizeModelArray());
        VehicleStaticClass.printModels(auto);
        System.out.println("Распечатываем цены");
        VehicleStaticClass.printPrices(auto);*/
/*        System.out.println("Создаем 3 модели мотоциклов");
        Vehicle motorcycle = new Motorcycle("Suzuku",2);
        System.out.println("Количество моделей в массиве равно = " + motorcycle.getSizeModelArray());
        VehicleStaticClass.printModels(motorcycle);
        System.out.println("Распечатываем цены");
        VehicleStaticClass.printPrices(motorcycle);*/
//        System.out.println("Добавляем 4 модель");
//        auto.addModel("Suzuki",303.0);
//        System.out.println("Распечатываем модели с добавленной моделью");
//        VehicleStaticClass.printModels(auto);
//        System.out.println("Распечатываем цены");
        //       VehicleStaticClass.printPrices(auto);
        //      System.out.println("Обновляем название модели Vaz0");
        //      auto.setModelName("Vaz0","Audi");
        //      System.out.println("Распечатываем модели с измененной моделью");
//        VehicleStaticClass.printModels(auto);
//        System.out.println("Распечатываем названия"+ Arrays.toString(auto.getAllModelNames()));
//        System.out.println("Получаем цену у Audi " + auto.getPriceModelByName("Audi"));
//        System.out.println("Удаляем модель Audi");
//        auto.deleteModel("Audi");
//        System.out.println("Распечатываем модели с удаленной моделью");
//        VehicleStaticClass.printModels(auto);
//        System.out.println("Меняем цену у Suzuki с 303 на 404 ");
//        auto.setPriceModelByName("Suzuki",404.0);
//        System.out.println("Распечатываем цены ");
//        VehicleStaticClass.printPrices(auto);
/*        System.out.println("Сохраним список моделей в файл");
        FileOutputStream fos = new FileOutputStream("data.dat");
        VehicleStaticClass.outputVehicle(auto,fos);
        fos.close();
        FileInputStream fis = new FileInputStream("data.dat");
        Vehicle vehicleresult = VehicleStaticClass.inputVehicle(fis);
        System.out.println(vehicleresult.getMark());
        System.out.println(vehicleresult.getSizeModelArray());
        VehicleStaticClass.printModels(vehicleresult);
        System.out.println("Распечатываем цены");
        VehicleStaticClass.printPrices(vehicleresult);
        System.out.println("Сохраним список моделей в файл");
        File file = new File("data.byte");
        long timestamp = file.lastModified();
        System.out.println("data.byte последний раз был изменен = " + new Date(timestamp));
        FileWriter fileWriter = new FileWriter("data.txt");
        VehicleStaticClass.writeVehicle(auto, fileWriter);
        fileWriter.flush();
        FileReader fileReader = new FileReader("data.txt");
        Vehicle vehicleresult2 = VehicleStaticClass.readVehicle(fileReader);
        System.out.println(vehicleresult2.getSizeModelArray());
        VehicleStaticClass.printModels(vehicleresult2);
        System.out.println("Распечатываем цены");
        VehicleStaticClass.printPrices(vehicleresult2);*/
/*        Auto auto = new Auto("AIDI",2);
        FileOutputStream fos = new FileOutputStream("auto10.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(auto);
        oos.close();
        System.out.println("Файл записан");
        FileInputStream fis = new FileInputStream("auto10.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Vehicle motor = (Vehicle) ois.readObject();
        System.out.println("Вывод информации о машинах...");
        System.out.println(motor);
        ois.close();*/
 /*       // лабораторная 4
        // консольный ввод
        System.out.println("Введите Auto or Motorcycle");*/
/*        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfClass = reader.readLine();
        System.out.println("Введите модель выбранного транспортного средства");
        String nameOfModel = reader.readLine();
        System.out.println("Введите число моделей");
        int numberOfModel = Integer.parseInt(reader.readLine());
        Vehicle auto = null;
        if (Objects.equals(nameOfClass, "Auto"))
            auto = new Auto(nameOfModel, numberOfModel);
        else auto = new Motorcycle(nameOfModel,numberOfModel);
        System.out.println("Количество моделей в массиве равно = " + auto.getSizeModelArray());
        VehicleStaticClass.printModels(auto);
        System.out.println("Распечатываем цены");
        VehicleStaticClass.printPrices(auto);*/
/*        System.out.println(auto.equals(auto1));
        Vehicle vehicleres = VehicleStaticClass.readVehicle(new InputStreamReader(System.in));
        VehicleStaticClass.writeVehicle(vehicleres,new OutputStreamWriter(System.out));*/
/*        System.out.println("Создадим файл cars.dat");
        Path path = Paths.get("cars.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(path))) {
            Vehicle auto3 = new Auto("Loo", 4);
            oos.writeObject(auto3);
            System.out.println("Созданный vehicle "+"\n" + auto3);
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
            Vehicle read = (Auto) ois.readObject();
            System.out.printf("Считанный vehicle: %s", read);
        }*/
/*        System.out.println("Сравнивaем объекты класса Auto и Auto " + auto.equals(auto1));
        System.out.println("Изменим цену у первой модели с 200 на 300");
        auto1.setPriceModelByName("Audi0",300);
        System.out.println(auto1);
        System.out.println("Сравним " + auto.equals(auto1));*/
/*        System.out.println("Сравнивaем объекты класса Motorcycle и Motorcycle " + auto.equals(auto1));
        System.out.println("Изменим цену у первой модели с 200 на 400");
        auto1.setModelName("Pot0","400");
        System.out.println(auto1);
        System.out.println("Сравнивaем объекты класса Motorcycle и Motorcycle " + auto.equals(auto1));*/
    }
}