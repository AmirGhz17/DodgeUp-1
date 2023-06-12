import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {
    static  int locationY =100;
    static int speed=5;
    static PApplet pApplet;
    static  int no =0;
    static int hit =0;
    static  int highscore =0;
    static int removed =0;
    static int score =0;
    static int passed=5;

    public static ArrayList<Block> blocks=new ArrayList<>();
    public static ArrayList<Star> stars=new ArrayList<>();
    public static ArrayList<Heart> hearts=new ArrayList<>();
    DataBase dataBase = new DataBase();

    public static void main(String[] args) {



        PApplet.main("Main",args);

    }

    Human human;
    public void setup(){
        DataBase.selectHighScore();
        pApplet = this;
        Block.makeBlocks();
        background(128,0,0);
        human = new Human();
        Star.makeStars();
        Heart.makeHearts();
        Star.Starface();
        Heart.Heartface();

    }

    public  void settings(){
        size(700,550);
    }
    boolean start =true;
    boolean lose =false;
    boolean game=false;
    boolean win = false;
    public void draw() {
        if(start){

            Background.loadBackgrounds();
            Background.showBackground();

            fill(255);

            textSize(30);
            text("high score = "+ highscore,250,200);
            if(mouseX<200 && mouseX>150 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            textSize(50);
            text("play",150,300);
            if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                fill(255,0,0);
            }else {
                fill(255);
            }
            text("exit",500,300);

        }
        if(game) {


            Background.loadBackgrounds1();
            Background.showBackground1();
            fill(255);
            text("lives ="+human.lives,10,50 );
            fill(255);
            text("score = "+(score+ passed),450,50);
            Block.showBlock(blocks);
            Block.moveBlock(speed);
            Star.showStar(stars);
            Star.moveStar(speed);
            Heart.showHeart(hearts);
            Heart.moveHeart(speed);
            if(score>120){
                speed=13;
            }else if(score>90){
                speed=11;
            }else if(score>60){
                speed=10;
            }else if(score>30){
                speed=8;
            }
            fill(0, 0, 255);
            rect(mouseX, 650, human.width, human.width);
            Human.humanface();
            Human.showHuman();
            human.passed();
            human.lose();
            human.heart();
            human.star();
            System.out.println("stars:"+stars.size());

            if(human.lives<1){
                DataBase.AddHighScore(score);

                game=false;
                lose = true;
            }
            Block.removeBlock();
            System.out.println("passed:"+passed);
            System.out.println("removed:"+ removed);
            System.out.println("hit:"+hit);
            if(removed +hit==150){
                DataBase.AddHighScore(score+ passed);
                game=false;
                win =true;
            }
        }
        if(lose){

            Background.loadBackgrounds();
            Background.showBackground();

            textSize(30);
            fill(255);
            text("score = "+ (score+ passed),300,200);
            textSize(50);

            if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            text("replay",150,300);
            if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                fill(255,0,0);
            }else {
                fill(255);
            }
            text("exit",500,300);
        }
        if(win){

            Background.loadBackgrounds2();
            Background.showBackground2();

            textSize(30);
            fill(255);
            text("score = "+ (score+ passed),300,150);
            textSize(50);

            if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            text("replay",150,300);
            if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            text("exit",500,300);
        }

        if (abs(mouseX-200)<50 && abs(locationY -650)<75){
            System.out.println("fuck you!");
        }


    }

    @Override
    public void mousePressed() {
        if(start){
            if(mouseX<200 && mouseX>150 && mouseY>250 && mouseY<300){
                start = false;
                game = true;
            }
            if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                exit();
            }
        }
        if(lose){
            if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                lose = false;
                hit=0;
                speed=3;
                score=0;
                removed =0;
                no =0;
                passed=0;
                blocks = new ArrayList<>();
                stars = new ArrayList<>();
                hearts = new ArrayList<>();
                Block.speedY=-100;
                Heart.speedY=-1000;
                Star.speedY=-300;
                Block.makeBlocks();
                Star.makeStars();
                Heart.makeHearts();
                human = new Human();
                game = true;
            }
            if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                exit();
            }
        }
        if(win){
            if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                win = false;
                hit=0;
                speed=3;
                removed =0;
                no =0;
                score=0;
                passed=0;
                blocks = new ArrayList<>();
                stars = new ArrayList<>();
                hearts = new ArrayList<>();
                Heart.speedY=-1000;
                Star.speedY=-300;
                Block.speedY=-100;
                Block.makeBlocks();
                Star.makeStars();
                Heart.makeHearts();
                human = new Human();
                game = true;
            }
            if(mouseX<550 && mouseX>500 && mouseY>250 && mouseY<300){
                exit();
            }
        }
    }
}