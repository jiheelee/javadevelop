package kr.co.mlec.day0531;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PayGetInfo {
	public void data(PayInfo[] information) {
		int num = 100;
		try {
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ksw\\Desktop\\input2.csv"));
			String s;
			int i = 0;
			while((s = in.readLine()) != null) {
				
				String[] splitString = new String[3];
				int price;
				String store;
				String date;
				splitString = s.split(",");
				price = Integer.parseInt(splitString[0]);
				store = splitString[1];
				date = splitString[2];
				information[i] = new PayInfo(price, store, date);
				i++;
			}
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
//		for(int i = 0; i < information.length; i++) {
//			PayInfo info = information[i];
//			System.out.print(info.price);
//			System.out.print(info.store);
//			System.out.print(info.date);
//			System.out.println();
//		}
	}
}
