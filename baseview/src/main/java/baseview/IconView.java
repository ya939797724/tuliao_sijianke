package baseview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class IconView extends androidx.appcompat.widget.AppCompatImageView {

    public IconView(@NonNull Context context) {
        super(context);
    }

    public IconView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IconView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }




}
