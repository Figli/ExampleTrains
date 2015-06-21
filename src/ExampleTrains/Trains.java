package ExampleTrains;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "trains")
public class Trains {

    public Trains() {

    }

    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<Train>();

    public void addTrain(Train train) {

        trains.add(train);
    }

    @Override
    public String toString() {

        return Arrays.deepToString(trains.toArray());
    }

    public List<Train> getTrainsInterval(LocalTime start, LocalTime fin) {

        List<Train> result = new ArrayList<>();

        if (fin.isBefore(start)) {
            System.out
                    .println("Do not correct the date");
        } else {
            for (Train train : trains) {
                String[] times = train.getDeparture().split(":");
                LocalTime localTime = LocalTime.of(Integer.parseInt(times[0]),
                        Integer.parseInt(times[1]));

                if ((localTime.isAfter(start)) && (localTime.isBefore(fin))) {
                    result.add(train);
                    System.out.println(train);
                }
            }
            if (result.isEmpty()) {
                System.out.println("In a given interval no trains");
            }
        }
        return result;
    }
}
