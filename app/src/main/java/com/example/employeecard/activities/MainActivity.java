package com.example.employeecard.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.employeecard.R;
import com.jaredrummler.android.widget.AnimatedSvgView;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    AnimatedSvgView svgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        svgView = findViewById(R.id.m_rbk_animation);
        svgView.start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(MainActivity.this,SecondActivity.class));
                            finish();
                        }
                    });
                }
            }
        });
        thread.start();
    }
}
