package com.example.tuliao_pro

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import baseview.timer.TimerAdapter
import baseview.timer.TimerEntity
import baseview.timer_style.TimeLineItemDecoration
import com.example.common.sp.SPUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var username by SPUtil<MutableSet<String>>(this, "username", mutableSetOf())

    private val timerEntities: MutableList<TimerEntity> = mutableListOf()
    private var timerAdapter: TimerAdapter? = null
    var flag: Boolean = false
    var layoutManager:LinearLayoutManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        timerview.setOnClickListener {
            val flag1 = timerview.flag
            if (flag1){
                val transx = ObjectAnimator.ofFloat(timerview, "scaleX", 1f)
                val transy = ObjectAnimator.ofFloat(timerview, "scaleY", 1f)
                val animator = AnimatorSet()
                animator.duration = 1000
                animator.play(transx).with(transy)
                animator.start()
                timerview.flag = false
                timer_rec.setVisibility(View.VISIBLE)
                timerAdapter!!.notifyDataSetChanged()
            }
        }

        timerview.recyclerView=timer_rec

        timerEntities.add(
            TimerEntity(
                "2019/12/19",
                "16:30:00",
                R.drawable.ic_baseline_directions_car_24,
                "活动A",
                "已参于（5/10）人",
                "下午3点",
                "西二旗XX餐厅聚餐"
            )
        )
        timerEntities.add(
            TimerEntity(
                "2019/12/19",
                "16:30:00",
                R.drawable.ic_baseline_directions_car_24,
                "活动A",
                "已参于（5/10）人",
                "下午3点",
                "西二旗XX餐厅聚餐"
            )
        )
        timerEntities.add(
            TimerEntity(
                "2019/12/19",
                "16:30:00",
                R.drawable.ic_baseline_directions_car_24,
                "活动A",
                "已参于（5/10）人",
                "下午3点",
                "西二旗XX餐厅聚餐"
            )
        )
        timerEntities.add(
            TimerEntity(
                "2019/12/19",
                "16:30:00",
                R.drawable.ic_baseline_directions_car_24,
                "活动A",
                "已参于（5/10）人",
                "下午3点",
                "西二旗XX餐厅聚餐"
            )
        )
        timerEntities.add(
            TimerEntity(
                "2019/12/19",
                "16:30:00",
                R.drawable.ic_baseline_directions_car_24,
                "活动A",
                "已参于（5/10）人",
                "下午3点",
                "西二旗XX餐厅聚餐"
            )
        )


        timerAdapter = TimerAdapter(R.layout.layout_timershaft, timerEntities)
        layoutManager = LinearLayoutManager(this)
        layoutManager!!.setOrientation(RecyclerView.VERTICAL)
        timer_rec.setAdapter(timerAdapter)
        timer_rec.setLayoutManager(LinearLayoutManager(this))
        timer_rec.setItemAnimator(DefaultItemAnimator())
        //        mRecyclerView.addItemDecoration(new DividerItemDecoration(this)); //item分割线
        timer_rec.addItemDecoration(TimeLineItemDecoration(this)) //time时间轴


    }
}
