package baseview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class BaseImage extends androidx.appcompat.widget.AppCompatImageView {
    private int defaultWidth = 200;
    private int defaultHeight = 100;

    public BaseImage(Context context) {
        super(context);
    }

    public BaseImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST&&MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST){
            setMeasuredDimension(defaultWidth,defaultHeight);
        }else if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST){
            setMeasuredDimension(defaultWidth,height);
        } else if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width,defaultHeight);
        }
    }


}
