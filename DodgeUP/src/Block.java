import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Random;

public class Block extends PApplet implements Objectinterface{

    public  static int speedY=-100;
    int locationX;
    int locationY;
//    int colorr;
//    int colorg;
//    int colorb;

    private static PApplet pApplet= Main.pApplet;



    public Block(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
//        this.colorr=colorr;
//        this.colorg=colorg;
//        this.colorb=colorb;

    }

    public static void makeBlocks(){

        for (int i=0;i<30;i++) {
            Main.blocks.add(new Block(new Random().nextInt(1,650),speedY));
            speedY-=96;
            Main.blocks.add(new Block(new Random().nextInt(1,650),speedY));
            speedY-=96;
            Main.blocks.add(new Block(new Random().nextInt(1,650),speedY));
            speedY-=96;
            Main.blocks.add(new Block(new Random().nextInt(1,650),speedY));
            speedY-=96;
            Main.blocks.add(new Block(new Random().nextInt(1,650),speedY));
            speedY-=96;
        }
    }

    public static void showBlock(ArrayList<Block> blocks) {
        for (Block block: blocks) {
//            int randomno=new Random().nextInt(250-1)+1;
//            pApplet.fill(randomno);
              pApplet.fill(new Random().nextInt(1,250),new Random().nextInt(1,250),new Random().nextInt(1,250));
              pApplet.rect(block.getLocationX(),block.getLocationY(),50,70);

        }
    }

    public static void moveBlock(int speed) {
        for (Block block:Main.blocks) {
            block.locationY +=speed;
        }
    }


    public static  void removeBlock(){

        for(int i=0;i<Main.blocks.size();i++){
            if(Main.blocks.get(i).locationY >700){
                Main.removed++;
                Main.blocks.remove(i);
            }
        }
    }
    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public void showobject(){

    }

}
