package springaop.jjfactory.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* springaop.jjfactory.order..*(..))")
    public void allOrder(){}

    @Pointcut("execution(* *..*Service..*(..))")
    public void allService(){}

    @Pointcut("allOrder() && allService()")
    public void orderAndService(){}
}
