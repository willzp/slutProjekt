package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class csvFileReader {

	public String readFile(String fileName) throws FileNotFoundException, IOException {
		var csvFile = new ClassPathResource(fileName);
		String result = "";

		try (Scanner myScanner = new Scanner(csvFile.getFile())) {
			ArrayList<String> titles = new ArrayList<String>();
			if (myScanner.hasNext()) {
				titles = processFirstLine(myScanner.nextLine());
			}
			while (myScanner.hasNextLine()) {
				result += "{\n" + processLine(myScanner.nextLine(), titles) + "},\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	private ArrayList<String> processFirstLine(String textLine) {
		ArrayList<String> titles = new ArrayList<String>();
		Scanner rowScanner = new Scanner(textLine);
		rowScanner.useDelimiter(",");
		while (rowScanner.hasNext()) {
			titles.add(rowScanner.next());
		}
		return titles;
	}

	public String processLine(String textLine, ArrayList<String> titles) {
		String result = "";

		Scanner rowScanner = new Scanner(textLine);
		rowScanner.useDelimiter(",");

		for (int i = 0; i < titles.size(); i++) {
			if (rowScanner.hasNext()) {
				result += "\"" + titles.get(i) + "\": \"" + rowScanner.next() + "\",\n";
			}
		}

		return result;
	}

}
