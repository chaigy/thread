package com.cgy.lx;

//threadLocal 为本地线程存储 map
//有点像 局部变量
class Res1{
	//如果是这样的话，就会导致
	//1.线程不安全
	//2.线程共享了改类的变量
	//private Integer count=0;
	
	ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		//初始化初始值
		protected Integer initialValue() {
			return 0;
			
		};
	};
	
	public Integer getCount() {
		int count = tl.get()+1;
		tl.set(count);
		return count;
	}
}

class T extends Thread{
	private Res1 res;
	T(Res1 res){
		this.res=res;
	}
	@Override
	public void run() {
		for(int i=0;i<3;i++) {
			System.out.println(Thread.currentThread().getName()+"："+res.getCount());
		}
	}
}


/**
 * 练习使用threadLocal 解决线程安全问题，但是threadLocal这个有可能会引起内存泄漏
 * 2019年5月7日
 * @author chaigy
 *
 */
public class ThreadLocalDemo {
	
	public static void main(String[] args) {
		Res1 res =new Res1();
		new T(res).start();
		new T(res).start();
		
		
	}
}
