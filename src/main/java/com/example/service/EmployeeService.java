package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;

/**
 * 従業員情報を操作するサービス.
 * 
 * @author igamasayuki
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 従業員情報を全件取得します.
	 * 
	 * @return 従業員情報一覧
	 */
	public List<Employee> showList() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}

	/**
	 * 従業員情報を取得します.
	 * 
	 * @param id ID
	 * @return 従業員情報
	 * @throws org.springframework.dao.DataAccessException 検索されない場合は例外が発生します
	 */
	public Employee showDetail(Integer id) {
		Employee employee = employeeRepository.load(id);
		return employee;
	}

	/**
	 * 従業員情報を登録します.
	 *
	 * @param employee 従業員情報
	 */
	synchronized public void insert(Employee employee) {
		employee.setId(employeeRepository.getPrimaryId());
		employeeRepository.insert(employee);
	}

	/**
	 * 従業員情報を更新します.
	 * 
	 * @param employee 更新した従業員情報
	 */
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}

	public List<Employee> findByLikeName(String name){
		return employeeRepository.findByLikeName(name);
	}

	/**
	 * オートコンプリート用にJavaScriptの配列の中身を文字列で作ります.
	 *
	 * @param employeeList 従業員一覧
	 * @return　オートコンプリート用JavaScriptの配列の文字列
	 * 　　　　　
	 */
	//
	public List<String> getEmployeeListForAutocomplete(List<Employee> employeeList) {
//		StringBuilder employeeListForAutocomplete = new StringBuilder();
//		for (int i = 0; i < employeeList.size(); i++) {
//			if (i != 0) {
//				employeeListForAutocomplete.append(",");
//			}
//			Employee employee = employeeList.get(i);
//			employeeListForAutocomplete.append("\"");
//			employeeListForAutocomplete.append(employee.getName());
//			employeeListForAutocomplete.append("\"");
//		}
		List<String> employeeListForAutocomplete = new ArrayList<>();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee employee = employeeList.get(i);
			employeeListForAutocomplete.add(employee.getName());
		}
		return employeeListForAutocomplete;
	}
}
