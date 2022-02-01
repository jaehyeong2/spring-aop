package springaop.jjfactory.proxyvs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import springaop.jjfactory.member.MemberService;
import springaop.jjfactory.member.MemberServiceImpl;

@Slf4j
public class ProxyCastingTest {

    @Test
    void jdkProxy(){
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false);  //jdk동적 프록시가 된다

        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        //JDK 동적 프록시를 구현 클래스로 캐스팅할 수 없다.
        MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
    }

    @Test
    void cglibProxy(){
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);  //cglib 프록시가 된다

        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        //JDK 동적 프록시를 구현 클래스로 캐스팅할 수 있따.
        MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
    }
}
