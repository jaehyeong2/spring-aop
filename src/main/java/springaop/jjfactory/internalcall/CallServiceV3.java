package springaop.jjfactory.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV3 {

    private final InternalService internalServicel;

    public CallServiceV3(InternalService internalServicel) {
        this.internalServicel = internalServicel;
    }

    public void external(){
        log.info("call external");
        internalServicel.internal();
    }


}
