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
        @Result(name = "tolist", location = "contractAction_list", type = "redirect")
})
public class PackingListAction extends BaseAction {


    /**
     *
     */
    @Action(value = "packingListAction_list")
    public String list() {

        return "list";
    }



}


