package sample;

//For accessing this utility, keep a static media player named mediaPlayer

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class AudioUtility extends Application {

    public static MediaPlayer mediaPlayer;

    public void play(String path){
        String uri=Paths.get(path).toUri().toString();
        Media media = new Media(uri);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();
    }

    public void play(){
        if(mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED){
            mediaPlayer.play();
        }
    }

    public void pause(){
        if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
            mediaPlayer.pause();
        }
    }

    public void setVolume(double vol){
        mediaPlayer.setVolume((float)vol/100);
    }

    public void mute(){
        mediaPlayer.setVolume(0.0);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

}
