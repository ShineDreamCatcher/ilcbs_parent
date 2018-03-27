package cn.tzs.web.action.cargo;


import cn.tzs.domain.Contract;
import cn.tzs.domain.Export;
import cn.tzs.exceotion.SysException;
import cn.tzs.service.ContractService;
import cn.tzs.service.ExportService;
import cn.tzs.utils.Page;
import cn.tzs.web.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Namespace("/cargo")
@Results({
        @Result(name = "contractList", location = "/WEB-INF/pages/cargo/export/jContractList.jsp"),
        //@Result(name = "toview", location = "/WEB-INF/pages/cargo/export/jContractList.jsp"),
        //@Result(name = "print", location = "/WEB-INF/pages/cargo/export/jContractList.jsp"),
        @Result(name = "tocreate", location = "/WEB-INF/pages/cargo/export/jExportCreate.jsp"),
        @Result(name = "list", location = "/WEB-INF/pages/cargo/export/jExportList.jsp"),
        @Result(name = "tolist", location = "exportAction_list",type = "redirect")
})
public class ExportAction extends BaseAction implements ModelDriven<Export> {

    @Autowired
    private ExportService exportService;
    @Autowired
    private ContractService contractService;
    private Export modle = new Export();
    private Page page = new Page();

    @Action("exportAction_contractList")
    public String contractList() {
        //查询所有购销合同状态为 1 的数据
        org.springframework.data.domain.Page<Contract> jpaPage = contractService.findPage(new Specification<Contract>() {
            @Override
            public Predicate toPredicate(Root<Contract> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("state").as(Integer.class), "1");
            }
        }, new PageRequest(page.getPageNo() - 1, page.getPageSize()));

        page.setTotalPage(jpaPage.getTotalPages());
        page.setTotalRecord(jpaPage.getTotalElements());
        page.setResults(jpaPage.getContent());
        page.setUrl("exportAction_contractList");

        super.push(page);
        return "contractList";
    }

    @Action("contractAction_toview")
    public String toview() throws SysException {
        throw new SysException("还没有这个功能哦");
//        return "toview";
    }

    @Action("contractAction_print")
    public String print() throws SysException {
        throw new SysException("还没有这个功能哦");
//        return "print";
    }

    @Action("exportAction_tocreate")
    public String tocreate() {
        return "tocreate";
    }

    @Action("exportAction_insert")
    public String insert() {
        exportService.saveOrUpdate(modle);
        return "tolist";
    }

    @Action("exportAction_list")
    public String list() {
        org.springframework.data.domain.Page<Export> jpaPage = exportService.findPage(
                null, new PageRequest(page.getPageNo() - 1, page.getPageSize()));

        page.setTotalPage(jpaPage.getTotalPages());
        page.setTotalRecord(jpaPage.getTotalElements());
        page.setResults(jpaPage.getContent());
        page.setUrl("exportAction_list");

        super.push(page);
        return "list";
    }


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Export getModel() {
        return modle;
    }

    public void setModle(Export modle) {
        this.modle = modle;
    }
}
