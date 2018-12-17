package priv.dengjl.springmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.dengjl.springmybatis.bean.Role;
import priv.dengjl.springmybatis.dao.RoleMapper;

@Service
public class RoleXmlServiceImpl implements RoleXmlService {
	
	@Autowired
	private RoleMapper dao;
	
	// 方法名上没有注解
	@Override
	public void insertRole(Role role) {
		dao.insertRole(role);
	}
	
}
