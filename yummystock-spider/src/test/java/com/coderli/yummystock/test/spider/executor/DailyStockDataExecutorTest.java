package com.coderli.yummystock.test.spider.executor;

import com.coderli.yummystock.test.spider.SpiderTestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

/**
 * @author li.hzh
 * @date 2017-07-27 22:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExecutorTestConfig.class)
public class DailyStockDataExecutorTest {

    @Test
    public void testExecutor() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

}
