package priv.dengjl.springmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import priv.dengjl.springmybatis.bean.Role;
import priv.dengjl.springmybatis.dao.RoleMapper;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper dao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED, timeout=3)
	public void insertRole(Role role) {
		dao.insertRole(role);
	}
	
}
