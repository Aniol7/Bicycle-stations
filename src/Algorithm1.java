import java.util.Comparator;

public class Algorithm1 implements Comparator<Marker>
{
    @Override
    public int compare(Marker m1, Marker m2) {
        if(m2 == null) return -1;
        if(m1.rate > m2.rate) return -1;
        else if(m1.rate < m2.rate) return 1;
        else return 0;
    }

}