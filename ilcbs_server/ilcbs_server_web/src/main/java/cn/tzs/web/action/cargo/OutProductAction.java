package cn.tzs.web.action.cargo;

import cn.tzs.web.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


@Namespace("/cargo")
@Results({
        @Result(name = "toedit", location = "/WEB-INF/pages/cargo/outproduct/jOutProduct.jsp")
})
public class OutProductAction extends BaseAction {
    @Action("outProductAction_toedit")
    public String toedit() {
        return "toedit";
    }
}
