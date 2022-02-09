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
    
    /**
     * fonction getColat() permettant de retourner la colatitude en radians d’une latitude exprimée en degrés
     */
    static double getColat(double lat)
    {
        return (double)((Math.PI / 2) - Math.toRadians(lat));
    }
    
    /**
     * Turns DMS to DD
     */
    static double DMSToDD(int[] dms)
    {
        return (double)(dms[0] + dms[1] / 60 + dms[2] / 3600);
    }
    
    /**
     * Turns DD to DMS
     */
    static int[] DDToDMS(double latlon)
    {
        int[] vDms = new int[3];
        for(int i = 0;i<3;i++){
            vDms[i] = (int)latlon;
            latlon = (latlon - vDms[i]) * 60;
        }
        return vDms;
    }
    
    /**
     * Gets the Grand Circle distance between two points on a sphere based off of altitude
     */
    static double getOrthodromicDistance(double[] pA, double[] pB, double pAltitude)
    {
        return (6371 + pAltitude) * (double)(Math.acos(Math.cos(getColat(pA[0]))*Math.cos(getColat(pB[0])) + Math.sin(getColat(pA[0]))*Math.sin(getColat(pB[0]))*Math.cos(Math.toRadians(Math.min((Math.abs(pA[1]-pB[1])),360-(Math.abs((pA[1]-pB[1]))))))));
    }
}