package bw.com.work13.conctct;

import java.util.HashMap;
import java.util.List;

import bw.com.work13.callback.OkhttpCallBack;
import bw.com.work13.callback.RequestCallBack;
import bw.com.work13.entity.LeftBean;
import bw.com.work13.entity.RightBen;

public interface ProduckContact {
    abstract class IProduckPresenter{
        public abstract void LeftList(HashMap<String,String> params);
        public abstract void RightList(HashMap<String,String> params);
    }
    interface IProduckModel{
        void getLeftList(HashMap<String,String> params, OkhttpCallBack okhttpCallBack);
        void getRightList(HashMap<String,String> params,OkhttpCallBack okhttpCallBack);
    }
    interface IProduckView{
        void onleftFile(String msg);
        void onleftSuccess(List<LeftBean.DataBean> list);
        void onFile(String msg);
        void onSuccess(List<RightBen.DataBean> list);
    }
}
