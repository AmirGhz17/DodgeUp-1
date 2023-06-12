import processing.core.PImage;

public class Background {

    public static PImage background;
    public static PImage background2;


    public static void loadBackgrounds () {


            background = Main.pApplet.loadImage("BACKGROUND5.jpg");

    }
    public static void loadBackgrounds1 () {

        background2=Main.pApplet.loadImage("BACKGROUND8.jpg");

    }

    public static void loadBackgrounds2 () {

        background2=Main.pApplet.loadImage("winingback2.jpg");

    }


    public static void showBackground() {
        Main.pApplet.image(background, 0, 0, 700, 600);
    }

    public static void showBackground1() {
        Main.pApplet.image(background2, 0, 0, 700, 600);
    }

    public static void showBackground2() {
        Main.pApplet.image(background2, 0, 0, 700, 600);
    }

}

