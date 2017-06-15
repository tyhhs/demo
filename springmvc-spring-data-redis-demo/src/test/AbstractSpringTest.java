/**
 * AbstractSpringTest
 * Author: bjtangyunhao
 * Creation date: 2017年06月14日 20:35
 * Modified by: bjtangyunhao
 * Last modified: 2017年06月14日 20:35
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AbstractSpringTest extends AbstractJUnit4SpringContextTests {

}
