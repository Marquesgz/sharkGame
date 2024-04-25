import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shark implements ActionListener, KeyboardHandler {


    private static final int PADDINGx = 10;
    private static final int PADDINGy = 40;
    Picture startGame;

    Picture background;
    private int canvasWidth;
    private int canvasHeight;
    Picture shark;

    Text textScore;
    Text gameOverText;
    Picture person = new Picture(20, 50, "person.png");
    int rows = 13;
    int cols = 23;
    static final private int cellSize = 50;
    int height = cellSize * rows;
    int width = cellSize * cols;
    char direction = 'R';
    int edibleX;
    int edibleY;
    int score;

    private boolean start = false;
    private boolean restart;
    private Picture blood;
    Sound backgroundSound = new Sound();
    Sound scream = new Sound();


    private Timer sharkTimer = new Timer(150, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (direction) {
                case 'U':
                    moveUp();
                    checkEdibleCollision();
                    checkCollision();
                    break;
                case 'D':
                    moveDown();
                    checkEdibleCollision();
                    checkCollision();
                    break;
                case 'L':
                    moveToLeft();
                    checkEdibleCollision();
                    checkCollision();
                    break;
                case 'R':
                    moveToRight();
                    checkEdibleCollision();
                    checkCollision();
                    break;
            }

        }

    });

    public void shark() {
        direction = 'R';
        background = new Picture(10, 10, "GAME-BGV2.png");
        shark = new Picture(PADDINGx + cellSize, PADDINGy + cellSize, "sharkRight.png");
        textScore = new Text(cols * 16, 28, "0");
        background.draw();
        ediblePosition();
        randomEdible();
        shark.draw();
        restart = false;
        score = 0;
        sharkTimer.start();
        textScore.draw();
        textScore.grow(15, 15);
    }

    public void startScreen(){
        startGame = new Picture(10, 10, "BG-FINAL-VF.png");
        startGame.draw();
        backgroundSound.play();
    }

    public void ediblePosition() {
        edibleX = 10 + (((int) ((Math.ceil(Math.random() * 21)) * cellSize)));
        edibleY = 40 + (((int) ((Math.ceil(Math.random() * 11)) * cellSize)));


    }

    public void randomEdible() {
        switch ((int) ((Math.random() * 7))) {
            case 0:
                person.delete();
                person = new Picture(edibleX, edibleY, "Nuno-VF.png");
                person.draw();
                break;
            case 1:
                person.delete();
                person = new Picture(edibleX, edibleY, "Rolo-VF.png");
                person.draw();
                break;
            case 2:
                person.delete();
                person = new Picture(edibleX, edibleY, "Mariana.png");
                person.draw();
                break;
            case 3:
                person.delete();
                person = new Picture(edibleX, edibleY, "Zuka-VF.png");
                person.draw();
                break;
            case 4:
                person.delete();
                person = new Picture(edibleX, edibleY, "David-VF.png");
                person.draw();
                break;
            case 5:
                person.delete();
                person = new Picture(edibleX, edibleY, "Ruben-VF.png");
                person.draw();
                break;
            case 6:
                person.delete();
                person = new Picture(edibleX, edibleY, "Mendanha-VF.png");
                person.draw();
                break;








    }
    }

    public void moveToRight() {

        shark.load("sharkRight.png");
        direction = 'R';
        shark.translate(cellSize, 0);
        System.out.println("Shark: " + shark.getX() + "x - y " + shark.getY());
    }


    public void moveToLeft() {

        shark.load("sharkLeft.png");
        direction = 'L';
        shark.translate(-cellSize, 0);
        System.out.println("Shark: " + shark.getX() + "x - y " + shark.getY());
    }

    public void moveDown() {

        shark.load("sharkDown.png");
        direction = 'D';
        shark.translate(0, cellSize);
        System.out.println("Shark: " + shark.getX() + "x - y " + shark.getY());
    }


    public void moveUp() {

        shark.load("sharkUp.png");
        direction = 'U';
        shark.translate(0, -cellSize);
        System.out.println("Shark: " + shark.getX() + "x - y " + shark.getY());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if ('R' == direction) {
                    break;
                }
                if ('L' == direction){
                    break;
                }
                moveToRight();
                checkEdibleCollision();
                break;
            case KeyboardEvent.KEY_LEFT:
                if (direction == 'R') {
                    break;
                }
                if (direction == 'L'){
                    break;
                }
                moveToLeft();
                checkEdibleCollision();
                break;
            case KeyboardEvent.KEY_DOWN:
                if (direction == 'U') {
                    break;
                }
                if(direction == 'D'){
                    break;
                }
                moveDown();
                checkEdibleCollision();
                break;
            case KeyboardEvent.KEY_UP:
                if (direction == 'D') {
                    break;
                }
                if (direction == 'U'){
                    break;
                }
                moveUp();
                checkEdibleCollision();
                break;
            case KeyboardEvent.KEY_S:
                if (!start) {
                    shark();
                    start = true;
                }
                break;
            case KeyboardEvent.KEY_R:
                if (restart) {
                    shark.delete();
                    gameOverText.delete();
                    backgroundSound.play();
                    shark();
                    break;
                }

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void checkEdibleCollision() {
        if (((shark.getX() == person.getX()) && (shark.getY() == person.getY()))) {
           if(person.pixels() == 3150 ){
               System.out.println("xd");
               // aqui metes o som do david a dar
            scream.david();
            }
            else {
                scream.Scream();
            }
            score = score + 15;

            textScore.setText(String.valueOf(score));
            Picture blood = new Picture(edibleX, edibleY, "Blood.png");
            blood.draw();
            ediblePosition();
            randomEdible();
            if(sharkTimer.getDelay() > 53) {
                sharkTimer.setDelay(sharkTimer.getDelay() - 8);
            }
        }

    }

    public void checkCollision() {
        if (shark.getX() > width - PADDINGx) {
            sharkTimer.stop();
            gameOver();
            restart = true;
        }
        if (shark.getY() > height - PADDINGy) {
            sharkTimer.stop();
            gameOver();
            restart = true;
        }
        if (shark.getX() < PADDINGx) {
            sharkTimer.stop();
            gameOver();
            restart = true;
        }
        if (shark.getY() < PADDINGy - 5) {
            sharkTimer.stop();
            gameOver();
            restart = true;
        }
    }

    public void gameOver() {
        Picture gameOver = new Picture(10, 10, "GO-FINAL-VF.png");
        gameOver.draw();
        shark.delete();
        textScore.delete();
        backgroundSound.stop();
        sharkTimer.stop();
        sharkTimer.setDelay(150);

        gameOverText = new Text(615, 400, String.valueOf(score));
        gameOverText.grow(30, 60);
        gameOverText.draw();
    }



}



