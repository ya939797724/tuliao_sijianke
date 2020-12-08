package baseview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

class BaseImage extends androidx.appcompat.widget.AppCompatImageView {
    private int defaultWidth = 200;
    private int defaultHeight = 100;
    private Paint paint;
    private int imgPath = 0;

    public BaseImage(Context context) {
        super(context);
        init();
    }

    public BaseImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint({"UseCompatLoadingForDrawables", "DrawAllocation"})
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (imgPath!=0){
            Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(),imgPath);
            canvas.drawBitmap(bitmap,null,paint);
        }

    }

    private void init() {
        paint = new Paint();
    }

    public void setImgPath(int path){
        imgPath = path;
        postInvalidate();
    }

    public void setImageWidth(int width){
        defaultWidth = width;
        requestLayout();
    }
}
