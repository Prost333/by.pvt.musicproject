package by.pvt.musicproject.music;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
@Service
public class RecordPlayer {
    private Player player;
    private FileInputStream fileInputStream;
    private BufferedInputStream bis;
    private long pauseLocation;
    private long songTotalLength;
    private volatile boolean playbackAllowed;

    public double getDuration(String filePath) throws Exception {

        try (FileInputStream stream = new FileInputStream("C:\\musikdb\\wav\\" +filePath)) {
            Bitstream bitstream = new Bitstream(stream);
            Header h = bitstream.readFrame();
            int size = h.calculate_framesize();
            float ms_per_frame = h.ms_per_frame();
            long bytes = stream.available();
            float framecount = bytes / size;
            float durationInSeconds = framecount * ms_per_frame / 1000.0f;
            return durationInSeconds;
        }
        catch (Exception e) {
            throw e;
        }
    }
    public void next() {
        if (player != null) {
            player.close();
            pauseLocation = 0;
            songTotalLength = 0;
        }
    }

    public void stop() {
        playbackAllowed = false;
        if (player != null) {
            player.close();
            pauseLocation = 0;
            songTotalLength = 0;
        }
    }

    public void pause() {
        playbackAllowed = false;
        if (player != null && fileInputStream != null) {
            try {
                pauseLocation = fileInputStream.available();
                player.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void playList(List<String> files) {
        playbackAllowed = true;
        new Thread(() -> {
            for (String filePath : files) {
                if (!playbackAllowed) break;
                try {
                    fileInputStream = new FileInputStream("C:\\musikdb\\wav\\" + filePath);
                    bis = new BufferedInputStream(fileInputStream);
                    songTotalLength = bis.available();
                    if (pauseLocation > 0) {
                        fileInputStream.skip(songTotalLength - pauseLocation);
                    }
                    player = new Player(bis);
                    player.play();
                } catch (JavaLayerException | IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
