package baseview.timer;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseview.R;


public class TimerView extends RelativeLayout {
    ImageView expandimg;

    private RecyclerView recyclerView;

    private Boolean flag = false;

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    private boolean isOntouch = false;

    public TimerView(Context context) {
        super(context);
    }

    public TimerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public TimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    private void initData(Context context) {
        this.setPivotX(this.getPivotX());
        this.setPivotY(this.getPivotY() + 500);

        expandimg = new ImageView(context);
        expandimg.setImageResource(R.drawable.ic_baseline_filter_center_focus_24);
        expandimg.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        expandimg.setX(530);
        expandimg.setY(10);
        addView(expandimg);

        expandimg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    ObjectAnimator transx = ObjectAnimator.ofFloat(TimerView.this, "translationX", -getWidth() + expandimg.getWidth() + 20);
                    AnimatorSet animator = new AnimatorSet();
                    animator.setDuration(1000);
                    animator.play(transx);
                    animator.start();
                    flag = true;
                } else {
                    ObjectAnimator transx = ObjectAnimator.ofFloat(TimerView.this, "translationX", 0);
                    AnimatorSet animator = new AnimatorSet();
                    animator.setDuration(1000);
                    animator.play(transx);
                    animator.start();
                    flag = false;
                }

            }
        });

    }
}
