package core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    protected var mView:View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(bandLayout(),container,false)
        initView()
        initData()
        initEvent()
        return mView
    }

    override fun onResume() {
        super.onResume()
        //存放动画等，每次显示都要调用的
        initbusiness()
    }

    override fun onStart() {
        super.onStart()
        //回收资源等
        recycleData()
    }

    abstract fun recycleData()

    abstract fun initbusiness()

    abstract fun bandLayout(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun initEvent()

    fun findViewById(id:Int):View{
        return mView!!.findViewById(id)
    }
}