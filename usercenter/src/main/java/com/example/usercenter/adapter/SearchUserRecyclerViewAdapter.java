package com.example.usercenter.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.common.picture.MPictureUtil;
import com.example.usercenter.R;
import com.example.usercenter.model.api.bean.UserInfoBean;

import java.util.List;

public class SearchUserRecyclerViewAdapter extends BaseQuickAdapter<UserInfoBean, BaseViewHolder> {
    public SearchUserRecyclerViewAdapter(int layoutResId, @Nullable List<UserInfoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserInfoBean item) {
        helper.setText(R.id.tv_user_name, item.getPhonenumber());
        if (item.getHeadimg() != null) {
            MPictureUtil.getInstance().circletImage(mContext, item.getHeadimg(), ((ImageView) helper.getView(R.id.iv_user_header)));
        }

        helper.addOnClickListener(R.id.tv_add_user);
    }
}
