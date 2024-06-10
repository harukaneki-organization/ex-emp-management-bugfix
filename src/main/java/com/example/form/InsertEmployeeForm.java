package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

/**
 * 従業員情報登録時に使用するフォーム.
 *
 * @author haruka.yamaneki
 */
public class InsertEmployeeForm {
    /**
     * ID
     */
    private Integer id;
    /**
     * 従業員名
     */
    //@NotBlank(message = "画像を入力してください")
    private String name;
    /**
     * 画像
     */
    private MultipartFile image;
    /**
     * 性別
     */
    @NotBlank(message = "性別を入力してください")
    private String gender;
    /**
     * 入社日
     */
    private LocalDate hireDate;
    /**
     * メールアドレス
     */
    @Email(message = "メールアドレスの形式ではありません")
    @NotBlank(message = "メールアドレスを入力してください")
    private String mailAddress;
    /**
     * 郵便番号
     */
    private String zipCode;
    /**
     * 住所
     */
    private String address;
    /**
     * 電話番号
     */
    @NotBlank(message = "電話番号を入力してください")
    private String telephone;
    /**
     * 給料
     */
    @NotBlank(message = "給料を入力してください")
    private String salary;
    /**
     * 特性
     */
    @NotBlank(message = "特性を入力してください")
    private String characteristics;
    /**
     * 扶養人数
     */
    @NotBlank(message = "扶養人数を入力してください")
    private String dependentsCountString;

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getdependentsCountString() {
        return dependentsCountString;
    }

    public void setdependentsCountString(String dependentsCountString) {
        this.dependentsCountString = dependentsCountString;
    }
}
