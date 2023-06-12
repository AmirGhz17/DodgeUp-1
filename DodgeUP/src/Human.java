import processing.core.PImage;

public class Human implements Objectinterface {
    
    int width = 15;
    public void star() {
        int j=Main.stars.size();
        for (int i = 0; i < j; i++) {
            if (Main.pApplet.mouseX < Main.stars.get(i).locationX) {
                if (Main.stars.get(i).locationX - Main.pApplet.mouseX <= 15 && 525 - Main.stars.get(i).locationY <= 70 && 525 - Main.stars.get(i).locationY > -70) {
                    Main.score+=10;
                    j--;
                    Main.stars.remove(Main.stars.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.stars.get(i).locationX <= 50 && 525 - Main.stars.get(i).locationY <= 70 && 525 - Main.stars.get(i).locationY > -70) {
                    Main.score+=10;
   
                    j--;
                    Main.stars.remove(Main.stars.get(i));

                }
            }
        }
    }
    
    int lives = 3;
    public void heart() {
        for (int i = 0; i < Main.hearts.size(); i++) {
            if (Main.pApplet.mouseX < Main.hearts.get(i).locationX) {
                if (Main.hearts.get(i).locationX - Main.pApplet.mouseX <= 15 && 525 - Main.hearts.get(i).locationY <= 70 && 525 - Main.hearts.get(i).locationY > -70) {
                    if(lives<5){
                        lives++;
                    }
                    Main.hearts.remove(Main.hearts.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.hearts.get(i).locationX <= 50 && 525 - Main.hearts.get(i).locationY <= 70 && 525 - Main.hearts.get(i).locationY > -70) {
                    if(lives<5){
                        lives++;
                    }
                    Main.hearts.remove(Main.hearts.get(i));

                }
            }
        }
    }
    
    public void lose() {
        for (int i = 0; i < Main.blocks.size(); i++) {
            if (Main.pApplet.mouseX < Main.blocks.get(i).locationX) {
                if (Main.blocks.get(i).locationX - Main.pApplet.mouseX <= 15 && 475 - Main.blocks.get(i).locationY <= 70 && 475 - Main.blocks.get(i).locationY > -70) {
                    lives--;
                    Main.hit++;
                    Main.blocks.remove(Main.blocks.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.blocks.get(i).locationX <= 70 && 475 - Main.blocks.get(i).locationY <= 70 && 475 - Main.blocks.get(i).locationY > -70) {
                    lives--;
                    Main.hit++;
                    Main.blocks.remove(Main.blocks.get(i));

                }
            }
        }
    }

    public void passed(){
        for(int i=0;i<Main.blocks.size();i++){
            if(Main.blocks.get(i).locationY >700){
                Main.passed++;
            }
        }
    }


    private static PImage human;

    public static void humanface() {
        human = Main.pApplet.loadImage("Human2.png");
    }
    public static void showHuman() {

        int directionX = Main.pApplet.mouseX - 25;

        Main.pApplet.image(human, directionX,475, 50,70);

    }

    public void showobject(){
        human = Main.pApplet.loadImage("Human2.png");
    }

}

