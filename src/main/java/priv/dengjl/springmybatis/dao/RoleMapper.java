package priv.dengjl.springmybatis.dao;

import org.springframework.stereotype.Repository;

import priv.dengjl.springmybatis.bean.Role;

@Repository
public interface RoleMapper {
	
	void insertRole(Role role);

	Role selectRole(int id);
}