package bw.com.work13;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class view extends View {
    public view(Context context) {
        this(context,null);

    }

    public view(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    public view(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
