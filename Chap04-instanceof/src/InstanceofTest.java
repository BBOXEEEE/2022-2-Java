
class Pet{
	public void foo() {
		System.out.println("Pet:foo()");
	}
}

class Dog extends Pet{
	@Override public void foo(){
		System.out.println("Dog:foo()");
	}
}

class Cat extends Pet{
}

public class InstanceofTest {
	public static void test() {
		Pet p1 = new Dog();
		if(p1 instanceof Dog) {
			System.out.println("p1 is Dog type");
		}
		if(p1 instanceof Pet) {
			System.out.println("p1 is Pet type");
		}
		if(p1 instanceof Object) {
			System.out.println("p1 is Object type");
		}
		if(!(p1 instanceof Cat)) {
			System.out.println("p1 is not Cat type");
		}
		if(p1 instanceof Dog dog) { // java 16
			System.out.println("using preview feature");
			dog.foo();
		} 
	}
	
	public static void main(String[] args) {
		test();
	}

}
