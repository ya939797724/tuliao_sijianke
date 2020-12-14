package baseview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BaseLinearLayout extends LinearLayout {
    private int width;
    private List<BaseImage> list = new ArrayList<>();

    //记录当前点击的子控件对象  以便下次点击让上一次点击的变小
    private BaseImage nowImage;

    private boolean isRightAdd = true;

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

        width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        Log.d("zf","onMeasure");

        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST&&MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST){
            setMeasuredDimension(width,height);
        }else if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST){
            setMeasuredDimension(width,height);
        } else if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width,height);
        }
    }

    public void addItem(Drawable path){
        int width = getWidth();
        int measuredWidth = getMeasuredWidth();
//        Log.d("zf","width->"+width+"      measuredWidth->"+measuredWidth);
        final BaseImage baseImage = new BaseImage(getContext());
        baseImage.setImageDrawable(path);
        baseImage.setPadding(20,20,20,20);
        if (isRightAdd){
            addView(baseImage);
        }else {
            addView(baseImage,0);
        }
        list.add(baseImage);
        baseImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //屏幕中子控件数量
                float size = list.size();
                size = size/2;
                baseImage.startAnimator();
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    BaseImage childAt = (BaseImage) getChildAt(i);
                    if (childAt == baseImage){
                        if (nowImage != null){
                            nowImage.startAnimator();
                        }
                        //点击当前的空间的X
                        float x = list.get(i).getX();
                        //位于正中间的控件的X
//                        float x1 = list.get((int) (size - 0.5)).getX();
                        float x1 = getChildAt((int) (size - 0.5)).getX();
//                        Log.d("zf","x1->"+x1);
                        //点击中间靠右
                        if (i>size-0.5){
                            startActionAnimation(x1-x);
                        }
                        //点击中间靠左
                        else if (i<size-0.5){
                            startActionAnimation(x1-x);
                        }
                        //点击正中间
                        else {

                        }
                        nowImage = childAt;
                        break;
                    }
                }
            }
        });
    }

    boolean isRightExceed;
    boolean isLeftExceed;

    private void startActionAnimation(float v) {
        for (int i = 0; i < list.size();i++) {
            final BaseImage baseImage = list.get(i);
            isRightExceed = false;
            isLeftExceed = false;
            if (v>0){
                if ((baseImage.getX()+baseImage.getWidth())+v>getWidth()){
                    Log.d("zf","右移超出");
                    isRightExceed = true;
                    isRightAdd = false;
//                    addItem(baseImage.getDrawable());
                }
            }else {
                if (baseImage.getX()-v<getWidth()){
                    Log.d("zf","左移超出");
                    isRightAdd = true;
                    isLeftExceed = true;
//                    addItem(baseImage.getDrawable());
                }
            }

            baseImage.startActionAnimation(v, new ImgCallBack() {
                @Override
                public void ImgIsExceed() {
                    if (isRightExceed){
                        if (baseImage.getX()+baseImage.getWidth()>getWidth()){
//                            removeView(baseImage);
//                            list.remove(baseImage);
                        }
                    }
                    if (isLeftExceed){
                        if (baseImage.getX()<0){
//                            removeView(baseImage);
//                            list.remove(baseImage);
                        }
                    }
                }
            });
        }
    }
}
