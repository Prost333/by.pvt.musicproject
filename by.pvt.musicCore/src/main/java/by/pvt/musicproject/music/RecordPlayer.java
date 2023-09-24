package by.pvt.musicproject.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class RecordPlayer {
    public void Play (String file){
        try {
            File joy = new File("C:\\musikdb\\wav\\"+file);
            AudioInputStream ais = AudioSystem.getAudioInputStream(joy);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength()/1000);
            clip.stop();
            clip.close();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
        } catch (InterruptedException exc) {}
    }
}
