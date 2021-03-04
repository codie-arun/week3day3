package week3day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeamonThread {
	public DeamonThread() {
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true) {
				System.out.println("Child thread...");
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		
		new DeamonThread();
		System.out.println("main thread started....");
		Thread.currentThread().setDaemon(true);
		try {
			Thread.sleep(2000);
		}catch(Exception e) {}
		System.exit(1);
		
	}
}
