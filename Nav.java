// file : Nav.java
public class Nav {

    static double toRad(double angle_in_degrees) {
        double angle_in_radians;
        angle_in_radians = angle_in_degrees * Math.PI / 180.;
        return angle_in_radians;
    }

    public static void main(String[] Args)
    {

        System.out.println("to_rad");
        for (double angle = 0; angle < 360; angle += 15) {
            System.out.println(angle + " : " + toRad(angle));
        }
    }
}