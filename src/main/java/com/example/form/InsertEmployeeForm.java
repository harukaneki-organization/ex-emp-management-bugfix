package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.multipart.MultipartFile;

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
    @NotBlank(message = "従業員名を入力してください")
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
    private String hireDateString;
    /**
     * メールアドレス
     */
    @Email(message = "メールアドレスの形式ではありません")
    @NotBlank(message = "メールアドレスを入力してください")
    private String mailAddress;
    /**
     * 郵便番号
     */
    @NotBlank(message = "郵便番号を入力してください")
    private String zipCode;
    /**
     * 住所
     */
    @NotBlank(message = "住所を入力してください")
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

}
