package ExampleTrains;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TrainsMain {

    public static void main(String[] args) {

        File file = new File("F:\\trains.xml");

        Trains trains = new Trains();
        trains.addTrain(new Train(1, "Kyev", "Donetsk", LocalDateTime.of(2015, 7, 6, 12, 50)));
        trains.addTrain(new Train(2, "Kyev", "Lviv", LocalDateTime.of(2015, 7, 6, 19, 05)));
        trains.addTrain(new Train(3, "Lviv", "Donetsk", LocalDateTime.of(2015, 7, 6, 17, 00)));

        // пишем поезда в файл
        WriteReadFile.writeToFile(file, trains);

        System.out.println("1----------------------");

        // читаем из файла и выводим в консоль
        trains = WriteReadFile.readFromFile(file);

        System.out.println("2----------------------");

        // добавляем поезд
        WriteReadFile.addTrainToFile(file, (new Train(4, "Lviv", "Poltava", LocalDateTime.of(2015, 7, 6, 20, 10))));

        System.out.println("3----------------------");

        // задаем параметры поиска
        LocalTime timeToSearchStart, timeToSearchFin;
        timeToSearchStart = LocalTime.of(03, 15);
        timeToSearchFin = LocalTime.of(19, 01);

        System.out.println("The trains in the interval from "
                + timeToSearchStart.toString() + " to "
                + timeToSearchFin.toString() + ":");

        trains.getTrainsInterval(timeToSearchStart, timeToSearchFin);
    }
}


