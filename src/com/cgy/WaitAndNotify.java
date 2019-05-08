package com.cgy;




class Res{
	public String name;
	
	public String sex;
	//false 可以读不能写  true 可以写不能读
	public boolean flag=false;
	Res(){
		
	}
	
}
//写线程
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
				//如果是true 则可以写 不能读  如果是可读不可写的时候，则等待
				if(!res.flag) {
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
					res.name="小李";
					res.sex="男";
				}
				
				//写完，则切换到可读线程，唤醒线程
				res.flag=false;
				res.notify();
			}
			count=++count%2;
			
			
			
		}
	}
}
//读线程
class ReadThread implements Runnable{
	private Res res;
	
	ReadThread(Res res){
		this.res=res;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (res) {
				if(res.flag) {//如果可写的话，就不需要去读
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(res.name+":"+res.sex);	
				res.flag=true;
				res.notify();
			}
			
		}
	}
	
}
/**
 * 演示wait和notify来编写：边写-->边读
 * @author chaigy
 *
 */
public class WaitAndNotify {
	
	public static void main(String[] args) {
		Res res = new Res();
		WriteThread w = new WriteThread(res);
		ReadThread r = new ReadThread(res);
		new Thread(w,"写线程").start();
		new Thread(r,"读线程").start();
	}
}
