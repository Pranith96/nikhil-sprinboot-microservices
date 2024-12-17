import java.util.Objects;

public class Student {

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

	@Override
	public int hashCode() {
		return Objects.hash(age, id, mobileNumber, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(age, other.age) && Objects.equals(id, other.id)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(name, other.name);
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
