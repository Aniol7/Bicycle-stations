import java.util.ArrayList;
import java.util.Vector;

public class Algorithm2 {

     ArrayList<Marker> sort(Marker[] markers, int markersNumber) {

         ArrayList<Marker> sortedMarkers = new ArrayList<>();
        sortedMarkers.add(markers[0]);
        double dis = 0;
        DistanceCalc calc = new DistanceCalc();

       calc.caldistance2(markers,markersNumber,sortedMarkers);

        return sortedMarkers;
    }

}