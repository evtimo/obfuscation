import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee
{
	private  Integer id;
	private String firstName;
	private String lastName;
	private String location;

	public String getLastName() {
		return lastName;
	}

	public String getLocation() {
		return location;
	}

	public String getFirstName() {
		return firstName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}