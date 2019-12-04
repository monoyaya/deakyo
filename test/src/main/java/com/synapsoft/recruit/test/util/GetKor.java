package com.synapsoft.recruit.test.util;

public class GetKor {
	private static final GetKor instance = new GetKor();

	private GetKor() {
	}

	public static GetKor getInstance() {
		return instance;
	}

	public String getKorNum(String num, String sub) {
		String korNum = "";

		String[] nums = num.split("");

		for (int i = 0; i < nums.length; i++) {
			int target = Integer.parseInt(nums[i]);
			
			if (target == 0)
				continue;
			
			boolean flag = target == 1;

			String temp = Knum.values()[target].toString();
			
			switch (i) {
			case 0:
				break;
			case 1:
				if (flag) temp = "십";
				else temp = temp + "십";
				break;
			case 2:
				if (flag) temp = "백";
				else temp = temp + "백";
				break;
			case 3:
				if (flag) temp = "천";
				else temp = temp + "천";
				break;
			}
			
			korNum = temp + korNum;
		}

		return korNum + sub;
	}
}
