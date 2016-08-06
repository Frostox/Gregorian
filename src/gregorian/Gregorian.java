/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gregorian;

import java.util.Vector;

/**
 *
 * @author Roger
 */
public class Gregorian {
    int leap[] = {31,29,31,30,31,30,31,31,30,31,30,31},normal[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    Vector vx = new Vector();
    public Gregorian(){
        vx.add(1);
        vx.add(1);
        vx.add(1800);
        vx.add(3);
    }
    boolean leaps = false;
    public Vector GetYearOffset(int year,int m){
        int diff = year - 1800,yr;
        int no_leap = diff/4;
        int century_lapse = 0;
        int offset = 0;
        century_lapse = diff/100;
        boolean leaps = false;
        if((year%100==0&&year%4==0&&year%400==0)||(year%4==0&&year%100!=0)){leaps = true;}
        System.out.println(""+leaps);
        yr = 1900;
        while(century_lapse > 0){
        if(yr%400 != 0&&yr%4 == 0){
            no_leap--;
        }
        century_lapse--;
        yr += 100;
        }
        yr = 2000;
        
        if(leaps){no_leap -= 1;}
        offset = (diff-no_leap)+(no_leap*2);
        if(offset>7){
            offset = offset % 7;
        }
        
        Vector v = new Vector();
        v.add(no_leap);v.add(diff);v.add(offset);
        return v;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //GetYearOffset(1805);
        //GetYearOffset(2013);
        // TODO code application logic here
        new MainUI("Gregorian (Day Finder V4.0) | RCores").setVisible(true);
    }
}
