package week3day3;

public class LambdaDemo {

	public static void main(String[] args) {
//		display(new MyInter() {
//			
//			public void met() {
//				System.out.println("Anonymous call");
//			}
//		});
		
		
		display(()->{
			System.out.println("display");
		});
		
		display2((greet,num)->{
			System.out.println("display2 : "+greet+num);
		});
		
		String s = display3((company)->{
			return company;
		});
		
		System.out.println(s);
	}
	
	public static void display(MyInter myinter) {
		myinter.met();
	}
	
	public static void display2(MyInter2 myinter) {
		myinter.met("Hello",10);
	}
	
	public static String display3(MyInter3 myinter) {
		return myinter.met("Ernst&Young");
	}
}


interface MyInter{
	
	public void met();
	
}

interface MyInter2{
	public void met(String s,int i);
}

interface MyInter3{
	public String met(String s);
}


class MyClass implements MyInter{
	
	public void met() {
		System.out.println("interface method called");
	}
	
}