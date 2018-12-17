package priv.dengjl.springmybatis.tx;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import priv.dengjl.springmybatis.bean.Role;
import priv.dengjl.springmybatis.test.TestMapperScanner;

public class RunTestTx {

// 编程式事务
private static final Logger logger = LoggerFactory.getLogger(TestMapperScanner.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
		// 事务控制
		DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) context.getBean("transactionManager");
		// 数据库操作句柄
		JdbcTemplate jdbcTemplate = (org.springframework.jdbc.core.JdbcTemplate) context.getBean("jdbcTemplate");
		
		// 开始事务
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus transaction = transactionManager.getTransaction(def);
		
		try {
			String sql = "select * from role where name like concat('%', ?, '%')";
			Object[] objs = {"111"};
			List<Role> resultList = jdbcTemplate.query(sql, objs, (rs, rownum) -> {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				role.setDesc(rs.getString("desc"));
				return role;
			});
			
			if (logger.isDebugEnabled()) {
				logger.debug(resultList.toString());
			}
			
			transactionManager.commit(transaction);
		} catch (Exception ex) {
			transactionManager.rollback(transaction);
		}
	}
}
