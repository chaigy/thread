package com.cgy.lx;


/**
 * ����һ�����ܣ�ʹһ���̲߳���д�����ݣ�һ���̲߳��ϵĶ�ȡ����
 * 2019��5��7��
 * @author chaigy
 *
 */

class Res{
	
	public String name;
	public String sex;
	//flag Ϊfalse��ʱ�� ��д���ɶ�   Ϊtrue��ʱ�򣬿ɶ�����д
	public boolean flag=false;
}
/**
 * ���߳�
 * 2019��5��7��
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
				//����ǿ�д���ɶ���ʱ��
				if(!res.flag) {
					try {
						res.wait();//�ȴ�������
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("name:"+res.name+",sex:"+res.sex);
				// �����˶��̣߳���ʹ��ʱ���̴߳��ڿ�д
				res.flag=false;
				//ͬʱ���Ѵ���Դ�µ������߳�
				res.notify();
			}
		}
	}
}
/**
 * д�߳�
 * 2019��5��7��
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
				//����ǿɶ�������£���ȴ�
				if(res.flag) {
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
				//д��ɣ������ɶ�
				res.flag=true;
				res.notify();
				count = ++count %2;
				
			}
		}
	}
}

/**
 * 2019��5��7��
 * @author chaigy
 *
 */
public class WaitAndNotify {

	public static void main(String[] args) {
		Res res = new Res();
		new Thread(new ReadThread(res),"���߳�").start();
		new Thread(new WriteThread(res),"д�߳�").start();;
	}

}
