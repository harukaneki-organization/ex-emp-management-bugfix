package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * 管理者情報を登録します.
	 *
	 * @param administrator 管理者情報
	 */
	public void insert(Administrator administrator) {
		//パスワードをハッシュ化
		administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
		administratorRepository.insert(administrator);


	}

	/**
	 * ログインをします.
	 *
	 * @param mailAddress メールアドレス
	 * @param password    パスワード
	 * @return 管理者情報 存在しない場合はnullが返ります
	 */
	public Administrator login(String mailAddress, String password) {
		//パスワードをハッシュ化
		System.out.println(password);

		Administrator administrator = administratorRepository.findByMailAddress(mailAddress);
		if(passwordEncoder.matches(password,administrator.getPassword())){
			return administrator;
		}
		return null;
	}

	/**
	 * メールアドレスを取得します.
	 *
	 * @param mailAddress
	 * @return メールアドレス
	 */
	public Administrator findByMailAddress(String mailAddress) {
		return administratorRepository.findByMailAddress(mailAddress);
	}

}

