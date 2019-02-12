package bw.com.work13;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView circle = findViewById(R.id.circle);

        ObjectAnimator scaleY = ObjectAnimator.ofFloat(circle, "scaleY", 1f, 5f, 1f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(circle, "scaleX", 1f, 5f, 1f);

        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(2000);
        animSet.start();

    }
}
