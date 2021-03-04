package week3day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {

	public ThreadDemo() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->System.out.println("Child Thread"));
		es.shutdown();
	}
	
	public static void main(String[] args) throws Exception{
		new ThreadDemo();
		
		for(int i=0;i<5;i++) {          
			System.out.println(i);          
			Thread.sleep(1000);       
		}
	}
}


class ThreadJob implements Runnable{ 
	
	@Override
	public void run() {
		System.out.println("child thread is working......");
	}
}
