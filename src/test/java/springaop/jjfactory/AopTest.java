package springaop.jjfactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springaop.jjfactory.order.OrderRepository;
import springaop.jjfactory.order.OrderService;
import springaop.jjfactory.order.aop.AspectV1;
import springaop.jjfactory.order.aop.AspectV2;

@Slf4j
@SpringBootApplication
//@Import(AspectV1.class)
@Import(AspectV2.class)
public class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void aopInfo(){
        log.info("isAopProxy, orderService = {}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy, orderRepository = {}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    void success(){
        orderService.orderItem("itemA");
    }
}
