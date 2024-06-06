package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.validation.BindingResult;

/**
 * 管理者情報を操作するサービス.
 * 
 * @author igamasayuki
 *
 */
@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;

	/**
	 * 管理者情報を登録します.
	 * 
	 * @param administrator 管理者情報
	 */
	public void insert(Administrator administrator, BindingResult result) {
		try {
			if (administratorRepository.findByMailAddress(administrator.getMailAddress()) != null) {
				result.rejectValue("mailAddress", " ", "メールアドレスが既に使用されています。");
			} else {
				administratorRepository.insert(administrator);
			}
		} catch (Exception e) {
			result.reject("Error", "予期せぬエラーが発生しました。");
		}
	}


	/**
	 * ログインをします.
	 * 
	 * @param mailAddress メールアドレス
	 * @param password    パスワード
	 * @return 管理者情報 存在しない場合はnullが返ります
	 */
	public Administrator login(String mailAddress, String password) {
		Administrator administrator = administratorRepository.findByMailAddressAndPassward(mailAddress, password);
		return administrator;
	}









}
