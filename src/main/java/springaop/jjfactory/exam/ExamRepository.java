package springaop.jjfactory.exam;

import org.springframework.stereotype.Repository;
import springaop.jjfactory.exam.annotation.Retry;
import springaop.jjfactory.exam.annotation.Trace;

@Repository
public class ExamRepository {

    private static int seq = 0;

    @Trace
    @Retry
    public String save(String itemId){
        seq++;
        if(seq % 5 == 0){
            throw new IllegalStateException("예외 발생");
        }
        return "ok";
    }
}
