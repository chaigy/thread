package com.cgy;




class Res{
	public String name;
	
	public String sex;
	//false ���Զ�����д  true ����д���ܶ�
	public boolean flag=false;
	Res(){
		
	}
	
}
//д�߳�
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
				//�����true �����д ���ܶ�  ����ǿɶ�����д��ʱ����ȴ�
				if(!res.flag) {
					try {
						res.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(count==0) {
					res.name="С��";
					res.sex="Ů";
				}else {
					res.name="С��";
					res.sex="��";
				}
				
				//д�꣬���л����ɶ��̣߳������߳�
				res.flag=false;
				res.notify();
			}
			count=++count%2;
			
			
			
		}
	}
}
//���߳�
class ReadThread implements Runnable{
	private Res res;
	
	ReadThread(Res res){
		this.res=res;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (res) {
				if(res.flag) {//�����д�Ļ����Ͳ���Ҫȥ��
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
 * ��ʾwait��notify����д����д-->�߶�
 * @author chaigy
 *
 */
public class WaitAndNotify {
	
	public static void main(String[] args) {
		Res res = new Res();
		WriteThread w = new WriteThread(res);
		ReadThread r = new ReadThread(res);
		new Thread(w,"д�߳�").start();
		new Thread(r,"���߳�").start();
	}
}
