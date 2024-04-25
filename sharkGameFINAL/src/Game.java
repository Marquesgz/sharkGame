import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {

    Keyboard kb;
    Sound backgroundSound = new Sound();

    public void init() {

        Shark shark = new Shark();
        kb = new Keyboard(shark);
        keyboardEvent();
        shark.startScreen();
        shark.checkCollision();
        backgroundSound.play();
    }

    public void keyboardEvent() {

        KeyboardEvent rightKeyPressed = new KeyboardEvent();
        rightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(rightKeyPressed);

        KeyboardEvent leftKeyPressed = new KeyboardEvent();
        leftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(leftKeyPressed);

        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(upKeyPressed);

        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(downKeyPressed);

        KeyboardEvent sKeyPressed = new KeyboardEvent();
        sKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        sKeyPressed.setKey(KeyboardEvent.KEY_S);
        kb.addEventListener(sKeyPressed);

        KeyboardEvent rKeyPressed = new KeyboardEvent();
        rKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rKeyPressed.setKey(KeyboardEvent.KEY_R);
        kb.addEventListener(rKeyPressed);
    }
}




