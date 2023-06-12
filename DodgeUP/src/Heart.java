import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Random;

public class Heart implements Objectinterface{
    public  static int speedY=-700;
    int locationX;
    int locationY;

    private static PApplet pApplet= Main.pApplet;



    public Heart(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;

    }

    public static void makeHearts(){
        for (int i=0;i<4;i++){

            Main.hearts.add(new Heart(new Random().nextInt(1,650),speedY));
            speedY-=700;
            Main.hearts.add(new Heart(new Random().nextInt(1,650),speedY));
            speedY-=700;
            Main.hearts.add(new Heart(new Random().nextInt(1,650),speedY));
            speedY-=700;
            Main.hearts.add(new Heart(new Random().nextInt(1,650),speedY));
            speedY-=700;
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


    private static PImage heartimage;
    public static int lives = 3;

    public static void Heartface() {
        lives = 3;
        heartimage = Main.pApplet.loadImage("Heart3.png");
    }


    public static void showHeart(ArrayList<Heart> hearts) {
        for (Heart heart: hearts) {

            Main.pApplet.image(heartimage,heart.getLocationX(),heart.getLocationY(),30,30);
//            pApplet.fill(255,0,0);
//            pApplet.rect(heart.getLocationX(),heart.getLocationY(),20,20);
        }
    }


    public static void moveHeart(int speed) {
        for (Heart heart:Main.hearts) {
            heart.locationY +=speed;
        }
    }

   public void showobject(){
       heartimage = Main.pApplet.loadImage("Heart3.png");
    }
}
