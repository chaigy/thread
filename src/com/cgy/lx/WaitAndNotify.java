package com.cgy.lx;


/**
 * 上线一个功能，使一个线程不断写入数据，一个线程不断的读取数据
 * 2019年5月7日
 * @author chaigy
 *
 */

class Res{
	
	public String name;
	public String sex;
	//flag 为false的时候 可写不可读   为true的时候，可读不可写
	public boolean flag=false;
}
/**
 * 读线程
 * 2019年5月7日
 * @author chaigy
 *
 */
class ReadThread implements Runnable{

	private Res res;
	
	ReadThread(Res res){
		this.res=res;
	}
	@Override
	public void run() {
		while(true) {
			synchronized (res) {
				//如果是可写不可读的时候
				if(!res.flag) {
					try {
						res.wait();//等待被唤醒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("name:"+res.name+",sex:"+res.sex);
				// 走完了读线程，则使此时的线程处于可写
				res.flag=false;
				//同时唤醒此资源下的阻塞线程
				res.notify();
			}
		}
	}
}
/**
 * 写线程
 * 2019年5月7日
 * @author chaigy
 *
 */
class WriteThread implements Runnable{

	private Res res;
	
	WriteThread(Res res){
		this.res=res;
	}
	@Override
	public void run() {
		int count=0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (res) {
				//如果是可读的情况下，则等待
				if(res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(count==0) {
					res.name="小红";
					res.sex="女";
				}else {
					res.name="小张";
					res.sex="男";
				}
				//写完成，则开启可读
				res.flag=true;
				res.notify();
				count = ++count %2;
				
			}
		}
	}
}

/**
 * 2019年5月7日
 * @author chaigy
 *
 */
public class WaitAndNotify {

	public static void main(String[] args) {
		Res res = new Res();
		new Thread(new ReadThread(res),"读线程").start();
		new Thread(new WriteThread(res),"写线程").start();;
	}

}
