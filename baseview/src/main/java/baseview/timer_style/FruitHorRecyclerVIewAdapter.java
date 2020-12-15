package baseview.timer_style;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.baseview.R;
import java.util.List;

public class FruitHorRecyclerVIewAdapter extends RecyclerView.Adapter<FruitHorRecyclerVIewAdapter.MyViewHolder> {
    private List<Fruit> fruitList;

    public FruitHorRecyclerVIewAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.case7_item_fruit, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Fruit horItem = fruitList.get(position);
        holder.fruitHorImage.setImageResource(horItem.getImageId());
        holder.fruitHorName.setText(horItem.getName());
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positon = holder.getAdapterPosition();
                Fruit fruit = fruitList.get(positon);
                Toast.makeText(v.getContext(), "hor：" + "你点击了" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        View fruitView;

        //图片
        public ImageView fruitHorImage;
        //标题
        public TextView fruitHorName;

        public MyViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitHorImage = itemView.findViewById(R.id.fruit_image);
            fruitHorName = itemView.findViewById(R.id.fruit_name);
        }
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
