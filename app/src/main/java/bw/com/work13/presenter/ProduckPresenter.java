package bw.com.work13.presenter;

import com.google.gson.Gson;

import java.util.HashMap;

import bw.com.work13.callback.OkhttpCallBack;
import bw.com.work13.callback.RequestCallBack;
import bw.com.work13.conctct.ProduckContact;
import bw.com.work13.entity.LeftBean;
import bw.com.work13.entity.RightBen;
import bw.com.work13.model.ProduckModel;

public class ProduckPresenter extends ProduckContact.IProduckPresenter {
    private ProduckModel produckModel;
    private ProduckContact.IProduckView produckView;

    public ProduckPresenter(ProduckContact.IProduckView produckView) {
        this.produckModel = new ProduckModel();
        this.produckView = produckView;
    }


    @Override
    public void LeftList(HashMap<String, String> params) {
        produckModel.getLeftList(params, new OkhttpCallBack() {
            @Override
            public void onFile(String msg) {
                produckView.onleftFile(msg);
            }

            @Override
            public void onSuccess(String result) {
                LeftBean leftBean = new Gson().fromJson(result, LeftBean.class);

                produckView.onleftSuccess(leftBean.getData());
            }
        });
    }

    @Override
    public void RightList(HashMap<String, String> params) {
        produckModel.getRightList(params, new OkhttpCallBack() {
            @Override
            public void onFile(String msg) {
                produckView.onFile(msg);
            }

            @Override
            public void onSuccess(String result) {
                RightBen rightBen = new Gson().fromJson(result, RightBen.class);

                produckView.onSuccess(rightBen.data);
            }
        });
    }
}
