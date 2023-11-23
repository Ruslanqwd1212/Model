
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;


public class Route {

   Route br = new Route();


    private long calculateTimeDiff(BusStop from, BusStop to) {
        Time timeFrom = from.getTime();
        long distanceFrom = (long) from.getDistance();

        Time timeTo = to.getTime();
        long distanceTo = (long) to.getDistance();

        double speed = 50; // km/h
        double timeDiff = Math.abs(distanceFrom / speed) + Math.abs(distanceTo / speed);
        return (long) timeDiff;
    }



    private List<BusStop> createBusStops() {
        List<BusStop> busStops = new ArrayList<>();

        BusStop busStop1 = new BusStop("A", "Address 1", 0);
        busStops.add(busStop1);

        BusStop busStop2 = new BusStop("B", "Address 2", 1);
        busStops.add(busStop2);

        return busStops;
    }

    public void printBusRoutes(List<BusStop> busStops) {


        System.out.println("Bus routes and arrival times:");

        for (BusStop start : busStops) {
            for (BusStop end : busStops) {
                if (start != end) {
                    long timeDiff = calculateTimeDiff(start, end);
                    String arrivalTime = calculateArrivalTime(timeDiff);
                    printBusRoute(start, end, arrivalTime);
                }
            }
        }
    }




private void printBusRoute(BusStop start, BusStop end, String arrivalTime) {
        String routeText = "Route: " + start.getName() + " -> " + end.getName();
        System.out.printf("%s%n", routeText);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        String arrival = arrivalTime + ": " + sdf.format(LocalTime.parse(arrivalTime));
        System.out.println(arrival);
        }



private String calculateArrivalTime(long timeDiff) {
        int busInterval = getRandomIntInInterval(15, 30); // In minutes
        int arrivalTime = (int) ((timeDiff / 60) / busInterval) * busInterval;
        String formattedTime = String.valueOf(arrivalTime / 60) + ":" + String.valueOf(arrivalTime % 60);
        formattedTime = formattedTime.substring(0, 5) +
        ((formattedTime.length() >= 2) ? ":" : "") + formattedTime.substring(formattedTime.

        length() - 2);
        return formattedTime;
        }

        int getRandomIntInInterval(int min, int max) {
            return (int) ((Math.random() * (max - min + 1)) + min);
        }
}
