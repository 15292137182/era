package base;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 *
 * Created by Administrator on 2017/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-application.xml","classpath:spring/spring-mvc.xml"})
@Ignore // 由于该单元测试不由事务管理器创建，因此也不受事务管理器管理
@WebAppConfiguration
public class BaseTest {


    Logger logger = LoggerFactory.getLogger(getClass());
}
