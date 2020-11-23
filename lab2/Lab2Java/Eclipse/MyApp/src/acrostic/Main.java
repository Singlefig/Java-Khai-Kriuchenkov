package acrostic;

import org.me.mylib.LibClass;

public class Main {
	public static void main(String[] args) {
		String[] arg = "However we all feel zealous".split(" ");
		String result = LibClass.acrostic(arg);
		System.out.println("Result = " + result);
	}
}
