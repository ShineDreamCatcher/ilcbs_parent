package cn.tzs.web.action.cargo;

import cn.tzs.domain.Contract;
import cn.tzs.service.ContractService;
import cn.tzs.utils.Page;
import cn.tzs.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
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
import java.util.List;

@Namespace("/cargo")
@Results({
        @Result(name = "list", location = "/WEB-INF/pages/cargo/contract/jContractList.jsp"),
        @Result(name = "toview", location = "/WEB-INF/pages/cargo/contract/jContractView.jsp"),
        @Result(name = "tocreate", location = "/WEB-INF/pages/cargo/contract/jContractCreate.jsp"),
        @Result(name = "toupdate", location = "/WEB-INF/pages/cargo/contract/jContractUpdate.jsp"),
        @Result(name = "tolist", location = "contractAction_list", type = "redirect")
})
public class ContractAction extends BaseAction implements ModelDriven<Contract> {

    @Autowired
    private ContractService contractService;
    //模型驱动
    private Contract model = new Contract();
    //属性驱动
    private Page page = new Page();

    /**
     * 查看购销合同列表页面
     */
    @Action(value = "contractAction_list")
    public String list() {

        Pageable pageable = new PageRequest(page.getPageNo() - 1, page.getPageSize());
        org.springframework.data.domain.Page<Contract> jpaPage = contractService.findPage(null, pageable);

        page.setTotalPage(jpaPage.getTotalPages());
        page.setTotalRecord(jpaPage.getTotalElements());
        page.setResults(jpaPage.getContent());
        //设置url
        page.setUrl("contractAction_list");
        super.push(page);
        return "list";
    }

    /**
     * 查看单个购销合同页面
     */
    @Action(value = "contractAction_toview")
    public String toview() {
        Contract contract = contractService.findOne(model.getId());
        super.push(contract);
        return "toview";
    }

    /**
     * 跳转新建购销合同页面
     */
    @Action(value = "contractAction_tocreate")
    public String tocreate() {
        return "tocreate";
    }

    //保存新建购销合同的操作
    @Action(value = "contractAction_insert")
    public String insert() {
        contractService.saveOrUpdate(model);
        return "tolist";
    }

    /**
     * 跳转修改购销合同页面
     */
    @Action(value = "contractAction_toupdate")
    public String toupdate() {
        Contract contract = contractService.findOne(model.getId());
        super.push(contract);
        return "toupdate";
    }

    //执行修改操作
    @Action(value = "contractAction_update")
    public String update() {
        Contract contract = contractService.findOne(model.getId());
        contract.setCustomName(model.getCustomName());
        contract.setPrintStyle(model.getPrintStyle());
        contract.setContractNo(model.getContractNo());
        contract.setOfferor(model.getOfferor());
        contract.setCheckBy(model.getCheckBy());
        contract.setInputBy(model.getInputBy());
        contract.setInspector(model.getInspector());
        contract.setSigningDate(model.getSigningDate());
        contract.setImportNum(model.getImportNum());
        contract.setShipTime(model.getShipTime());
        contract.setTradeTerms(model.getTradeTerms());
        contract.setDeliveryPeriod(model.getDeliveryPeriod());
        contract.setCrequest(model.getCrequest());
        contract.setRemark(model.getRemark());

        contractService.saveOrUpdate(contract);
        return "tolist";
    }

    /**
     * 删除购销合同操作
     */
    @Action(value = "contractAction_delete")
    public String delete() {
        contractService.delete(model.getId().split(", "));
        return "tolist";
    }

    /**
     * 提交购销合同 审核通过操作
     */
    @Action(value = "contractAction_submit")
    public String submit() {
        String[] ids = model.getId().split(", ");
        for (String id : ids) {
            Contract contract = contractService.findOne(id);
            contract.setState(1);
            contractService.saveOrUpdate(contract);
        }
        return "tolist";
    }

    /**
     * 提交购销合同 审核暂停操作
     */
    @Action(value = "contractAction_cancel")
    public String cancel() {
        String[] ids = model.getId().split(", ");
        for (String id : ids) {
            Contract contract = contractService.findOne(id);
            contract.setState(0);
            contractService.saveOrUpdate(contract);
        }
        return "tolist";
    }


    ////////////////////////////get、and、set///////////////////////////////
    @Override
    public Contract getModel() {
        return model;
    }

    public void setModel(Contract model) {
        this.model = model;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}


