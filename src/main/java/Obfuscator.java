import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.File;

@XmlSeeAlso({EmployeesList.class})
public class Obfuscator {

	private static String source="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static String target="mWOyuQHI9FTgipC4noG2XcfJ0EhdeNlbx7VMAwB6r8UtPDSskzqvYZj3RaL5K1";

	private static EmployeesList getEmployeesFromXML(String filename) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		//We had written this file in marshalling example
		EmployeesList emps = (EmployeesList) jaxbUnmarshaller.unmarshal( new File(filename) );

		return (emps);
	}

	private static void saveEmployeesInXML(EmployeesList employees, String filename) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(employees, new File(filename));
	}

	public static EmployeesList obfuscateEmployeeList(EmployeesList emps) {
		for(Employee emp : emps.getEmployees())
		{
			emp.setFirstName(obfuscate(emp.getFirstName()));
			emp.setLastName(obfuscate(emp.getLastName()));
			emp.setLocation(obfuscate(emp.getLocation()));
		}
		return emps;
	}

	public static EmployeesList unobfuscateEmployeeList(EmployeesList emps) {
		for(Employee emp : emps.getEmployees())
		{
			emp.setFirstName(unobfuscate(emp.getFirstName()));
			emp.setLastName(unobfuscate(emp.getLastName()));
			emp.setLocation(unobfuscate(emp.getLocation()));
		}
		return emps;
	}

	public void unobfuscateEmployeeListFromFile(String inputFilename, String outputFilename) throws JAXBException {
		EmployeesList emp = getEmployeesFromXML(inputFilename);
		unobfuscateEmployeeList(emp);
		saveEmployeesInXML(emp, outputFilename);
	}

	public void obfuscateEmployeeListFromFile(String inputFilename, String outputFilename) throws JAXBException {
		EmployeesList emp = getEmployeesFromXML(inputFilename);
		obfuscateEmployeeList(emp);
		saveEmployeesInXML(emp, outputFilename);
	}

	public static String obfuscate(String s) {
		return getString(s, source, target);
	}

	public static String unobfuscate(String s) {
		return getString(s, target, source);
	}

	private static String getString(String s, String target, String source) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = source.indexOf(c);
			stringBuilder.append(target.charAt(index));
		}
		return stringBuilder.toString();
	}
}
