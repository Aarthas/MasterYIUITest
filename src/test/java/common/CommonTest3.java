package common;

//import com.dcits.busi.baidu.usecase.Baidu;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 *
* @version 1.0.0
* @Description 测试启动类
* @author xuwangcheng
* @date 2019年1月11日下午3:32:42
 */
public class CommonTest3 {

	@Test
	public  void a1() throws Exception {
		String a = "asd";
		System.out.println(a);
		System.out.println(a);
	}

	@Test
	public  void a2() throws Exception {
		String a = "asd";
		System.out.println(a);
		System.out.println(a);

	}

	@Test
	public  void a3() throws Exception {
		String a = "asd";
		System.out.println(a);
		System.out.println(a);
		Method[] declaredMethods = this.getClass().getDeclaredMethods();
		for (Method declaredMethod : declaredMethods) {
			System.out.println(declaredMethod.getName());
		}

	}
}
