import java.sql.Time;

/**
 * 
 */
class BusStop {
    String name;
    double distance;
    Time time;

    BusStop(String name, String address, double distance) {
        this.name = name;
        this.distance = distance;
        time = new Time(14, 0, 0);
    }
    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public Time getTime() {
        return time;
    }
}