// Calculates the volume of Earth in cubic kilometers and miles.
public class EarthVolumeCalculator { 
    public static void main(String[] args){
        int radius = 6378;
        double pi = 3.14;//defining constant pi value
        double vol_sphere = (4/3) * pi * radius * radius * radius;//calculating volume of the sphere
        System.out.println(vol_sphere);
    }
}
