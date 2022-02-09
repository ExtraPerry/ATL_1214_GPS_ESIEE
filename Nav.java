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
     * Returns the value of Gammma
     */
    static double getGamma(double[] pA, double[] pB)
    {
        return (double)(Math.toRadians(Math.min((Math.abs(pA[1]-pB[1])),360-(Math.abs((pA[1]-pB[1]))))));
    }
    
    /**
     * Returns the value of C
     */
    static double getC(double[] pA, double[] pB)
    {
        double vA = getColat(pA[0]);
        double vB = getColat(pB[0]);
        double vGamma = getGamma(pA,pB);
        return (double)(Math.cos(vA) * Math.cos(vB) + Math.sin(vA) * Math.sin(vB) * vGamma);
    }
    
    /**
     * Gets the Grand Circle distance between two points on a sphere based off of altitude
     */
    static double getOrthodromicDistance(double[] pA, double[] pB, double pAltitude)
    {
        return (6371 + pAltitude) * (double)(Math.acos(Math.cos(getColat(pA[0])) * Math.cos(getColat(pB[0])) + Math.sin(getColat(pA[0])) * Math.sin(getColat(pB[0])) * Math.cos(Math.toRadians(Math.min((Math.abs(pA[1]-pB[1])),360-(Math.abs((pA[1]-pB[1]))))))));
        /* ---------------------------------------------------------------------------------------------------------
         * Using seperate Functions causes instability :/ (So I integrated everything inside of a single line above)
         * Insert Here : It just works, Overpriced OpenWorlds, it just Works, it just works ...
         * ---------------------------------------------------------------------------------------------------------
         * double vC = getC(pA,pB);
         * return (double)(6371 + pAltitude) * vC;
        */
    }
    
    /**
     * Returns the Initial Cap (Alpha)
     */
    static double getInitialBearing(double[] pA, double[] pB)
    {
        return (double)(Math.sin(getColat(pA[0])) * Math.sin(Math.toRadians(Math.min((Math.abs(pA[1]-pB[1])),360-(Math.abs((pA[1]-pB[1])))))) / Math.sin(Math.acos(Math.cos(getColat(pA[0])) * Math.cos(getColat(pB[0])) + Math.sin(getColat(pA[0])) * Math.sin(getColat(pB[0])) * Math.cos(Math.toRadians(Math.min((Math.abs(pA[1]-pB[1])),360-(Math.abs((pA[1]-pB[1])))))))));
        /* ---------------------------------------------------------------------------------------------------------
         * Using seperate Functions causes instability :/ (So I integrated everything inside of a single line above)
         * Insert Here : It just works, Overpriced OpenWorlds, it just Works, it just works ...
         * ---------------------------------------------------------------------------------------------------------
         * double vA = getColat(pA[0]);
         * double vGamma = getGamma(pA,pB);
         * double vC = getC(pA,pB);
         * return (double)(Math.sin(vA) * Math.sin(vGamma) / Math.sin(vC));
        */
    }
    
    /**
     * Returns the Final Cap (Beta)
     */
    static double getFinalBearing(double[] pA, double[] pB)
    {
        return (double)(Math.sin(getColat(pB[0])) * Math.sin(Math.toRadians(Math.min((Math.abs(pA[1]-pB[1])),360-(Math.abs((pA[1]-pB[1])))))) / Math.sin(Math.acos(Math.cos(getColat(pA[0])) * Math.cos(getColat(pB[0])) + Math.sin(getColat(pA[0])) * Math.sin(getColat(pB[0])) * Math.cos(Math.toRadians(Math.min((Math.abs(pA[1]-pB[1])),360-(Math.abs((pA[1]-pB[1])))))))));
        /* ---------------------------------------------------------------------------------------------------------
         * Using seperate Functions causes instability :/ (So I integrated everything inside of a single line above)
         * Insert Here : It just works, Overpriced OpenWorlds, it just Works, it just works ...
         * ---------------------------------------------------------------------------------------------------------
         * double vB = getColat(pB[0]);
         * double vGamma = getGamma(pA,pB);
         * double vC = getC(pA,pB);
         * return (double)(Math.sin(vB) * Math.sin(vGamma) / Math.sin(vC));
        */
    }
    
    /**
     * Chemin du Clipper
     */
    static double[] getClipperPath()
    {
        double[] vTresureIsland = {27.745003,-82.759659};
        double[] vHonolulu = {21.3069444,-157.858333};
        double[] vCanton = {-2.83333,-171.666664};
        double[] vSuva = {-18.15,178.44};
        double[] vAuckland = {-36.8404,174.74};
        double[] vNoumea = {-22.2355,166.47};
        double[] vGladstone = {-23.84852,151.268356};
        double[] vDarwin = {-12.4628271,130.8417772};
        double[] vSurabay = {-7.250445,112.768845};
        double[] vTrinquemalay = {8.5711,81.2335};
        double[] vKarachi = {24.860966,66.990501};
        double[] vBahrain = {25.9434256,50.6014985};
        double[] vKhartoum = {15.508457,32.522854};
        double[] vLepoldville = {-4.322447,15.307045};
        double[] vNatal = {-5.779257,-35.200916};
        double[] vPortDeSpain = {10.654901,-61.501926};
        double[] vLaGuardiaNewYork = {40.7769271,-73.8739659};
        
        double[] vDistances = new double[16];
        
        vDistances[0] = getOrthodromicDistance(vTresureIsland,vHonolulu,1);
        vDistances[1] = getOrthodromicDistance(vHonolulu,vCanton,1);
        vDistances[2] = getOrthodromicDistance(vCanton,vSuva,1);
        vDistances[3] = getOrthodromicDistance(vSuva,vAuckland,1);
        vDistances[4] = getOrthodromicDistance(vAuckland,vNoumea,1);
        vDistances[5] = getOrthodromicDistance(vNoumea,vGladstone,1);
        vDistances[6] = getOrthodromicDistance(vGladstone,vDarwin,1);
        vDistances[7] = getOrthodromicDistance(vDarwin,vSurabay,1);
        vDistances[8] = getOrthodromicDistance(vSurabay,vTrinquemalay,1);
        vDistances[9] = getOrthodromicDistance(vTrinquemalay,vKarachi,1);
        vDistances[10] = getOrthodromicDistance(vKarachi,vBahrain,1);
        vDistances[11] = getOrthodromicDistance(vBahrain,vKhartoum,1);
        vDistances[12] = getOrthodromicDistance(vKhartoum,vLepoldville,1);
        vDistances[13] = getOrthodromicDistance(vLepoldville,vNatal,1);
        vDistances[14] = getOrthodromicDistance(vNatal,vPortDeSpain,1);
        vDistances[15] = getOrthodromicDistance(vPortDeSpain,vLaGuardiaNewYork,1);
        
        return vDistances;
    }
}