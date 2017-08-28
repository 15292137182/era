package base;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 *
 * Created by Administrator on 2017/8/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-application.xml","classpath:spring/spring-mvc.xml"})
@Ignore
@WebAppConfiguration
public class BaseTest {


//    Logger logger = LoggerFactory.getLogger(getClass());
}
