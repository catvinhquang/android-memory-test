package com.example.stress;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bitmap bitmap = Bitmap.createBitmap(5120, 5120, Bitmap.Config.ARGB_8888);
        new Canvas(bitmap).drawColor(Color.RED);

        TextView v = new TextView(this);
        v.setBackgroundDrawable(new BitmapDrawable(bitmap));
        v.setGravity(Gravity.CENTER);
        v.setTextSize(50);
        v.setText(Utils.getInstance().text
                + "\n"
                + Utils.getInstance().count
                + "\n"
                + Utils.getInstance().getUsedSize(this));
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
        setContentView(v);

        Utils.getInstance().text = DateFormat.format("HH:mm:ss", System.currentTimeMillis()).toString();
        Utils.getInstance().count++;
    }

}