package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;
    private Button mButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ربط العناصر مع الـ IDs الموجودة في ملف الـ XML
        mShowCount = findViewById(R.id.show_count);
        mButtonZero = findViewById(R.id.button_zero);
        mButtonCount = findViewById(R.id.button_count);

        // تعيين لون رمادي لزر Zero عند بداية تشغيل التطبيق
        if (mButtonZero != null) {
            mButtonZero.setBackgroundColor(ContextCompat.getColor(this, R.color.button_gray));
        }
    }

    public void show_toast(View view) {
        Toast toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void increase_count(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

        // 1. تغيير لون زر Count ديناميكياً (أخضر إذا فردي، أزرق إذا زوجي)
        if (mButtonCount != null) {
            if (mCount % 2 == 1) {
                mButtonCount.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            } else {
                mButtonCount.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
            }
        }

        // 2. تنشيط زر Zero وتغيير لونه (لأنه أصبح أكبر من صفر)
        if (mButtonZero != null) {
            mButtonZero.setBackgroundColor(ContextCompat.getColor(this, R.color.button_active));
        }
    }

    public void zeroZero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

        // إعادة لون زر Zero إلى الرمادي عند التصفير
        if (mButtonZero != null) {
            mButtonZero.setBackgroundColor(ContextCompat.getColor(this, R.color.button_gray));
        }
    }
}