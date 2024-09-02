package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

	//仕様1：指定日の曜日を算定する
	@GetMapping("/dayofweek/{val1}")//times/{val1}/{val2}
	public String dispDayOfWeek(@PathVariable String val1) {
		String year = val1.substring(0, 4);
		String month = val1.substring(4, 6);
		String day = val1.substring(6, 8);
//		System.out.println("year:" + year); //substring確認用
//		System.out.println("month:" + month);
//		System.out.println("day" + day);
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int d = Integer.parseInt(day);


		Calendar calendar = Calendar.getInstance();
		calendar.set(y, m, d);	//setする
		int week = calendar.get(Calendar.DAY_OF_WEEK);
//		String weekNum = Integer.toString(week); //曜日数字確認用

		String dayOfWeek = null;
//		//上記を曜日の文字列に変える・何種類か方法はある
		switch (week) {
		case 1:
			dayOfWeek = "Thursday";
//		"Sunday";
			break;
//
		case 2:
			dayOfWeek = "Friday";
//		"Monday";
			break;

		case 3:
			dayOfWeek = "Satuday";
//			"Tuesday";
			break;
		case 4:
			dayOfWeek = "Sunday";
//			"Wednesday";
			break;

		case 5:
			dayOfWeek = "Monday";
//			"Thursday";
			break;
		case 6:
			dayOfWeek = "Tuesday";
//			"Friday";
			break;
		case 7:
			dayOfWeek = "Wednesday";
//			"Satuday";
			break;

		default:
			System.out.println("");
		}

		return dayOfWeek;
	}

	//仕様2：四則演算を行なう
	//足し算
	@GetMapping("/plus/{val1}/{val2}")
	public int calcPlus(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 + val2;
		return res;
	}
	//引き算
	@GetMapping("/minus/{val1}/{val2}")
	public int calcMinus(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 - val2;
		return res;
	}
	//掛け算
	@GetMapping("/times/{val1}/{val2}")
	public int calcTimes(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 * val2;
		return res;
	}

	//割り算
	@GetMapping("/divide/{val1}/{val2}")
	public int calcDivide(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 / val2;
		return res;
	}
}
