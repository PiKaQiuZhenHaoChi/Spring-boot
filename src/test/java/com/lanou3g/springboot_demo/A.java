package com.lanou3g.springboot_demo;

import org.junit.Test;

public class A {

	private void print() {
		System.out.println("A");
	}

	static class B extends A {
		public void print() {
			System.out.println("B");
		}
	}

	static class C {
		public A print() {
			return new A();
		}
	}

	static class D extends C {
		public A print() {
			return new B();
		}
	}

	@Test
	public void test() {
		C c = new D();
		c.print();
		new B().print();
		D d = new D();
		d.print().print();
	}

}
