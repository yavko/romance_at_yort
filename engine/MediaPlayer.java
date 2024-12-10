package engine;
import java.io.File;
import javax.sound.sampled.*;

/**
 * Audio files for the game.
 *
 * @author Ashlyn Y
 * @version 0.1
 */
public final class MediaPlayer { 
    public static Clip createClip(String path, boolean repeat) {
        Clip clip = null;
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());

            clip = AudioSystem.getClip();
            clip.open(audio);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed to load audio");
        }
        if (repeat) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.stop();
        }
        return clip;
    }

    

}
