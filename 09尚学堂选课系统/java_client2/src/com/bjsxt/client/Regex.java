package com.bjsxt.client;

public class Regex {
	
	// 课程容纳人数校正
	public boolean maxNumRegex(String str) {
		String regex = "[0-9]{1,2}";
		return str.matches(regex);
	}

	// 课程名字校正
		public boolean courseNameRegex(String str) {
			String regex = "[\u4e00-\u9fa50-9a-zA-Z]{1,10}";
			return str.matches(regex);
		}
	// 课程ID校正
	public boolean courseIDRegex(String str) {
		String regex = "[0-9]{2}";
		return str.matches(regex);
	}

	// 密码校正
	public boolean passwordRegex(String str) {
		String regex = "[a-zA-Z0-9]{4,10}";
		return str.matches(regex);
	}

	// 性别校正
	public boolean sexRegex(String str) {
		String regex = "[男|女]{1}";
		return str.matches(regex);
	}

	// 名字校正
	public boolean nameRegex(String str) {
		String regex = "[\u4e00-\u9fa5]{1,10}";
		return str.matches(regex);
	}

	// 年龄校正
	public boolean ageRegex(String str) {
		String regex = "[0-9]{1,2}";
		return str.matches(regex);
	}

	// 学生ID校正
	public boolean stuIDRegex(String str) {
		String regex = "[0-9]{6}";
		return str.matches(regex);
	}

	// 教师ID校正
	public boolean teacherIDRegex(String str) {
		String regex = "[0-9]{4}";
		return str.matches(regex);
	}

	// 管理员ID校正
	public boolean adminIDRegex(String str) {
		String regex = "[0-9]{2}";
		return str.matches(regex);
	}
	
	// 用户ID校正
		public boolean userIDRegex(String str) {
			String regex = "^[0-9]{2}|[0-9]{4}|[0-9]{6}";
			return str.matches(regex);
		}
}
