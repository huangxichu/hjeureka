package com.hjyd.aspect;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program：hjeureka
 * @description：
 * @author：黄细初
 * @create：2019-06-27 10:33
 */
@Slf4j
//@Aspect
//@Component
//@Order(1000) //执行顺序
public class EurekaServerAspect {


    @Pointcut("execution(public * " +
            "org.springframework.cloud.netflix.eureka.server.EurekaServerAutoConfiguration.peerAwareInstanceRegistry(..))")
    public void instanceAspect(){}

    @Pointcut("execution(public * " +
            "org.springframework.cloud.netflix.eureka.server.InstanceRegistry.register(..))")
    public void registerAspect(){}

    @Pointcut("execution(public * " +
            "org.springframework.cloud.netflix.eureka.server.InstanceRegistry.cancel(..))")
    public void cancelAspect(){}

    @Pointcut("execution(public * " +
            "org.springframework.cloud.netflix.eureka.server.InstanceRegistry.renew(..))")
    public void renewAspect(){}


    @Around("instanceAspect()")
    public Object instance(ProceedingJoinPoint joinPoint)throws Throwable{
        log.info("aspect joinPoint = " + joinPoint);

        //暂时不做修改
        return joinPoint.proceed();
    }

    @Around("registerAspect()")
    public Object register(ProceedingJoinPoint joinPoint)throws Throwable{
        log.info("registerAspect()");
        log.info("aspect joinPoint = " + joinPoint);
        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0){
            InstanceInfo arg0 = (InstanceInfo)args[0];
            log.info("arg0 = " + arg0);
        }
//        if(true){
//            return null;
//        }
        //拦截逻辑
        return joinPoint.proceed();
    }

    @Around("cancelAspect()")
    public Object cancel(ProceedingJoinPoint joinPoint)throws Throwable{
        log.info("cancelAspect()");
        log.info("aspect joinPoint = " + joinPoint);
        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0){
            String appName = (String)args[0];
            String serverId = (String)args[1];
            log.info("appName = " + appName);
            log.info("serverId = " + serverId);
        }
        //拦截逻辑
        return joinPoint.proceed();
    }

    @Around("renewAspect()")
    public Object renew(ProceedingJoinPoint joinPoint)throws Throwable{
        log.info("renewAspect()");
        log.info("aspect joinPoint = " + joinPoint);
        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0){
            String appName = (String)args[0];
            String serverId = (String)args[1];
            log.info("appName = " + appName);
            log.info("serverId = " + serverId);
        }
        //拦截逻辑
        return joinPoint.proceed();
    }

}
