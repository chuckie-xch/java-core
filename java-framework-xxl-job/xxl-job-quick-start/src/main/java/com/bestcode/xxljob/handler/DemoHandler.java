package com.bestcode.xxljob.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.06.02
 */
@JobHandler("demoHandler")
@Component
public class DemoHandler extends IJobHandler{

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("-----execute demoHandler start----");
        XxlJobLogger.log("param : " + param);
        for (int i = 0; i < 5; i++) {
            XxlJobLogger.log("beat at : " + i);
            TimeUnit.SECONDS.sleep(1);
        }
        return SUCCESS;
    }
}
