package cn.tzs.dao;

import cn.tzs.domain.ContractProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 创建符合spring data jpa规范的dao层接口
 */
public interface ContractProductDao extends JpaRepository<ContractProduct,String>, JpaSpecificationExecutor<ContractProduct> {

}
