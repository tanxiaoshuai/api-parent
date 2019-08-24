package cn.nmmpa.common.exception;

import cn.nmmpa.common.response.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Mister Tan
 * 统一返回模板
 */

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {


    /**
     * 基础层自定义异常统一拦截
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ProviderServiceException.class)
    public ResultEntity basicServiceExceptionHandler(ProviderServiceException exception){
        exception.printStackTrace();
        return new ResultEntity(exception.getCode() == 0 ? 500 : exception.getCode() , exception.getMessage());
    }

    /**
     * 业务层自定义异常统一拦截
     * @param exception
     * @return
     */
    @ExceptionHandler(value = ConsumerServiceException.class)
    public ResultEntity businessServiceExceptionHandler(ConsumerServiceException exception){
        exception.printStackTrace();
        return new ResultEntity<>(exception.getCode() == 0 ? 500 : exception.getCode() , exception.getMessage());
    }

    /**
     * 全局统一拦截exception异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultEntity exceptionHandler(Exception e){
        e.printStackTrace();
        System.out.println(e.getMessage());
        return new ResultEntity<>(500 , e.getMessage()+"");
    }
}

