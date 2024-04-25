import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    private Clip jaws;
    private Clip scream;
    private Clip david;

    public Sound() {
        try {
            File soundFile = new File("/Users/Miguel/Desktop/sharkGame/resources/Jaws.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            jaws = AudioSystem.getClip();
            jaws.open(audioInputStream);

            File screamFile = new File("/Users/Miguel/Desktop/sharkGame/resources/Scream.wav");
            AudioInputStream audioInputScream = AudioSystem.getAudioInputStream(screamFile);
            scream = AudioSystem.getClip();
            scream.open(audioInputScream);

             File davidFile = new File("/Users/Miguel/Desktop/sharkGame/resources/davidScream.wav");
             AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(davidFile);
             david = AudioSystem.getClip();
             david.open(audioInputStream1);



        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }


    }


    public void play() {
        if (jaws != null) {
            jaws.setFramePosition(0);
            jaws.start();
        }
    }



    public void stop() {
        if (jaws != null) {
            jaws.stop();
        }
    }
    public void david(){
        if(david != null){
            david.setFramePosition(0);
            david.start();
        }
    }



    public void Scream() {
        if (scream != null) {
            scream.setFramePosition(0);
            scream.start();
        }
    }
}
