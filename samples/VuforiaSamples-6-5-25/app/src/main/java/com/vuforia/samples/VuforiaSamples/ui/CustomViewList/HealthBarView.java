package com.vuforia.samples.VuforiaSamples.ui.CustomViewList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.vuforia.samples.VuforiaSamples.app.TapAR.TapAR;
import com.vuforia.samples.VuforiaSamples.data.Player;

/**
 * Created by Steven Ye on 12/11/2017.
 */

public class HealthBarView extends View {

    private int health;
    private String name;

    private Paint paintBg;
    private Paint paintFg;
    private Paint paintText;

    public HealthBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        health = Player.MAX_HEALTH;

        paintBg = new Paint();
        paintBg.setColor(Color.GRAY);
        paintBg.setAlpha(50);
        paintBg.setStyle(Paint.Style.FILL);

        paintFg = new Paint();
        paintFg.setColor(Color.GREEN);
        paintFg.setAlpha(50);
        paintFg.setStyle(Paint.Style.FILL);

        paintText = new Paint();
        paintText.setColor(Color.WHITE);
        paintText.setAlpha(20);
        paintText.setTextSize(40);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0, 0, getWidth(), getHeight(), paintBg);
        float portion = (float) health / Player.MAX_HEALTH;
        paintFg.setColor(Color.rgb(1, 1, 1));
        canvas.drawRect(0, 0, portion * getWidth(), getHeight(), paintFg);

        canvas.drawText("HELLO", 30, 200, paintText);
    }
}
