package cn.tzs.web.action.cargo;


import cn.tzs.domain.Contract;
import cn.tzs.service.ContractService;
import cn.tzs.utils.Page;
import cn.tzs.web.action.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@Namespace("/cargo")
@Results({
        @Result(name = "list", location = "/WEB-INF/pages/cargo/export/jContractList.jsp"),
        @Result(name = "alist", location = "/WEB-INF/pages/cargo/export/jContractList.jsp")
})
public class ExportAction extends BaseAction {

    @Autowired
    private ContractService contractService;
    private Page page = new Page();


    @Action("exportAction_list")
    public String list() {
        org.springframework.data.domain.Page<Contract> jpaPage = contractService.findPage(
                null, new PageRequest(page.getPageNo() - 1, page.getPageSize()));

        page.setTotalPage(jpaPage.getTotalPages());
        page.setTotalRecord(jpaPage.getTotalElements());
        page.setResults(jpaPage.getContent());
        page.setUrl("exportAction_list");

        super.push(page);
        return "list";
    }


    @Action("contractAction_toview")
    public String toview() {
        return "toview";
    }

    @Action("contractAction_print")
    public String print() {
        return "print";
    }

    @Action("exportAction_tocreate")
    public String tocreate() {
        return "print";
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
