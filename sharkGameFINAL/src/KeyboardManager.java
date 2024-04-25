import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KeyboardManager implements KeyboardHandler {



        private final ExecutorService executorService;

        private Shark shark;
        private Keyboard kb;

        public KeyboardManager() {
            executorService = Executors.newFixedThreadPool(1);
            shark = new Shark();
            shark.shark();
        }


        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

        executorService.execute(() -> {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_RIGHT:
                    if (shark.direction == 'L') {
                        break;
                    }
                    shark.moveToRight();
                    break;
                case KeyboardEvent.KEY_LEFT:
                    if (shark.direction == 'R') {
                        break;
                    }
                    shark.moveToLeft();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if (shark.direction == 'U')
                        break;
                    shark.moveDown();
                    break;
                case KeyboardEvent.KEY_UP:
                    if (shark.direction == 'D')
                        break;
                    shark.moveUp();
                    break;
            }
        });
        }


        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }


    }



