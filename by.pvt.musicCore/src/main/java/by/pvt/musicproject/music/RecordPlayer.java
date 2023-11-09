package by.pvt.musicproject.music;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecordPlayer {
    private AtomicBoolean stop = new AtomicBoolean(false);


    public void Playlist(List<String> file) {
        new Thread(() -> {
            try {
                for (String s : file) {
                    if (stop.get()) break;
                    File audioFile = new File("C:\\musikdb\\wav\\" + s);
                    AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.setFramePosition(0);
                    clip.start();

                    while (!clip.isRunning()) {
                        Thread.sleep(10);
                    }

                    while (clip.isRunning()) {
                        Thread.sleep(10);
                    }

                    clip.close();
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }).start();
    }
    public boolean stopPlaying() {
        return  true;
    }

    public void playlist(List<String> file) {
        AtomicBoolean stop = new AtomicBoolean(false);

        Thread thread = new Thread(() -> {
            try {
                for (String s : file) {
                    if (stop.get()) {
                        break;
                    }

                    File audioFile = new File("C:\\musikdb\\wav\\" + s);
                    AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.setFramePosition(0);
                    clip.start();

                    while (!clip.isRunning()) {
                        Thread.sleep(10);
                    }

                    while (clip.isRunning()) {
                        Thread.sleep(10);
                    }

                    clip.close();
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });

        thread.start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                stop.set(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
