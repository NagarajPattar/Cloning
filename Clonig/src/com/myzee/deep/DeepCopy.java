package com.myzee.deep;

public class DeepCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1 = new Test();
		Test t2 = null;
		System.out.println(t1.a + " " + t1.b + " " + t1.t.c);
		try {
			t2 = (Test) t1.clone();
			//t2.t.c = 300;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t1.a + " " + t1.b + " " + t1.t.c);
		System.out.println(t2.a + " " + t2.b + " " + t2.t.c);
	}

}

class Test implements Cloneable {
	int a = 10;
	int b = 20;
	Test2 t = new Test2();

	protected Object clone() throws CloneNotSupportedException {
//		Test tt = new Test();
		Test tt = (Test) super.clone();
		tt.t = new Test2();		//	whenever cloning an object, here reference object has to be created newly and return it. So for every deep copy, there will be fresh reference object.
//		return super.clone();
		return tt;
	}
}

class Test2 {
	int c = 30;
}