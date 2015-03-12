package com.app.client.investment.fundresearch;

public class Account {
	private String code;
	private String name;
	private String day;
	private String performance;
	private String avePerformance;
	
	public Account(String code, String name, String day, String performance, String aveP) {
		this.code = code;
		this.name = name;
		this.day = day;
		this.performance = performance;
		this.avePerformance = aveP;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getAvePerformance() {
		return avePerformance;
	}

	public void setAvePerformance(String avePerformance) {
		this.avePerformance = avePerformance;
	}
}
