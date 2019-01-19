import java.util.ArrayList;
import java.util.Random;

public class Tabu implements Cloneable {

    public ArrayList<Marker> sort(Marker markers[],int markersnumber){

         Random randomGenerator = new Random();
        DistanceCalc calc = new DistanceCalc();
        Algorithm1 komparator = new Algorithm1();

        ArrayList<Marker> sBest = new ArrayList<>();
        ArrayList<Marker> bestCandidate = new ArrayList<>();
        ArrayList<Integer> moves = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tabuList = new ArrayList<>();

        int tabindex = 0;
        int listindex = 0;

        moves.add(tabindex);
        moves.add(listindex);

        int bestindex;
        int sbestindex;

        for (int i=0; i<markersnumber; i++) {

            do {
                bestindex = randomGenerator.nextInt(markers.length-1);
            }while (bestCandidate.contains(markers[bestindex]));

            do {
                sbestindex = randomGenerator.nextInt(markers.length-1);
            }while (sBest.contains(markers[sbestindex]));

            sBest.add(markers[sbestindex]);
            bestCandidate.add(markers[bestindex]);
        }

        sBest.sort(komparator);
        bestCandidate.sort(komparator);

        for (int i=0;i<100000;i++) {

            do {
                tabindex = randomGenerator.nextInt(markers.length-1);
                listindex = randomGenerator.nextInt(markersnumber - 1);
                moves.set(0,tabindex);
                moves.set(1,listindex);
            } while (bestCandidate.contains(markers[tabindex]) || tabuList.contains(moves));

            Marker marker = markers[tabindex];

            bestCandidate.set(listindex, marker);

            bestCandidate.sort(komparator);
            sBest.sort(komparator);

            if (calc.calcdistance(bestCandidate,markersnumber)) {
                float bestCandidatesum = 0;
                float sBestsum = 0;

                for (int j = 0; j < bestCandidate.size(); j++) {
                    bestCandidatesum += bestCandidate.get(j).rate;
                    sBestsum += sBest.get(j).rate;
                }

                if (bestCandidatesum > sBestsum) {
                    for (int k = 0; k < bestCandidate.size(); k++)
                        sBest.set(k, bestCandidate.get(k));
                }

                else {
                      tabuList.add((ArrayList<Integer>) moves.clone());
                }

            } else {
              tabuList.add((ArrayList<Integer>) moves.clone());
            }

            if (tabuList.size() > 400)
                tabuList.remove(0);

        }
        return sBest;

    }
}
