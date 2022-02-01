package springaop.jjfactory.exam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springaop.jjfactory.exam.annotation.Retry;
import springaop.jjfactory.exam.annotation.Trace;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    @Trace
    @Retry
    public void request(String itemId){
        examRepository.save(itemId);
    }
}
