package springaop.jjfactory.member;

import org.springframework.stereotype.Component;
import springaop.jjfactory.member.annotation.ClassAop;
import springaop.jjfactory.member.annotation.MethodAop;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {

    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "ok";
    }

    public String internal(String param){
        return "ok";
    }
}
