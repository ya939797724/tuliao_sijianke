package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuliao_pro.R;

import java.util.List;

import callback.LetterClickCallBack;

public class LetterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> list;
    private LetterClickCallBack callBack;

    public LetterAdapter(List<String> list, LetterClickCallBack callBack) {
        this.list = list;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.letter_item_vertical_layout, parent, false);
        return new BaseViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder)holder).textView.setText(list.get(position));
        ((BaseViewHolder)holder).textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClick(position,((BaseViewHolder)holder).textView.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.letter_item_vertical_text);
        }
    }

    /**
     * 此适配器
     * letterAdapter = new LetterAdapter(strings, new LetterClickCallBack() {
     *             @Override
     *             public void onClick(int position, String s) {
     *             //list是联系人数据源
     *                 for (int i = 0; i < list.size(); i++) {
     *                     String string = list.get(i).getName();
     *                     Log.d("zf","遍历"+string);
     *                     if (string.equals(s)){
     *                         Log.d("zf","查询成功");
     *                         //左侧联系人列表
     *                         rv.scrollToPosition(i);
     *                         break;
     *                     }
     *                 }
     *             }
     *         });
     */
}
