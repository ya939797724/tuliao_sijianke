package baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class BaseLinearLayout extends LinearLayout {
    private int num = 0;
    public BaseLinearLayout(Context context) {
        super(context);
    }

    public BaseLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST&&MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST){
            setMeasuredDimension(width,height);
        }else if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST){
            setMeasuredDimension(width,height);
        } else if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width,height);
        }
    }

    public void addItem(int path){
        num++;
        BaseImage baseImage = new BaseImage(getContext());
        baseImage.setImgPath(path);
        baseImage.setImageWidth(getMeasuredWidth()/num);
        addView(baseImage);
    }
}
