package bw.com.work13.entity;

import java.util.List;

public class RightBen {

    public String msg;
    public String code;
    public List<DataBean> data;


    public static class DataBean {


        public String cid;
        public String name;
        public String pcid;
        public List<ListBean> list;


        public static class ListBean {

            public String icon;
            public String name;
            public int pcid;
            public int pscid;


        }
    }
}
