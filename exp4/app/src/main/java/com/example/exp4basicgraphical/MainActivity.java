package com.example.exp4basicgraphical;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;

public class MainActivity extends AppCompatActivity {
    SampleViewDraw mSampleViewDraw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSampleViewDraw = new SampleViewDraw(this);
        setContentView(mSampleViewDraw);
//        setContentView(R.layout.activity_main);
    }
    public class SampleViewDraw extends View {
        public SampleViewDraw(Context context) {
            super(context);
        }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED); int x = getWidth();
        int y = getHeight();
        canvas.drawCircle(x / 2, y / 2, 100, paint);
        paint.setColor(Color.MAGENTA); canvas.drawRect(100,
                200, 350, 400, paint);
    }}}