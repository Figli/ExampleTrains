package ExampleTrains;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class WriteReadFile {

    static public void writeToFile(File file, Trains trains) {

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            // читабельное форматирование
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // пишем в файл
            marshaller.marshal(trains, file);
            marshaller.marshal(trains, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    static public Trains readFromFile(File file) {

        Trains trains = null;

        if (file.isFile()) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                trains = (Trains) unmarshaller.unmarshal(file);
                System.out.println(trains);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not find.");
        }
        return trains;
    }

    static  public void addTrainToFile(File file, Train train) {
        Trains trains = readFromFile(file);
        if(trains == null){
            trains = new Trains();
        }
        trains.addTrain(train);
        writeToFile(file, trains);
    }
}
