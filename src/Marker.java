public class Marker {

    Marker(String title, double x, double y, int citizens, int bikeLayerRate, double distance)
    {
        this.x = (float)x;
        this.y = (float)y;
        this.title = title;
        this.citizens = citizens;
        this.bikeLayerRate = (byte)bikeLayerRate;
        this.distance = (float)distance;
        rate = (float) (0.6 * (citizens/1000) + 0.3 * (bikeLayerRate * 1.9) + 0.1 * (-distance * 1.3));

    }

     float x,y;
    String title;
   private int citizens;
   private byte bikeLayerRate;
   private float distance;
    float rate;
}

