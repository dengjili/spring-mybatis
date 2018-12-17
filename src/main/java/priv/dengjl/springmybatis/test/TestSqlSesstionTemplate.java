package priv.dengjl.springmybatis.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.dengjl.springmybatis.bean.Role;

public class TestSqlSesstionTemplate {
	
	private static final Logger logger = LoggerFactory.getLogger(TestSqlSesstionTemplate.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybaties.xml");
		SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) context.getBean("sqlSessionTemplate");
		
		Role role = new Role();
		role.setId(10086);
		role.setName("湖南工业");
		role.setDesc("王八犊子");
		sqlSessionTemplate.insert("priv.dengjl.springmybatis.dao.RoleMapper.insertRole", role);
		
		logger.debug(role.getId().toString());
	}

}
