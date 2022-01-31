package springaop.jjfactory.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV4Pointcut {

    @Around("springaop.jjfactory.order.aop.Pointcuts.allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[Log] {}",joinPoint.getSignature());
        return joinPoint.proceed();
    }

    @Around("springaop.jjfactory.order.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
        try {
            log.info("[log] 트랜잭션 시작 {}",joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("[log] 트랜잭션 커밋 {}",joinPoint.getSignature());
            return result;

        } catch (Exception e){
            log.info("[log] 트랜잭션 롤백 {}",joinPoint.getSignature());
            throw e;

        }finally {
            log.info("[log] 리소스 릴리즈 {}",joinPoint.getSignature());
        }
    }
}
