//package cn.tzs.service.impl;
//
//import cn.tzs.dao.PackingListDao;
//import cn.tzs.domain.PackingList;
//import cn.tzs.service.PackingListService;
//import cn.tzs.utils.UtilFuns;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//
//
//@Service
//public class PackingListServiceImpl implements PackingListService {
//	//spring注入dao
//	@Autowired
//	private PackingListDao packingListDao;
//
//	public PackingList findOne(String id) {
//		return packingListDao.findOne(id);
//	}
//
//	public List<PackingList> find(Specification<PackingList> spec) {
//		return packingListDao.findAll(spec);
//	}
//
//	public Page<PackingList> findPage(Specification<PackingList> spec, Pageable pageable) {
//		return packingListDao.findAll(spec, pageable);
//	}
//
//	public void saveOrUpdate(PackingList entity) {
//		if(UtilFuns.isEmpty(entity.getId())){
//			//新增
//			entity.setState(1);
//		}
//		packingListDao.save(entity);
//	}
//
//	public void saveOrUpdateAll(Collection<PackingList> entitys) {
//		for (PackingList obj : entitys) {
//			saveOrUpdate(obj);
//		}
//	}
//
//	public void deleteById(String id) {
//		packingListDao.delete(id);
//	}
//
//	public void delete(String[] ids) {
//		for (String id : ids) {
//			deleteById(id);
//		}
//	}
//
//}
