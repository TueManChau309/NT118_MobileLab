package com.example.lab05_04;

import android.os.Bundle;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnStream, btnStop;
    EditText etURL;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etURL = findViewById(R.id.etURL);
        btnStream = findViewById(R.id.btnStream);
        btnStop = findViewById(R.id.btnStop);

        btnStream.setOnClickListener(view -> {
            String url = etURL.getText().toString();
            Log.d("mylog", "Streaming URL: " + url);
            new MediaPlayerAsyncTask().execute(url);
        });

        btnStop.setOnClickListener(view -> stopPlaying());
    }

    private void startAudioStream(String url) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.setOnPreparedListener(mp -> mediaPlayer.start());
            mediaPlayer.setOnErrorListener((mp, what, extra) -> {
                Log.d("mylog", "MediaPlayer Error: what=" + what + ", extra=" + extra);
                return true;
            });
            mediaPlayer.prepareAsync();  // Use prepareAsync() instead of prepare()
            mediaPlayer.setVolume(3f, 3f);
            mediaPlayer.setLooping(false);
        } catch (Exception e) {
            Log.d("mylog", "Error playing in SoundHandler: " + e.toString());
        }
    }

    private void stopPlaying() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private class MediaPlayerAsyncTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... urls) {
            //Gọi phương thức startAudioStream(mp3Url) để bắt đầu phát âm thanh từ URL
            String mp3Url = urls[0];
            startAudioStream(mp3Url);
            return null;
        }
    }
}