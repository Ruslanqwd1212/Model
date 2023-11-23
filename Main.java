import java.io.IOException;
import java.time.format.ResolverStyle;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final int MIN_INTERVAL = 15;
    private static final int MAX_INTERVAL = 30;
    private static Random random = new Random();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm").withResolverStyle(ResolverStyle.STRICT);

    public static void main(final String[] args) throws ParseException, InterruptedException, IOException {
        int busNumber;
        double interval;
        LocalTime busArrival;
        Bus bus;
        System.out.print("Enter the number of the bus: ");
        busNumber = Integer.parseInt(String.valueOf(System.in.read()));

        // Get the stops and bus information for the selected bus
        for (Stop stop : Stop.getStops()) {
            bus = Bus.

            getBus(stop.getBusNumber());
            if (bus.getNumber() == busNumber) {
                System.out.println(stop.toString());
            }
        }

        while (true) {
            // Generate the random interval
            interval = random.nextInt((MAX_INTERVAL - MIN_INTERVAL) + 1) + MIN_INTERVAL;
            busArrival = LocalTime.now().plusMinutes((long) interval);
            System.out.println("The bus will arrive at " + dateFormat.format(busArrival));
            Thread.sleep((long) (interval * 60 * 1000)); // Sleep for the specified interval in milliseconds
        }
    }
}


class Stop {
    String address;
    int busNumber;

    Stop(String address, int busNumber) {
        this.address = address;
        this.

        busNumber = busNumber;
    }

    public static Stop[] getStops() {
        Stop[] stops = new Stop[0];
        Stop[] stops1 = stops;
        return stops1;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    int getBusNumber() {
        return busNumber;
    }

    void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "address='" + address + '\'' +
                ", busNumber=" + busNumber +
                '}';
    }
}