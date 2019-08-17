package com.tigoune.utils;

import java.awt.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.awt.event.InputEvent;
import org.sikuli.script.Match;
import org.sikuli.script.*;

public class data {

    public static void main(String args[]) throws AWTException, FindFailed {
        // Define 2 list to get X and Y
        List <Integer> x = new ArrayList<>();
        List <Integer> y = new ArrayList<>();
        data t = new data();
        t.getCoordinates(x,y);
        t.clickOnTarget(x,y);
    }

    public void clickOnTarget(List <Integer> x, List <Integer> y) throws AWTException {
        Robot r = new Robot();
        for (int i = 0; i < x.size(); i++) { // From 0 to the number of checkboxes saved on X list
            r.mouseMove(x.get(i), y.get(i));
            r.delay(500);
            r.mousePress(InputEvent.BUTTON1_MASK); //Press click
            r.mouseRelease(InputEvent.BUTTON1_MASK); // Release click
            r.delay(5000);
            // And your code goes here
        }
    }

    public void getCoordinates(List <Integer> x, List <Integer> y) throws FindFailed {
        ImagePath.add("src/test/resources/images/Siebel/CreateProduct");
        Screen s = new Screen();
        Iterator <Match> matches = s.findAll(new Pattern("checkbox.png").similar(0.9f)); // Get all coincidences and save them
        Match archivo;
        int n=0;
        Location l;
       /// for (int i=0; i==3; i= i+1) {
            while (matches.hasNext()) {
                Match m = matches.next(); // Get next value from loop
                if(n == 3) {
                    l = new Location(m.getTarget()); // Get location
                    // Add to the list of coordinates
                    x.add(l.getX());
                    y.add(l.getY());
                    System.out.println("Coordinates: x: " + l.getX() + " y: " + l.getY());
                }
                n = n + 1;
            }
        ///}
    }
}