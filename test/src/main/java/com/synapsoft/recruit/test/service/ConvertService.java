package com.synapsoft.recruit.test.service;

import org.springframework.stereotype.Service;

import com.synapsoft.recruit.test.util.GetKor;
import com.synapsoft.recruit.test.util.Knum;

@Service
public class ConvertService {
	public String convert(String s) {
		String result = "";
		
		String money = s;
		
		if (money.contains("원")) {
			money = money.replace("원", "");
		}

		if (money.contains(",")) {
			money = money.replace(",", "");
		}
		
		int len = money.length();

		if (len == 1) {
			return Knum.values()[Integer.parseInt(money)] + "원";
		}
		
		StringBuilder sb = new StringBuilder(money);
		sb.reverse();

		StringBuilder rb = new StringBuilder();

		int capasity = len % 4 == 0 ? len / 4 : len / 4 + 1;
		int index = 0;
		int cnt = 1;

		rb.append("원");

		String[] str = new String[capasity];

		for (int i = 0; i < sb.length(); i++) {
			if (i != 0 && i % 4 == 0)
				index++;

			if (str[index] == null)
				str[index] = "";

			str[index] += sb.substring(i, i + 1);

			if (cnt == 4) {
				cnt = 1;
				continue;
			}

			cnt++;
		}

		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("0000")) continue;

			String sub = "";

			switch (i) {
			case 1:
				sub = "만";
				break;
			case 2:
				sub = "억";
				break;
			case 3:
				sub = "조";
				break;
			default:
				break;
			}
			
			rb.insert(0, " " + GetKor.getInstance().getKorNum(str[i], sub));
		}
		
		result = rb.toString().trim();
		
		if (result.startsWith("일")) result = result.substring(1);
		return result;
	}
}
