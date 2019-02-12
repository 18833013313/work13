package bw.com.work13.model;

import java.util.HashMap;

import bw.com.work13.api.ProduckApi;
import bw.com.work13.callback.OkhttpCallBack;

import bw.com.work13.conctct.ProduckContact;
import bw.com.work13.okhttpWork.OkhttpWork;

public class ProduckModel implements ProduckContact.IProduckModel{




    @Override
    public void getLeftList(HashMap<String, String> params, OkhttpCallBack okhttpCallBack) {
        OkhttpWork.getIntercten().doGet(ProduckApi.ProduckApi,params,okhttpCallBack);
    }

    @Override
    public void getRightList(HashMap<String, String> params, OkhttpCallBack okhttpCallBack) {
        OkhttpWork.getIntercten().doGet(ProduckApi.ProduckItemApi,params,okhttpCallBack);
    }
}
