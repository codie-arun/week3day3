package week3day3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadsOneObject {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);      
		ReservationCounter central=new ReservationCounter();
		
		es.execute(()->{
			
			Thread.currentThread().setName("Ram");
			synchronized(central) {
				central.bookTicket(1000); 
				central.getChange();
			}
			
			System.out.println(Thread.currentThread().toString());
		});
		
		es.execute(()->{
			
			Thread.currentThread().setName("Sam");
			synchronized(central) {
				central.bookTicket(500); 
				central.getChange();
			}
			
			
		});
		
		
		
		es.shutdown();
	}
}

class ReservationCounter{
	
	int amt;
	
	public void bookTicket(int amt) {
		this.amt = amt;
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Ticket booked by...:"+name+" with amount....:"+amt);       

		try {Thread.sleep(1000);
		}catch(Exception e) {}
		}
	
	public void getChange() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Change given to...:"+name+" amount is...:"+(amt-100));
	}
}