package priv.dengjl.springmybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import priv.dengjl.springmybatis.bean.Role;

@Service
public class RoleListServiceImpl implements RoleListService {
	
	@Autowired
	private RoleService roleService;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=3)
	public void insertRole(List<Role> roles) {
		for (Role role : roles) {
			roleService.insertRole(role);
		}
	}
	
}
