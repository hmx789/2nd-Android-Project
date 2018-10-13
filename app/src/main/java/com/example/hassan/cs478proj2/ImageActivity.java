package com.example.hassan.cs478proj2;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    private int resid= -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView imageView = new ImageView(getApplicationContext());
        setContentView(imageView);
        final Intent intent = getIntent();
        if (intent != null) {
            resid = intent.getIntExtra("res_id",-1);
            imageView.setImageResource(resid);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (intent != null) {
                    String url = ID2Link.getMap().get(resid);
                    Intent i = new Intent(Intent.ACTION_VIEW);      // Opening the browser
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            }
        });

    }
}
