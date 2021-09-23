package com.henry.aop;

import com.henry.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 设置路由key
 * 默认情况下，所有的查询都走从库，插入/修改/删除走主库。我们通过方法名来区分操作类型（CRUD）
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.henry.annotation.Master) " +
            "&& (execution(* com.henry.service..*.select*(..)) " +
            "|| execution(* com.henry.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.henry.annotation.Master) " +
            "|| execution(* com.henry.service..*.insert*(..)) " +
            "|| execution(* com.henry.service..*.add*(..)) " +
            "|| execution(* com.henry.service..*.update*(..)) " +
            "|| execution(* com.henry.service..*.edit*(..)) " +
            "|| execution(* com.henry.service..*.delete*(..)) " +
            "|| execution(* com.henry.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else... 判断哪些需要读从数据库，其余的走主数据库
     */
// @Before("execution(* com.cjs.example.service.impl.*.*(..))")
// public void before(JoinPoint jp) {
// String methodName = jp.getSignature().getName();
//
// if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
// DBContextHolder.slave();
// }else {
// DBContextHolder.master();
// }
// }
}
