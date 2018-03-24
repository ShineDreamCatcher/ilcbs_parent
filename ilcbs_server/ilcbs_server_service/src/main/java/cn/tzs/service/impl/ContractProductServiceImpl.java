package cn.tzs.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.tzs.dao.ContractDao;
import cn.tzs.dao.ContractProductDao;
import cn.tzs.domain.Contract;
import cn.tzs.domain.ContractProduct;
import cn.tzs.service.ContractProductService;
import cn.tzs.utils.UtilFuns;

@Service
public class ContractProductServiceImpl implements ContractProductService {

	@Autowired
	private ContractProductDao contractProductDao;

	@Autowired
	private ContractDao contractDao;
	
	public ContractProduct findOne(String id) {//根据id查询
		return contractProductDao.findOne(id);
	}

	public void saveOrUpdate(ContractProduct contractProduct) {//保存或更新
		if(UtilFuns.isEmpty(contractProduct.getId())){  //判断是否新增，根据对象id
			
		}else{
			
		}
		
		contractProductDao.save(contractProduct);
	}

	public void saveOrUpdateAll(Collection<ContractProduct> entitys) {//批量保存或更新
		for (ContractProduct contractProduct : entitys) {
			contractProductDao.save(contractProduct);
		}
	}

	public void deleteById(String id) {//根据id删除
		contractProductDao.delete(id);
	}

	public void delete(String[] ids) {//批量删除
		for (String id : ids) {
			contractProductDao.delete(id);
		}
	}

	//根据条件查询所有
	public List<ContractProduct> find(Specification<ContractProduct> spec) {
		return contractProductDao.findAll(spec);
	}

	//分页查询
	public Page<ContractProduct> findPage(Specification<ContractProduct> spec, Pageable pageable) {
		return contractProductDao.findAll(spec, pageable);
	}

}
