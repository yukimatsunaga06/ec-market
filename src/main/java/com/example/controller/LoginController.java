package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.LoginService;

@Controller
@RequestMapping("/market")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private HttpSession session;

	@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}

	///////////////////////////////////////////////////
	// ログイン設定 //
	///////////////////////////////////////////////////

	/**
	 * ログイン画面を表示するメソッド return login.html
	 */
	@RequestMapping("/login")
	public String toLogin() {

		return "login";
	}

	@RequestMapping("/login-result")
	public String login(LoginForm form, Model model) {
		User user = loginService.login(form.getEmail(), form.getPassword());

		if (user == null) {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードが不正です。");
			return toLogin();
		}

		session.setAttribute("user", user);
		session.setAttribute("name", user.getName()+"さんこんにちは！");
		return "redirect:/shop";
	}

	///////////////////////////////////////////////////
	// ログアウト設定 //
	///////////////////////////////////////////////////

	/**
	 * ログアウト用のメソッドを定義
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/shop";
	}

}
