import java.io.*;
import java.util.*;

public class FileEditor {

	public static final String inputFile = "data.dgw"; //Initialize Respective to File Link Path
	public static final String outputFile = "output.js"; //Initialize Respective to File Link Path
	public static ArrayList<String> code = new ArrayList<String>();
	public static ArrayList<String> arr = new ArrayList<String>();
	public static String course = "var courseArray = [ ";
	public static String number = "var numberArray = [ ";


	public static void main(String[] args) {
		readFile();
		addExtraCode();
		createArray();
		pasteCode();
		writeFile();
	}

	public static void readFile() {
		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.charAt(0) != '?') {
						if (line.indexOf('/') != -1) {
							arr.add(line.substring(0, line.indexOf('/')));
						} else {
							arr.add(line);
						}
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Data File not found to write");
		} catch (IOException e) {
			System.out.println("I/O Error Occured");
		}

	}

	public static void createArray() {
		ArrayList<String> c = new ArrayList<String>();
		ArrayList<String> n = new ArrayList<String>();
		String entry;
		int divide;
		for (int i = 0; i < arr.size(); i++) {
			entry = arr.get(i).trim();
			divide = entry.indexOf(' ');
			c.add(entry.substring(0, divide).trim());
			n.add(entry.substring(divide, entry.length()).trim());
		}
		for (int j = 0; j < c.size(); j++) {
			course = course + "\"" + c.get(j) + "\",";
			number = number + "\"" + n.get(j) + "\",";
		}
		course = course.substring(0, course.length()-1) + "];";
		number = number.substring(0, number.length()-1) + "];";
	}

	public static void pasteCode() {
		code.set(0, course);
		code.set(1,  number);

	}

	public static void writeFile() {

		try {
			FileWriter fileWriter = new FileWriter(outputFile);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < code.size(); i++) {
				bufferedWriter.write(code.get(i));
				bufferedWriter.newLine();
			}
			bufferedWriter.close();

		} catch (FileNotFoundException e) {
			System.out.println("Data File not found to write");
		} catch (IOException e) {
			System.out.println("I/O Error Occured");
		}

	}

	public static void addExtraCode() {
		code.add("");
		code.add("");
		code.add("for (var i = 0; i < courseArray.length; i++) {");
		code.add("\tdocument.getElementsByName('Discipline')[0].value = courseArray[i];");
		code.add("\tdocument.getElementsByName('Number')[0].value = numberArray[i];");
		code.add("\tAddClass(document.frmWhatIfBody);");
		code.add("}");

	}


}
