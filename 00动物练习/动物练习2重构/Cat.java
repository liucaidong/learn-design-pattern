package code.chapter0.animal2;

public class Cat extends Animal {

	public Cat (){
		super();
	}
	public Cat (String name){
		super(name);
	}

	protected String getShoutSound(){
		return "喵";
	}
}
