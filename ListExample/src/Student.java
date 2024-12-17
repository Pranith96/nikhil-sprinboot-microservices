
public class Student extends Object {

	private Integer id;
	private String name;
	private Integer age;
	private String mobileNumber;
	
	public Student(Integer id, String name, Integer age, String mobileNumber) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobileNumber = mobileNumber;
	}

	public Student() {
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", mobileNumber=" + mobileNumber + "]";
	}
}
