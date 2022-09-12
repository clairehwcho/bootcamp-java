package com.codingdojo.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "redirect:/omikuji";
	}

	@RequestMapping("/omikuji")
	public String showForm() {
		return "index.jsp";
	}

	@RequestMapping(value = "/processOmikuji", method = RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam(value = "number") Integer number,
			@RequestParam(value = "name") String name, @RequestParam(value = "hobby") String hobby,
			@RequestParam(value = "livingname") String livingname, @RequestParam(value = "message") String message) {

		session.setAttribute("number", number);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingname", livingname);
		session.setAttribute("message", message);

		return "redirect:/omikuji/show";
	}

	@RequestMapping("/omikuji/show")
	public String showResult() {
		return "result.jsp";
	}
}
