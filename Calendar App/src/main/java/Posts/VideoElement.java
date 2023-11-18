package Posts;

import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class VideoElement implements VisualElement{

    private MediaPlayer mediaPlayer;
    private String mediaPath;

    public VideoElement (String mediaPath){
        this.mediaPath = mediaPath;
    }

    @Override
    public Node createVisual () {
        Media media = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setPreserveRatio(false);
        mediaView.setFitWidth(325);
        mediaView.setFitHeight(189);
        mediaView.setLayoutX(14);
        mediaView.setLayoutY(35);
        mediaView.setOnMousePressed(e -> {
            setVideoActions();
        });
        return (Node) mediaView;
    }

    private void setVideoActions (){
        if (mediaPlayer.getStatus().equals(Status.READY)){
            mediaPlayer.play();
        } 
        if (mediaPlayer.getStatus().equals(Status.PLAYING)){
            mediaPlayer.pause();
        }
        if (mediaPlayer.getStatus().equals(Status.PAUSED)){
            mediaPlayer.play();
        }
        if (mediaPlayer.getCurrentTime().equals(mediaPlayer.getTotalDuration())){
            mediaPlayer.seek(Duration.seconds(0.0));
            mediaPlayer.play();
        }
    }
}