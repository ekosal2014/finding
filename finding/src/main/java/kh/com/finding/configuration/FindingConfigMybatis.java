package kh.com.finding.configuration;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan( value = "kh.com.finding.mappers" )
public class FindingConfigMybatis {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
		
		SqlSessionFactoryBean session = new SqlSessionFactoryBean();
		session.setMapperLocations(applicationContext.getResources("classpath:META-INF/mybatis/mappers/**/*.xml"));
		session.setDataSource(dataSource);
		
		
		SqlSessionFactory sessionFactory = session.getObject();
        //sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        
		return session;
	}

}
