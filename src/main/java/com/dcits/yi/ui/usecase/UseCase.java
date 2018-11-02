package com.dcits.yi.ui.usecase;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	//用例名称，必填
	String name();
	//为true时执行该用例方法，否则不执行
	boolean enabled() default true; 
	//执行失败时是否中断整个测试流程
	boolean failInterrupt() default false;
	//标签，在分布式运行时根据标签来进行分组
	String tag() default "default";
	//暂时无用
	int retryCount() default 0;
	//可在此配置一个或者多个浏览器类型，实际测试中，将会按照你配置的顺序依次启动不同类型的浏览器来执行这个测试用例
	String[] browserType() default {};
}
