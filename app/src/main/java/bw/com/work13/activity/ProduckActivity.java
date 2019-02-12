package bw.com.work13.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import bw.com.work13.R;
import bw.com.work13.adapter.LeftAdapter;
import bw.com.work13.adapter.RightAdapter;
import bw.com.work13.api.ProduckApi;
import bw.com.work13.callback.OkhttpCallBack;
import bw.com.work13.conctct.ProduckContact;
import bw.com.work13.entity.LeftBean;
import bw.com.work13.entity.RightBen;
import bw.com.work13.okhttpWork.OkhttpWork;
import bw.com.work13.presenter.ProduckPresenter;

public class ProduckActivity extends AppCompatActivity implements ProduckContact.IProduckView ,LeftAdapter.CHCallBack{

    private RecyclerView leftrlv;
    private RecyclerView rightrlv;
    private RecyclerView rightrlv1;
    private ProduckPresenter produckPresenter;
    private HashMap<String, String> params;
    private LeftAdapter leftAdapter;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produck);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        leftrlv = findViewById(R.id.leftrlv);
        rightrlv1 = findViewById(R.id.rightrlv);
        produckPresenter = new ProduckPresenter(this);
        params = new HashMap<>();
        Button js = findViewById(R.id.js);
        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProduckActivity.this,JiaoHuActivity.class);
                startActivity(intent);
            }
        });
        produckPresenter.LeftList(new HashMap<String, String>());
           produckPresenter.RightList(params);
      //  initProduck();
    }



    @Override
    public void onleftFile(String msg) {

    }

    @Override
    public void onleftSuccess(List<LeftBean.DataBean> list) {

        leftAdapter = new LeftAdapter(this,list);
        leftAdapter.setCallBack(this);
        leftrlv.setLayoutManager(new LinearLayoutManager(this));
        leftrlv.setAdapter(leftAdapter);
    }

    @Override
    public void onFile(String msg) {

    }

    @Override
    public void onSuccess(List<RightBen.DataBean> list) {
    //    Toast.makeText(this,list.size()+"",Toast.LENGTH_SHORT).show();
        RightAdapter rightAdapter = new RightAdapter(this,list);
        rightrlv1.setLayoutManager(new LinearLayoutManager(this));
        rightrlv1.setAdapter(rightAdapter);
    }


    private void initProduck() {
        OkhttpWork.getIntercten().doGet(ProduckApi.ProduckApi, params, new OkhttpCallBack() {
            @Override
            public void onFile(String msg) {

            }

            @Override
            public void onSuccess(String result) {
                LeftBean leftBean = new Gson().fromJson(result, LeftBean.class);
                List<LeftBean.DataBean> data = leftBean.getData();
                Toast.makeText(ProduckActivity.this,data.size()+"",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void notify(int cid) {
        id = cid;
        HashMap<String,String> param = new HashMap<>();
        param.put("cid",cid+"");
        produckPresenter.RightList(params);
        leftAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkhttpWork.getIntercten().onBind();
    }
}
