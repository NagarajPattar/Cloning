package com.myzee.deep;

public class DeepCopy_Complete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test4 t = new Test4();
		t.t.c = 30;
		Test4 tt = null;
		System.out.println(t.a + " " + t.b + " " + t.t.c);
		try {
			tt = (Test4) t.clone();
			tt.t.c = 300;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.a + " " + t.b + " " + t.t.c);
		System.out.println(tt.a + " " + tt.b + " " + tt.t.c);
	}

}

class Test4 implements Cloneable {
	int a = 10;
	int b = 20;
	Test5 t = new Test5();

	@Override
	protected Object clone() throws CloneNotSupportedException {
//		Test tt = new Test();
		Test4 tt = (Test4) super.clone();
		tt.t = (Test5) this.t.clone();	// making deep copy of tt.t object
		return tt;
	}
}

class Test5 implements Cloneable{
	int c;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
