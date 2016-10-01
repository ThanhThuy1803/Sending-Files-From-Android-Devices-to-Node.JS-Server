package vanpho.com.nodejsserverfile;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by MyPC on 22/09/2016.
 */
public class Recorder {
    private MediaRecorder myRecorder;
    private MediaPlayer myPlayer;
    private String outputFile = null;
    private Context context;

    public Recorder(Context context){
        this.context = context;
    }

    private void init(){
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/khoaphamvn.3gpp";
        myRecorder = new MediaRecorder();
        myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myRecorder.setOutputFile(outputFile);
    }

    public void start(){
        try {
            init();
            myRecorder.prepare();
            myRecorder.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(context, "Start recording...",
                Toast.LENGTH_SHORT).show();
    }
    public void stop(){
        try {
            myRecorder.stop();
            myRecorder.release();
            myRecorder  = null;

            Toast.makeText(context, "Stop recording...",
                    Toast.LENGTH_SHORT).show();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
