package baseview.timer_style;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseview.R;


public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    //分割线
    private int dividerHeight;
    private int mOffsetMagin;
    //定制分割线颜色
    private Paint dividerPaint;

    public DividerItemDecoration(Context context) {

        dividerPaint = new Paint();
        dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
        dividerPaint.setColor(context.getResources().getColor(R.color.colorAccent));
        mOffsetMagin = (int) context.getResources().getDimension(R.dimen.divider_margin);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //画item的布局
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float startx = parent.getPaddingLeft()+mOffsetMagin;
            float starty = view.getBottom() + mOffsetMagin;
            float stopx = startx + view.getWidth();
            float stopy = view.getBottom() + mOffsetMagin;
            c.drawLine(startx,starty,stopx,stopy, dividerPaint);
        }
    }
}
