package fr.miage.m2;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTests {


    @Test
    public void startEndhour(){
        String availability="14h-18h";
        String[] startEnd = availability.split("-");
        // if (startEnd[0]==24)
//        startEnd[0]=startEnd[0].substring(0,startEnd[0].length()-1);
//        startEnd[1]=startEnd[1].substring(0,startEnd[1].length()-1);
//        Assert.assertEquals("14",startEnd[0]);
//        Assert.assertEquals("18",startEnd[1]);

        int start = Integer.valueOf(startEnd[0].substring(0,startEnd[0].length()-1));
        int end = Integer.valueOf(startEnd[1].substring(0,startEnd[1].length()-1));

        Assert.assertEquals(14,start);
        Assert.assertEquals(18,end);
    }
}
