package ExampleTrains;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name="train")
public class Train {

    private int id;

    private String from;
    private String to;
    private String date;
    private String departure;

    public Train () {

    }

    public Train (int id, String from, String to, LocalDateTime date) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date.toLocalDate().toString();
        this.departure = date.toLocalTime().toString();
    }

    @Override
    public String toString() {
        return "[" + from + ", " + to + ", " + date + ", " + departure + "]";
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }
}
