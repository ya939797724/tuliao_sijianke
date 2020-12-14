package baseview.timer;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseview.R;

import java.util.ArrayList;
import java.util.List;

public class TimerView extends RelativeLayout {
    private float touchX;
    private float touchY;
    private List<TimerEntity> timerEntities=new ArrayList<>();
    private TimerAdapter timerAdapter;

    ImageView expandimg;
    TextView myactivity;
    private RecyclerView recyclerView;

    private Boolean flag=false;

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
        setMeasuredDimension(widthMeasureSpec,heightMeasureSpec);
    }


    private void initData(Context context) {
        this.setPivotX(this.getPivotX());
        this.setPivotY(this.getPivotY()+500);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOntouch){
                    if (flag){
                        ObjectAnimator transx = ObjectAnimator.ofFloat(TimerView.this, "scaleX", 1f);
                        ObjectAnimator transy = ObjectAnimator.ofFloat(TimerView.this, "scaleY", 1f);
                        AnimatorSet animator = new AnimatorSet();
                        animator.setDuration(1000);
                        animator.play(transx).with(transy);
                        animator.start();
                        flag=false;
                        timerAdapter.notifyDataSetChanged();
                    }
                }

            }
        });

        myactivity = new TextView(context);
        expandimg=new ImageView(context);
        expandimg.setImageResource(R.drawable.ic_baseline_filter_center_focus_24);
        expandimg.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        expandimg.setX(530);
        expandimg.setY(10);

        myactivity.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        myactivity.setText("我的活动");
        myactivity.setTextSize(25);
        myactivity.setTextColor(Color.parseColor("#B9C5BA"));
        myactivity.setX(190);
        myactivity.setY(10);
        addView(expandimg);
        addView(myactivity);

        expandimg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOntouch){
                    if (!flag){
                        ObjectAnimator transx = ObjectAnimator.ofFloat(TimerView.this, "scaleX", 0.1f);
                        ObjectAnimator transy = ObjectAnimator.ofFloat(TimerView.this, "scaleY", -0.1f);
                        AnimatorSet animator = new AnimatorSet();
                        animator.setDuration(1000);
                        animator.play(transx).with(transy);
                        animator.start();
                        flag=true;

                        recyclerView.setVisibility(View.GONE);
                    }
                }
            }
        });

    }

}
