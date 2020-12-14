package baseview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

class BaseImage extends androidx.appcompat.widget.AppCompatImageView {
    private int defaultWidth = 200;
    private int defaultHeight = 100;
    private boolean isCheck = false;
    private int animatorTime = 2000;
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

    public void startAnimator(){
        ObjectAnimator scaleX = null;
        ObjectAnimator scaleY = null;
        if (!isCheck){
            scaleX = ObjectAnimator.ofFloat(this, "scaleX", 1, 1.5f);
            scaleY = ObjectAnimator.ofFloat(this, "scaleY", 1, 1.5f);
            isCheck = true;
        }else {
            scaleX = ObjectAnimator.ofFloat(this, "scaleX", 1.5f, 1);
            scaleY = ObjectAnimator.ofFloat(this, "scaleY", 1.5f, 1);
            isCheck = false;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleX).with(scaleY);
        animatorSet.setDuration(animatorTime);
        animatorSet.start();

    }

    public void startActionAnimation(float distance, final ImgCallBack imgCallBack){
//        Log.d("zf",""+distance);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(this, "translationX", 0, distance);
        translationX.setDuration(animatorTime);
        translationX.start();
        translationX.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imgCallBack.ImgIsExceed();
            }
        });
    }

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @SuppressLint({"UseCompatLoadingForDrawables", "DrawAllocation"})
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        if (imgPath!=0){
//            Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(),imgPath);
//            canvas.drawBitmap(bitmap,null,paint);
//        }
//
//    }
}
