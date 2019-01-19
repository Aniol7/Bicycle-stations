import java.util.ArrayList;

public class DistanceCalc {

    static float CalcLength(float x1, float y1, float x2, float y2) {
        float result;

        result = (float) (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(Math.cos(x1 * Math.PI / 180) * (y2 - y1), 2)) * 40075.704 / 360);

        return result;
    }

    public boolean calcdistance(ArrayList<Marker> tempset, int r) {

        double dis = 0;

        for (int i = 0; i < tempset.size(); i++) {

            for (int j = 0; j < tempset.size(); ++j) {
                if (i != j) {
                    dis = CalcLength(tempset.get(j).x, tempset.get(j).y, tempset.get(i).x, tempset.get(i).y);

                    if (dis < 4.0 - 0.1 * r && dis != 0)
                        break;
                }
            }

            if (dis < 4.0 - 0.1 * r && dis != 0)
                break;

        }
        if(dis > 4.0 - 0.1 * r){
            return true;
        }
        return false;
    }


    public void caldistance2(Marker markers[], int markersNumber, ArrayList<Marker> sortedMarkers) {

        double dis = 0;

        for (int i = 1; i < markers.length; i++) {

            for (int j = 0; j < sortedMarkers.size(); j++) {
                dis = CalcLength(sortedMarkers.get(j).x, sortedMarkers.get(j).y, markers[i].x, markers[i].y);

                if (dis < 4.0 - 0.1 * markersNumber) {
                    break;
                }
            }
            if (dis > 4.0 - 0.1 * markersNumber) {
                sortedMarkers.add(markers[i]);
            }
        }
    }

}
