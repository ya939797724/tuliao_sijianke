package baseview.timer;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.baseview.R;

import java.util.List;

public class TimerAdapter extends BaseQuickAdapter<TimerEntity, BaseViewHolder> {

    public TimerAdapter(int layoutResId, @Nullable List<TimerEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TimerEntity item) {
        helper.setText(R.id.timer_tv_timeyear,item.getTimeyear());
        helper.setText(R.id.timer_tv_timehours,item.getTimehours());
        helper.setText(R.id.timer_tv_activity,item.getActivityname());
        helper.setText(R.id.timer_tv_peoplenum,item.getPeoplenum());
        helper.setText(R.id.timer_tv_timeslot,item.getTimeslot());
        helper.setText(R.id.timer_tv_loc,item.getLoc());
        ImageView imgflag = helper.getView(R.id.timer_img_flag);
        Glide.with(mContext).load(item.getImgflag()).into(imgflag);
    }
}
