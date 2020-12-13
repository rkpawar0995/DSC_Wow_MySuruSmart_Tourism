package xyz.rkplap.dschack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread() {
            public void run() {

                try {
                    sleep(3000);
                } catch (
                        InterruptedException e) {

                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(Splash.this, Login.class);
                    startActivity(i);
                }
            }
        };
         timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}