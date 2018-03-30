package cn.tzs.dao;

import cn.tzs.domain.Contract;
import cn.tzs.domain.ContractProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 创建符合spring data jpa规范的dao层接口
 */
public interface StatChartDao extends JpaRepository<ContractProduct,String>, JpaSpecificationExecutor<ContractProduct> {

    @Query(value = "select factory_name,sum(amount) from CONTRACT_PRODUCT_C group by factory_name",nativeQuery = true)
    List getFactorysaleData();
}
