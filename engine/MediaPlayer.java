package engine;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
            if (repeat) {
                clip.open(audio);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.stop();
            }else{
                clip.open(audio);
                clip.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("failed to load audio");
        }

        return clip;
    }
}
