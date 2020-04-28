package test;

public class Test03 {
	public static void main(String[] args){
		
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		
		Runnable r = ()->{
//			while(true) {
//				System.out.println(Thread.currentThread().getName());
//				try {
//					Thread.currentThread().sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				Thread.currentThread().interrupt();
//			}
			int a = 10;
			a = a/0;
		};
		Thread t1 = new Thread(r);
		t1.start();
	}
}
