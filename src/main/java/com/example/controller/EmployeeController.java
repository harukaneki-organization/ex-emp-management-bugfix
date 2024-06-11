package com.example.controller;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.example.form.InsertAdministratorForm;
import com.example.form.InsertEmployeeForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;

/**
 * 従業員情報を操作するコントローラー.
 * 
 * @author haruka.yamaneki
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 使用するフォームオブジェクトをリクエストスコープに格納する.
	 * 
	 * @return フォーム
	 */
	@ModelAttribute
	public UpdateEmployeeForm setUpForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 使用するフォームオブジェクトをリクエストスコープに格納する.
	 *
	 * @return フォーム
	 */
	@ModelAttribute
	public InsertEmployeeForm insertEmployeeForm() {
		return new InsertEmployeeForm();
	}

	/////////////////////////////////////////////////////
	// ユースケース：従業員一覧を表示する
	/////////////////////////////////////////////////////
	/**
	 * 従業員一覧画面を出力します.
	 * 
	 * @param model モデル
	 * @return 従業員一覧画面
	 */
	@GetMapping("/showList")
	public String showList(Model model,String findName) {
		List<Employee> employeeList = new ArrayList<>();
		if(findName == null){
			employeeList = employeeService.showList();
		}else{
			employeeList = employeeService.findByLikeName(findName);
		}
		if(employeeList.size() == 0){
			model.addAttribute("notFindName", "一件もありませんでした");
		}
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}

	/////////////////////////////////////////////////////
	// ユースケース：従業員詳細を表示する
	/////////////////////////////////////////////////////
	/**
	 * 従業員詳細画面を出力します.
	 * 
	 * @param id    リクエストパラメータで送られてくる従業員ID
	 * @param model モデル
	 * @return 従業員詳細画面
	 */
	@GetMapping("/showDetail")
	public String showDetail(String id, Model model) {
		Employee employee = employeeService.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	/////////////////////////////////////////////////////
	// ユースケース：従業員詳細を更新する
	/////////////////////////////////////////////////////
	/**
	 * 従業員詳細(ここでは扶養人数のみ)を更新します.
	 * 
	 * @param form 従業員情報用フォーム
	 * @return 従業員一覧画面へリダクレクト
	 */
	@PostMapping("/update")
	public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return showDetail(form.getId(), model);
		}
		Employee employee = new Employee();
		employee.setId(form.getIntId());
		employee.setDependentsCount(form.getIntDependentsCount());
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}

	/**
	 * 管理者登録画面を出力します.
	 *
	 * @return 管理者登録画面
	 */
	@GetMapping("/toInsert")
	public String toInsert(InsertEmployeeForm form) {
		return "employee/insert";
	}

	/**
	 * 従業員情報を登録します.
	 *
	 * @param form 従業員情報用フォーム
	 */
	@PostMapping("/insert")
	public String insert(@Validated InsertEmployeeForm form, BindingResult result){

		if (result.hasErrors()) {
			return toInsert(form);
		}

		Employee employee = new Employee();
		BeanUtils.copyProperties(form,employee);
		Date HireDate = java.util.Date.from(form.getHireDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		employee.setHireDate(HireDate);
		employee.setSalary(Integer.parseInt(form.getSalary()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));


		try{
			String base64FileString = Base64.getEncoder().encodeToString(form.getImage().getBytes());
			if("image/jpg".equals(form.getImage().getContentType())) {
				base64FileString = "data:image/jpeg;base64," + base64FileString;
			} else if("image/png".equals(form.getImage().getContentType())) {
				base64FileString = "data:image/png;base64," + base64FileString;
			}

			employee.setImage(base64FileString);

		}catch (Exception e){

		}

		employeeService.insert(employee);

		return "redirect:/employee/showList";


	}
}
