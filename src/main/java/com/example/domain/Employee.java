package com.example.domain;

import java.util.Date;

/**
 * 従業員情報を表すドメイン.
 *
 * @author haruka.yamaneki
 *
 */
public class Employee {
	/** id */
	private Integer id;
	/** 従業員名 */
	private String name;
	/** 画像 */
	private String image;
	/** 性別 */
	private String gender;
	/** 入社日 */
	private Date hireDate;
	/** メールアドレス */
	private String mailAddress;
	/** 郵便番号 */
	private String zipCode;
	/** 住所 */
	private String address;
	/** 電話番号 */
	private String telephone;
	/** 給料 */
	private Integer salary;
	/** 特性 */
	private String characteristics;
	/** 扶養人数 */
	private Integer dependentsCountString;

	/**
	 * 引数無しのコンストラクタ.
	 */
	public Employee() {
	}

	/**
	 * 初期化用コンストラクタ.
	 *
	 * @param id              ID
	 * @param name            従業員名
	 * @param image           画像
	 * @param gender          性別
	 * @param hireDate        入社日
	 * @param mailAddress     メールアドレス
	 * @param zipCode         郵便番号
	 * @param address         住所
	 * @param telephone       電話番号
	 * @param salary          給料
	 * @param characteristics 特性
	 * @param dependentsCountString 扶養人数
	 */
	public Employee(Integer id, String name, String image, String gender, Date hireDate, String mailAddress,
					String zipCode, String address, String telephone, Integer salary, String characteristics,
					Integer dependentsCountString) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.gender = gender;
		this.hireDate = hireDate;
		this.mailAddress = mailAddress;
		this.zipCode = zipCode;
		this.address = address;
		this.telephone = telephone;
		this.salary = salary;
		this.characteristics = characteristics;
		this.dependentsCountString = dependentsCountString;

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return the mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * @param mailAddress the mailAddress to set
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the salary
	 */
	public Integer getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	/**
	 * @return the characteristics
	 */
	public String getCharacteristics() {
		return characteristics;
	}

	/**
	 * @param characteristics the characteristics to set
	 */
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	/**
	 * @return the dependentsCountString
	 */
	public Integer getdependentsCountString() {
		return dependentsCountString;
	}


	public Integer getDependentsCountString() {
		return dependentsCountString;
	}

	public void setDependentsCountString(Integer dependentsCountString) {
		this.dependentsCountString = dependentsCountString;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", image='" + image + '\'' +
				", gender='" + gender + '\'' +
				", hireDate=" + hireDate +
				", mailAddress='" + mailAddress + '\'' +
				", zipCode='" + zipCode + '\'' +
				", address='" + address + '\'' +
				", telephone='" + telephone + '\'' +
				", salary=" + salary +
				", characteristics='" + characteristics + '\'' +
				", dependentsCountString=" + dependentsCountString +
				'}';
	}
}