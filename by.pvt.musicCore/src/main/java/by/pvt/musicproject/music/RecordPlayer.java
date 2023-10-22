package by.pvt.musicproject.music;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecordPlayer {
    public void play(String file){
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
    public  void Playlist(List<String> file){
        try {
            for (int i=0; i< file.size();i++) {
                String m=file.get(i);
                File p= new File("C:\\musikdb\\wav\\"+m);
                AudioInputStream ais = AudioSystem.getAudioInputStream(p);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.setFramePosition(0);
                clip.start();
                Thread.sleep(clip.getMicrosecondLength()/1000);
                clip.stop();
                clip.close();
            }
        }catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
            exc.printStackTrace();
        } catch (InterruptedException exc) {}
    }

}
