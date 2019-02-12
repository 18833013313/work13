package bw.com.work13.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bw.com.work13.R;
import bw.com.work13.entity.LeftBean;
import bw.com.work13.entity.RightBen;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHodler>{
    private Context context;
    private List<RightBen.DataBean> list;

    public RightAdapter(Context context, List<RightBen.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.right,viewGroup,false);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        viewHodler.textView.setText(list.get(i).name);
      //  viewHodler.recyclerView.setLayoutManager(new GridLayoutManager(context,GridLayoutManager.DEFAULT_SPAN_COUNT,3,false));
        viewHodler.recyclerView.setLayoutManager(new GridLayoutManager(context,3,GridLayoutManager.HORIZONTAL,false));
        RightitemAdapter rightitemAdapter = new RightitemAdapter(context,list.get(i).list);

        viewHodler.recyclerView.setAdapter(rightitemAdapter);

    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.titel);
            recyclerView = itemView.findViewById(R.id.right_rlv);
        }
    }

}
