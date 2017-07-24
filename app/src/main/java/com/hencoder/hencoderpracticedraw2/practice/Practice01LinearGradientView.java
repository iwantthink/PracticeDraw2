package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
        canvas.translate(500, 0);
        paint.setShader(new LinearGradient(100, 300, 500, 300, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP));
        canvas.drawRect(0, 0, 600, 600, paint);


        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        PathEffect pathEffect = new DashPathEffect(new float[]{5, 10}, 100);
        paint.setPathEffect(pathEffect);
        canvas.drawCircle(200, 200, 100, paint);
//        Path p1 = new Path();
//        p1.moveTo(100, 0);
//        p1.lineTo(100, 500);
//        canvas.drawPath(p1, paint);
//        Path p2 = new Path();
//        p2.moveTo(500, 0);
//        p2.lineTo(500, 500);
//        canvas.drawPath(p2, paint);
        //注意硬件加速！！！会让pathEffect无效
        canvas.drawLine(500, 0, 500, 500, paint);
    }
}
