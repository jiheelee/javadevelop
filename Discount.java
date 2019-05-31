package kr.co.mlec.day0531;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Discount {
	static PayInfo[] information = new PayInfo[100];
	static List<FinalList> finalList = new ArrayList();
	public static void main(String[] args) {
		PayGetInfo pay = new PayGetInfo();
		pay.data(information);
		Set<String> month = new HashSet<>();
		Set<String> date = new HashSet<>();
		Set<String> store = new HashSet<>();
		for(int i = 0; i < information.length; i++) {
			PayInfo info = information[i];
			
			month.add(info.date.substring(0,6));
			date.add(info.date);
			store.add(info.store);
		}
//		for(Iterator i = month.iterator(); i.hasNext();) {
//			System.out.println(i.next());
//			
//		}
//		for(int i = 0; i < information.length; i++) {
//			System.out.println(information[i].date.substring(0,6));
//		}
		int totalPrice = 0;
		int totalDiscount = 0;
		List<String> monthList = new ArrayList<>(month); 
		List<String> dateList = new ArrayList<>(date); 
		List<String> storeList = new ArrayList<>(store);
		int[] countMonth = new int[monthList.size()];
		int[] countDate = new int[dateList.size()];
		int[][] countStore = new int[dateList.size()][storeList.size()];
		for(int i = 0; i < information.length; i++) {
			PayInfo p = information[i];
			if(p.price >= 1000) {				
				for(int m = 0; m < monthList.size(); m++) {
					if(monthList.get(m).equals(p.date.substring(0,6)) && countMonth[m] < 20) {
						for(int d = 0; d < dateList.size(); d++) {
							if(dateList.get(d).equals(p.date) && countDate[d] < 3) {
								for(int s = 0; s < storeList.size(); s++) {
									if(storeList.get(s).equals(p.store) && countStore[d][s] < 1) {
										countMonth[m] += 1;
										countDate[d] += 1;
										countStore[d][s] += 1;
										totalDiscount += 500;
										finalList.add(new FinalList(p.date, p.store, p.price, (p.price - 500)));
									}
								}
							}
						}
					}
				}
			}
			totalPrice += p.price;
		}
		System.out.println("출력데이터");
		System.out.printf("총 사용금액 : %d원\n", totalPrice);
		System.out.printf("총 할인금액 : %d원\n", totalDiscount);
		System.out.printf("실제 결제금액 : %d원\n", totalPrice - totalDiscount);
		
		System.out.println("할인내역");
		System.out.println("날짜\t가맹점코드\t결제 금액\t실제 결제 금액");
		for(int i = 0; i < finalList.size(); i++) {
			FinalList f = finalList.get(i);
			System.out.printf("%s\t%s\t%8d원\t\t%d원\n", f.date, f.store, f.price, f.discountedPrice);
			
			
		}
	}
}
