package xin.tianchuang.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.tianchuang.common.annotation.ExceptionLog;
import xin.tianchuang.common.enums.ExceptionTypeEnum;
import xin.tianchuang.modules.spider.entity.SysExceptionLogEntity;
import xin.tianchuang.modules.spider.service.SysExceptionLogService;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by yp-tc-m-7179 on 2018/10/24.
 */
@Aspect
@Component
public class ExceptionLogAspect {
    @Autowired
    private SysExceptionLogService sysExceptionLogService;

    @Pointcut("@annotation(xin.tianchuang.common.annotation.ExceptionLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //执行方法
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            //保存异常日志
            saveExceptionLog(point, throwable);
        }
        return result;
    }

    private void saveExceptionLog(ProceedingJoinPoint joinPoint, Throwable throwable) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysExceptionLogEntity sysExceptionLog = new SysExceptionLogEntity();
        ExceptionLog exceptionLog = method.getAnnotation(ExceptionLog.class);
        if(exceptionLog != null){
            //注解上的描述
            sysExceptionLog.setName(exceptionLog.value());
        }
        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysExceptionLog.setMethod(className + "." + methodName + "()");
        sysExceptionLog.setCreateTime(new Date());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        pw.flush();
        sw.flush();
        String stack = sw.toString();
        sysExceptionLog.setStack(stack);
        sysExceptionLog.setType(ExceptionTypeEnum.SPIDER_EXCEPTION.key());
        sysExceptionLogService.insert(sysExceptionLog);
    }
}
