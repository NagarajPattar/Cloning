package com.myzee.shallow;

public class ShallowCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1 = new Test();
		System.out.println(t1.a + " " + t1.b + " " + t1.c + " " + t1.t.d);
		
		try {
			Test t2 = (Test)t1.clone();
			t2.t.d = 400;	// changing the value of Test2.d inside t2 will change in t1 also. t1 and t2 are objects of Test.
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Here t1.t.d will print value as 400, because t is the reference and common object for both t1 and t2 objects. 
		 * So changing the reference object value will affect to other object also.
		 */
		System.out.println(t1.a + " " + t1.b + " " + t1.c + " " + t1.t.d);
		
	}

}

class Test implements Cloneable {
	
	int a = 10;
	int b = 20;
	int c = 30;
	Test2 t = new Test2();	// reference to Test2 object in Test, shallow copy will not happen.
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("calling clone method");
		return super.clone();
		
	}
	
}

class Test2 {
	int d = 40;
}
