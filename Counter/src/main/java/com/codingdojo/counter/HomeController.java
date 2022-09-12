package com.codingdojo.counter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
	public String index(HttpSession session, Model model){
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
		// Use setAttribute to initialize the count in session
			session.setAttribute("count",0);
		}
		else {
			// increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
    
    @RequestMapping("/counter")
	public String counter(HttpSession session, Model model, HttpServletRequest request) {
		Integer currentCount = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}
		else {
			currentCount = (Integer) session.getAttribute("count");
		}
		// we can use the following line to get the URL of our page, in this case http://localhost:8080/counter/
		String homeUrl = request.getRequestURL().toString();

		model.addAttribute("count", currentCount);
		// we remove the last nine characters from homeUrl to match the desired wireframe output (http://localhost:8080 instead of http://localhost:8080/counter/)
		model.addAttribute("page", homeUrl.substring(0,homeUrl.length()-8)); 
		return "counter.jsp";
	}
    
    @RequestMapping("/double-counter")
	public String doubleCounter(HttpSession session, Model model, HttpServletRequest request) {
		Integer currentCount = 0;
    	if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			currentCount = (Integer) session.getAttribute("count");
			currentCount +=2;
			session.setAttribute("count",currentCount);
		}
		String homeUrl = request.getRequestURL().toString();

		model.addAttribute("count", currentCount);
		model.addAttribute("page", homeUrl.substring(0,homeUrl.length()-15)); 

		return "doubleCounter.jsp";
    }
    
    @RequestMapping("/reset-counter")
	public String resetCounter(HttpSession session, Model model) {
		session.setAttribute("count",0);
		return "redirect:/counter";
    }
}

