package test;

public abstract class Animals {

	private Integer id;
	private String name;
	private Integer age;
	
	public void print() {
		System.out.println("1111");
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public abstract void print1() ;
}
