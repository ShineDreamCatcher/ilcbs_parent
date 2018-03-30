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
        @Result(name = "factorySale", location = "/WEB-INF/pages/stat/chart/pieDonut3D.jsp")
})
public class StatCharAction extends BaseAction {

    @Autowired
    private StatChartService statChartService;

    //条状统计页面
    @Action(value = "statChartAction_factorysale")
    public String factorySale() {
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
    @Action(value = "statChartAction_getFactorySaleData")
    public String getFactorySaleData() throws IOException {
        List list= statChartService.getFactorysaleData();

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("productNo", list.get(i++));
            map.put("amount", Double.parseDouble(list.get(i).toString()));
            arrayList.add(map);
        }

        String json = JSON.toJSONString(arrayList);
        System.out.println(json);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);

        return NONE;
    }
}
