package com.cgy.lx;

//threadLocal Ϊ�����̴߳洢 map
//�е��� �ֲ�����
class Res1{
	//����������Ļ����ͻᵼ��
	//1.�̲߳���ȫ
	//2.�̹߳����˸���ı���
	//private Integer count=0;
	
	ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		//��ʼ����ʼֵ
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
			System.out.println(Thread.currentThread().getName()+"��"+res.getCount());
		}
	}
}


/**
 * ��ϰʹ��threadLocal ����̰߳�ȫ���⣬����threadLocal����п��ܻ������ڴ�й©
 * 2019��5��7��
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
