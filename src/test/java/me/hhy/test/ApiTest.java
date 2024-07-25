package me.hhy.test;

import cn.hhy.trigger.api.IRaffleActivityService;
import cn.hhy.trigger.api.dto.ActivityDrawRequestDTO;
import cn.hhy.trigger.api.dto.ActivityDrawResponseDTO;
import cn.hhy.types.model.Response;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Hhy
 * @description 抽奖接口rpc单测
 * @create 2024/7/25
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @DubboReference(interfaceClass = IRaffleActivityService.class, version = "1.0")
    private IRaffleActivityService raffleActivityService;

    @Test
    public void test_rpc() {
        ActivityDrawRequestDTO request = new ActivityDrawRequestDTO();
        request.setActivityId(100301L);
        request.setUserId("hhy");
        Response<ActivityDrawResponseDTO> response = raffleActivityService.draw(request);

        log.info("请求参数：{}", JSON.toJSONString(request));
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

}

