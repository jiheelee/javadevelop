package kr.co.mlec.day0531;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleMain {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ksw\\Desktop\\input.csv"));
			String s;
			while((s = in.readLine()) != null) {
				String[] splitString = new String[2];
				String name;
				int point;
				splitString = s.split(",");
				name = splitString[0];
				point = Integer.parseInt(splitString[1]);
				
				System.out.println("이름 : " + name + "\n" + "점수 : " + point);
			}
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
}
