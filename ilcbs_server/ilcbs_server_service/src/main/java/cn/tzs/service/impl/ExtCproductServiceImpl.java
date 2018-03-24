package cn.tzs.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.tzs.dao.ExtCproductDao;
import cn.tzs.domain.ExtCproduct;
import cn.tzs.service.ExtCproductService;
import cn.tzs.utils.UtilFuns;

@Service
public class ExtCproductServiceImpl implements ExtCproductService {

	@Autowired
	private ExtCproductDao extCproductDao;
	
	public ExtCproduct findOne(String id) {//根据id查询
		return extCproductDao.findOne(id);
	}

	public void saveOrUpdate(ExtCproduct extCproduct) {//保存或更新
		if(UtilFuns.isEmpty(extCproduct.getId())){  //判断是否新增，根据对象id
			
		}else{
			
		}
		extCproductDao.save(extCproduct);
	}

	public void saveOrUpdateAll(Collection<ExtCproduct> entitys) {//批量保存或更新
		for (ExtCproduct extCproduct : entitys) {
			extCproductDao.save(extCproduct);
		}
	}

	public void deleteById(String id) {//根据id删除
		extCproductDao.delete(id);
	}

	public void delete(String[] ids) {//批量删除
		for (String id : ids) {
			extCproductDao.delete(id);
		}
	}

	//根据条件查询所有
	public List<ExtCproduct> find(Specification<ExtCproduct> spec) {
		return extCproductDao.findAll(spec);
	}

	//分页查询
	public Page<ExtCproduct> findPage(Specification<ExtCproduct> spec, Pageable pageable) {
		return extCproductDao.findAll(spec, pageable);
	}

}
