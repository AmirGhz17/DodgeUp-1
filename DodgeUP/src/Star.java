import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Random;

public class Star implements Objectinterface{
    int locationX;
    int locationY;
    public  static int speedY=-300;

    private static PApplet pApplet= Main.pApplet;


    public Star(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public static void makeStars(){
        for (int i=0;i<7;i++){

            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,650),speedY));
            speedY-=400;
        }
    }
    private static PImage starimage;
    public static void Starface() {

        starimage = Main.pApplet.loadImage("Star2.png");
        Random random = new Random();

        for (int i=0 ; i<100 ; i++) {
            Main.stars.add(new Star(random.nextInt(10, 650), random.nextInt(-10000, -100 )));
        }
    }

    public static void showStar(ArrayList<Star> stars) {
        for (Star star: stars) {

            Main.pApplet.image(starimage,star.getLocationX(),star.getLocationY(),30,30);
//            pApplet.fill(new Random().nextInt(250),new Random().nextInt(1,250),new Random().nextInt(1,254));
//            pApplet.rect(star.getLocationX(),star.getLocationY(),20,20);
        }
    }

    public static void moveStar(int speed) {
        for (Star star:Main.stars) {
            star.locationY +=speed;
        }
    }
    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void showobject(){
        starimage = Main.pApplet.loadImage("Star2.png");
    }


}
