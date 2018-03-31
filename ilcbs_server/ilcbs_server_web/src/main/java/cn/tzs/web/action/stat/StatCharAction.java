package cn.tzs.web.action.stat;

import cn.tzs.service.StatChartService;
import cn.tzs.web.action.BaseAction;
import com.alibaba.fastjson.JSON;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Namespace("/stat")
@Results({
        @Result(name = "factorySale", location = "/WEB-INF/pages/stat/chart/pieDonut3D.jsp"),
        @Result(name = "productSale", location = "/WEB-INF/pages/stat/chart/column3D.jsp"),
        @Result(name = "onlineInfo", location = "/WEB-INF/pages/stat/chart/linSmooth.jsp")
})
public class StatCharAction extends BaseAction {

    @Autowired
    private StatChartService statChartService;

    // 跳转生产厂家的页面
    @Action(value = "statChartAction_factorysale")
    public String factorySale() {
//        List<Object []> list= statChartService.getFactorysaleData();
//        ArrayList arrayList = new ArrayList();
//        for (Object[] objects : list) {
//            HashMap map = new HashMap();
//            map.put("productNo", objects[0].toString());
//            map.put("amount", objects[1].toString());
//            arrayList.add(map);
//        }
//
//        String json = JSON.toJSONString(arrayList);
//        super.put("myChartData",json);
        return "factorySale";
    }

    //ajax请求封装数据
//    {
//        "country": "United States",
//            "visits": 9252
//    },
//    {
//        "country": "China",
//            "visits": 1882
//    }
    //生产厂家的数据
    @Action(value = "statChartAction_getFactorySaleData")
    public String getFactorySaleData() throws IOException {
        List<Object[]> list = statChartService.getFactorysaleData();

        ArrayList arrayList = new ArrayList();
        for (Object[] objects : list) {
            HashMap map = new HashMap();
            map.put("productNo", objects[0].toString());
            map.put("amount", objects[1].toString());
            arrayList.add(map);
        }
        String json = JSON.toJSONString(arrayList);
        System.out.println(json);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
        return NONE;
    }

    //跳转产品销售排行页面
    @Action(value = "statChartAction_productsale")
    public String productSale() {
        return "productSale";
    }

    //产品销售排行的json数据
    @Action(value = "statChartAction_getProductSaleData")
    public String getProductSaleData() throws IOException {
        List<Object[]> list = statChartService.getProductSaleData();
        ArrayList<String> cpName = new ArrayList<String>();
        ArrayList<Double> cpNumber = new ArrayList<Double>();
        for (Object[] objects : list) {
            cpName.add(objects[0].toString());
            cpNumber.add(Double.parseDouble(objects[1].toString()));
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("cpName", cpName);
        map.put("cpNumber", cpNumber);

        String json = JSON.toJSONString(map);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);

        return NONE;
    }
    //跳转系统访问压力图页面
    @Action(value = "statChartAction_onlineinfo")
    public String onlineInfo() {
        return "onlineInfo";
    }

    //系统访问压力图的json数据
    @Action(value = "statChartAction_getOnlineinfoData")
    public String getOnlineinfoData() throws IOException {
        List<Object[]> list = statChartService.getOnlineinfoData();
        ArrayList<String> time = new ArrayList<String>();
        ArrayList<Double> times = new ArrayList<Double>();
        for (Object [] object : list) {
            time.add(object[0].toString());
            times.add(Double.parseDouble(object[1].toString()));
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("oTime", time);
        map.put("oTimes", times);

        String json = JSON.toJSONString(map);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);

        return NONE;
    }


}
