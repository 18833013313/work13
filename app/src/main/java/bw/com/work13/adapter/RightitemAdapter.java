package bw.com.work13.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bw.com.work13.R;
import bw.com.work13.entity.RightBen;

public class RightitemAdapter extends RecyclerView.Adapter<RightitemAdapter.ViewHodler>{
    private Context context;
    private List<RightBen.DataBean.ListBean> list;

    public RightitemAdapter(Context context, List<RightBen.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.right_pro,viewGroup,false);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        viewHodler.textView.setText(list.get(i).name);
        Glide.with(context).load(list.get(i).icon).into(viewHodler.imageView);
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.right_name);
            imageView = itemView.findViewById(R.id.right_image);
        }
    }
}
