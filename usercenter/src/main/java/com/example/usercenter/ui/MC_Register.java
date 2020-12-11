package com.example.usercenter.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public
class MC_Register extends androidx.appcompat.widget.AppCompatTextView {

    private Paint paint = new Paint();

    public MC_Register(@NonNull Context context) {
        super(context);
    }

    public MC_Register(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MC_Register(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(50);

        int width = getWidth();
        int height = getHeight();

        paint.setTextSize(100);

        paint.setTextAlign(Paint.Align.CENTER);


        Paint paint1 = new Paint();
        paint1.setStrokeWidth(10);
        paint1.setColor(Color.BLUE);
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);


//        canvas.drawCircle(width/2,height/2-15,200,paint1);
        canvas.drawText("REGISTER",width/2,height/2,paint);

    }
}
