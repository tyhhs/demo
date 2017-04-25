import com.netease.tyh.springmvcRedisDemo.model.Schedule;
import com.netease.tyh.springmvcRedisDemo.model.User;
import com.netease.tyh.springmvcRedisDemo.service.ScheduleService;
import com.netease.tyh.springmvcRedisDemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by bjtangyunhao on 2017/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              )
public class DemoTest {
    @Resource
    UserService userService;

    @Resource
    ScheduleService scheduleService;

    @Test
    public void testDemo(){
        StopWatch watcher = new StopWatch("timer");
        watcher.start("first time query without cache");
        User user = userService.selectUserByName("bjtangyunhao");
        List<Schedule> schedules1= scheduleService.selectTeamScheduleAfterDate("2016", 54, 6162, "2017-3-13");
        List<Schedule> schedules2 = scheduleService.selectTeamScheduleAfterDate("2016", 54, 6171, "2017-3-13");
        watcher.stop();
        watcher.start("second time query with cache");
        User user1 = userService.selectUserByName("bjtangyunhao");
        List<Schedule> schedules11 = scheduleService.selectTeamScheduleAfterDate("2016", 54, 6162, "2017-3-13");
        List<Schedule> schedules22 = scheduleService.selectTeamScheduleAfterDate("2016", 54, 6171, "2017-3-13");
        watcher.stop();
        System.out.println(watcher.prettyPrint());
    }

    @Test
    public void testEvict(){
        StopWatch watcher = new StopWatch("timer");
        watcher.start("first time query without cache");
        List<Schedule> schedules= scheduleService.selectTeamScheduleAfterDate("2016", 54, 6162, "2017-3-13");
        watcher.stop();
        watcher.start("second time query with cache");
        List<Schedule> schedules_second= scheduleService.selectTeamScheduleAfterDate("2016", 54, 6162, "2017-3-13");
        watcher.stop();

        //clear cache
        scheduleService.flushScheduleCache();

        watcher.start("third time query after evict");
        List<Schedule> schedules_third= scheduleService.selectTeamScheduleAfterDate("2016", 54, 6162, "2017-3-13");
        watcher.stop();
        System.out.println(watcher.prettyPrint());
    }
}
