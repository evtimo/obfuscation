import javax.xml.bind.JAXBException;

public class Main {

	private static String originalFileName = "./src/main/resources/original.xml";
	private static String obfucatedFileName = "./src/main/resources/obfuscated.xml";
	private static String unobfuscatedFileName = "./src/main/resources/unobfuscated.xml";

	public static void main(String[] args) throws JAXBException {
		Obfuscator obfuscator = new Obfuscator();
		obfuscator.obfuscateEmployeeListFromFile(originalFileName, obfucatedFileName);
		obfuscator.unobfuscateEmployeeListFromFile(obfucatedFileName, unobfuscatedFileName);
	}
}
