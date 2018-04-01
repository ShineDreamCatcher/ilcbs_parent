package cn.tzs.web.action.cargo;

import cn.tzs.domain.Contract;
import cn.tzs.domain.ContractProduct;
import cn.tzs.domain.User;
import cn.tzs.service.ContractProductService;
import cn.tzs.service.ContractService;
import cn.tzs.utils.Page;
import cn.tzs.utils.SysConstant;
import cn.tzs.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Namespace("/cargo")
@Results({
        @Result(name = "list", location = "/WEB-INF/pages/cargo/packinglist/jPackingListListPage.jsp"),
        @Result(name = "toView", location = "/WEB-INF/pages/cargo/packinglist/jPackingListView.jsp"),
        @Result(name = "toCreate", location = "/WEB-INF/pages/cargo/packinglist/jPackingListCreate.jsp"),
        @Result(name = "toUpdate", location = "/WEB-INF/pages/cargo/packinglist/jPackingListUpdate.jsp"),
        @Result(name = "toList", location = "packingListAction_list", type = "redirect")
})
public class PackingListAction extends BaseAction {


    /**
     *  装箱管理查看所有页面
     */
    @Action(value = "packingListAction_list")
    public String list() {

        return "list";
    }

    /**
     *  装箱管理查看单个页面
     */
    @Action(value = "packingListAction_toview")
    public String toView() {

        return "toView";
    }

    /**
     *  装箱管理新增页面
     */
    @Action(value = "packingListAction_tocreate")
    public String toCreate() {

        return "toCreate";
    }

    /**
     *  装箱管理修改页面
     */
    @Action(value = "packingListAction_toupdate")
    public String toUpdate() {

        return "toUpdate";
    }

    /**
     *  装箱管理删除页面
     */
    @Action(value = "packingListAction_delete")
    public String delete() {

        return "toList";
    }


}


