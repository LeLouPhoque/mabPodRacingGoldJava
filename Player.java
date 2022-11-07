import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int compteur = 0;
        double oldDistanceX = 0;
        double oldX = 0;
        double oldY = 0;
        int offsetX = 1;
        int offsetY = 1;
        double plusLong  = 0;
        Boolean booster = false;
        Boolean isUsed = false;
        double maxThrust = 100;
        int theMax = 0;
        double test = 100;
        double sqrt = 0;
        double su = 0;
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            double angle = in.nextInt();
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();
            if (oldDistanceX != nextCheckpointX)
            {
                test = ((nextCheckpointX - x)*(nextCheckpointX - x)) + ((nextCheckpointY - y)*(nextCheckpointY - y));
                sqrt = Math.sqrt(test);
                if (isUsed == false){
                    compteur++;
                    if (plusLong < nextCheckpointDist) {
                        plusLong = nextCheckpointDist;
                    }
                    if (plusLong == nextCheckpointDist && compteur >= 5) {
                        booster = true;
                    }
                }
            }
            oldDistanceX = nextCheckpointX;
            if (compteur > 1){
                offsetX = (int) (-3 * (x - oldX));
                offsetY = (int) (-3 * (y - oldY));
            }
            su = nextCheckpointDist/sqrt;
            if (su >= 0.1 )
                su = 1;
            else
                su += 0.9;
            if (angle <= 90 && angle > 0)
            {
                 maxThrust = (1 - angle/90) * 100 * su;
            }else if (angle >= -90 && angle <= 0) {
                 maxThrust = (1 + angle/90) * 100 * su;
            }else{
                maxThrust = 0;
            }
            theMax = (int) maxThrust ;
            if (angle>-15 && angle<15 && booster == true){
                boost(nextCheckpointX,nextCheckpointY);
                isUsed = true;
                booster = false;
            }
            oldX = x;
            oldY = y;
            move(nextCheckpointX+offsetX,nextCheckpointY+offsetY, theMax);
        }
    }

    static public void boost(int x,int y) {
        System.out.println(x+" "+y+" "+" BOOST");
    }

    static public void move(int x, int y, int t ) {
        System.out.println(x+" "+y+" "+t);
    }

    static public void maxMaxThrust(int angle,double maxThrust){

    }
}
