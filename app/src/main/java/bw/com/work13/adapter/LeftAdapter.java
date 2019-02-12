package bw.com.work13.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bw.com.work13.R;
import bw.com.work13.entity.LeftBean;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHodler>{
    private Context context;
    private List<LeftBean.DataBean> list;

    public LeftAdapter(Context context, List<LeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.itemxml,viewGroup,false);
        ViewHodler viewHodler = new ViewHodler(inflate);
        return viewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        viewHodler.textView.setText(list.get(i).getName());
        int cid = list.get(i).getCid();
       final LeftBean.DataBean dataBean = list.get(i);

        viewHodler.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cid1 = dataBean.getCid();
                if (callBack!=null){
                    callBack.notify(cid1);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHodler extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.titel);
        }
    }
    private CHCallBack callBack;

    public void setCallBack(CHCallBack callBack) {
        this.callBack = callBack;
    }

    public interface CHCallBack{
        void notify(int cid);
    }
}
