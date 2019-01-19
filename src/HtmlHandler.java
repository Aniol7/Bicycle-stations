
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.Random;

class HtmlHandler {

    HtmlHandler(File f) {
        this.f = f;
    }

    void erase() {
        try {
            List<String> lines = Files.readAllLines(f.toPath());
            while (lines.size() >= 49) {
                lines.remove(40);
            }
            Files.write(f.toPath(), lines);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    void insert(Marker markers[], int markersNumber) {

        try {

            List<String> lines = Files.readAllLines(f.toPath());

            Algorithm1 algorithm1 = new Algorithm1();
            Arrays.sort(markers, algorithm1);

            Algorithm2 algorithm2 = new Algorithm2();
            ArrayList<Marker> alg2Markers = algorithm2.sort(markers,markersNumber);

           RandomSearch randomSearch = new RandomSearch();
           ArrayList<Marker> randomlist = randomSearch.sort(markers,markersNumber);

           Tabu tabu = new Tabu();
            ArrayList<Marker> tabulist = tabu.sort(markers,markersNumber);

            float taburatesum = 0;
            float algo1sum = 0;
            float alg2sum = 0;
            float randomsearchsum = 0;

            for (int i=0; i < tabulist.size(); i++) {
               algo1sum += markers[i].rate;
              alg2sum += alg2Markers.get(i).rate;
              taburatesum += tabulist.get(i).rate;
              randomsearchsum += randomlist.get(i).rate;
            }

            System.out.println("Alg1 rate: " + algo1sum);
            System.out.println("Alg2 rate: " + alg2sum);
            System.out.println("Random rate:" + randomsearchsum);
           System.out.println("Tabu rate: " + taburatesum);


            //Alg1 - niebieski, Alg2 - czerwony, Random - zielony, Tabu - czarny
            for (int i = 0; i < markersNumber; i++) {
                String line;

                line = "\t \tvar marker = new google.maps.Marker({ position: {lat:" + markers[i].x + ", lng: " +
                       markers[i].y + "}, icon: alg1, map: map,  title: '" + markers[i].title + "' });";
               lines.add(40, line);

                line = "\t \tvar marker = new google.maps.Marker({ position: {lat:" + alg2Markers.get(i).x + ", lng: " +
                          alg2Markers.get(i).y + "},map: map,  title: '" + alg2Markers.get(i).title + "' });";
                lines.add(40, line);

                line = "\t \tvar marker = new google.maps.Marker({ position: {lat:" + randomlist.get(i).x + ", lng: " +
                     randomlist.get(i).y + "}, icon: rand, map: map,  title: '" + randomlist.get(i).title + "' });";
                lines.add(40, line);

               line = "\t \tvar marker = new google.maps.Marker({ position: {lat:" + tabulist.get(i).x + ", lng: " +
                        tabulist.get(i).y + "}, icon: tabu, map: map,  title: '" + tabulist.get(i).title + "' });";
                lines.add(40, line);

            }

        Files.write(f.toPath(), lines);
    } catch (IOException ex)
        {
            System.out.println(ex.toString());
        }
    }

    private File f;
}
