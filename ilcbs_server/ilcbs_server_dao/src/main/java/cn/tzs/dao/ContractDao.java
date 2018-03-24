package cn.tzs.dao;

import cn.tzs.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 创建符合spring data jpa规范的dao层接口
 */
public interface ContractDao extends JpaRepository<Contract,String>, JpaSpecificationExecutor<Contract> {

}
