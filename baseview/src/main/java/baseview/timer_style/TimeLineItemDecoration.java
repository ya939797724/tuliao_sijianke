package baseview.timer_style;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseview.R;

public class TimeLineItemDecoration extends RecyclerView.ItemDecoration {
    //画布
    private Paint mPaint;

    //outRect的四个参数————itemView的间距
    private float mOffsetLeft;
    private float mOffsetRight;
    private float mOffsetTop;
    private float mOffsetBottom;

    //时间轴结点的半径
    private float mNodeRadius;

    public TimeLineItemDecoration(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);  //抗锯齿
        mPaint.setColor(Color.parseColor("#B9C5BA"));
        //outRect
        mOffsetLeft = context.getResources().getDimension(R.dimen.timeline_item_offset_left);
        mOffsetRight = context.getResources().getDimension(R.dimen.timeline_item_offset_right);
        mOffsetTop = context.getResources().getDimension(R.dimen.timeline_item_offset_top);
        mOffsetBottom = context.getResources().getDimension(R.dimen.timeline_item_offset_bottom);
        //圆圈
        mNodeRadius = context.getResources().getDimension(R.dimen.timeline_item_node_radius);

    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();

        for ( int i = 0; i < childCount; i++ ) {
            View view = parent.getChildAt(i);

            float dividerTop = view.getTop() - mOffsetTop;
            float dividerLeft = parent.getPaddingLeft();
            float dividerBottom = view.getBottom()+mOffsetBottom;

            float centerX = dividerLeft + mOffsetLeft / 2;
            float centerY = dividerTop + (dividerBottom - dividerTop) / 2;

            float upLineTopX = centerX;
            float upLineTopY = dividerTop;
            float upLineBottomX = centerX;
            float upLineBottomY = centerY - mNodeRadius;

            //绘制上半部轴线
            c.drawLine(upLineTopX,upLineTopY,upLineBottomX,upLineBottomY,mPaint);

            float downLineTopX = centerX;
            float downLineTopY = centerY + mNodeRadius;
            float downLineBottomX = centerX;
            float downLineBottomY = dividerBottom;

            //绘制上半部轴线
            c.drawLine(downLineTopX,downLineTopY,downLineBottomX,downLineBottomY,mPaint);


            //绘制时间轴结点
            // 结点（实心）
//            c.drawCircle(centerX,centerY,mNodeRadius,mPaint);
            // 结点（空心）
            mPaint.setStyle(Paint.Style.STROKE);
            c.drawCircle(centerX,centerY,mNodeRadius,mPaint);
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //设置outRect的四个参数
        outRect.left = (int) mOffsetLeft;
        outRect.right = (int) mOffsetRight;
        outRect.top = (int) mOffsetTop;
        outRect.bottom = (int) mOffsetBottom;
    }
}
