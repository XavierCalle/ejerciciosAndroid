package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button b5;
    int posicion =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b5=(Button)findViewById(R.id.button5);
    }

    public void destruir(){
        if(mp != null)
            mp.release();
    }

    public void iniciar(View v){
        destruir();
        mp = MediaPlayer.create(this, R.raw.prueba);
        mp.start();
        String op = b5.getText().toString();
        if(op.equals("No reproducir en forma circular"))
            mp.setLooping(false);
        else
            mp.setLooping(true);

    }

    public void pausar (View v){
        if(mp != null && mp.isPlaying()){
            posicion = mp.getCurrentPosition();
            mp.pause();
        }
    }

    public void continuar (View v){
        if(mp != null && mp.isPlaying() == false){
            mp.seekTo(posicion);
            mp.start();
        }
    }

    public void detener(View v){
        if(mp != null){
            mp.stop();
            posicion = 0;
        }
    }

    public void circular (View v){
        detener(null);
        String op = b5.getText().toString();
        if(op.equals("No reproducir en forma circular"))
            b5.setText("Reproducir en forma circular");
        else
            b5.setText("No reproducir en forma circular");
    }
}