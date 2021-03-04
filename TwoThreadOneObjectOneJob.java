package week3day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadOneObjectOneJob {

	public static void main(String[] args) {
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		Gun bofors=new Gun();
		
		es.execute(()->{
			
			for(int i = 0;i<5;i++) {
				bofors.fill();
			}
			
		});
		
		
		es.execute(()->{
			
			for(int i = 0;i<5;i++) {
				bofors.shoot();
			}
		});
		
	}
	
}


class Gun{
	
	boolean flag;
	synchronized public void fill() {
		if(flag) {
			try{wait();}catch(Exception e) {}
		}
		System.out.println("Fill the gun");
		flag = true;
		notify();
	}
	
	synchronized public void shoot() {
		if(!flag) {
			try{wait();}catch(Exception e) {}
		}
		System.out.println("Shooooot");
		flag = false;
		notify();
	}
	
}