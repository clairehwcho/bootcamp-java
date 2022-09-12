package com.codingdojo.ninjagoldgame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/activities")
	public String activities() {
		return "activities.jsp";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/processGold", method = { RequestMethod.GET, RequestMethod.POST })
	public String findGold(HttpSession session, Model model,
			@RequestParam(value = "farm", required = false) String farm,
			@RequestParam(value = "cave", required = false) String cave,
			@RequestParam(value = "house", required = false) String house,
			@RequestParam(value = "quest", required = false) String quest) {

		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm a");
		Integer currentGold = 0;
		ArrayList<String> activities = new ArrayList<>();

		if (session.getAttribute("currentGold") == null) {
			session.setAttribute("currentGold", 0);
			session.setAttribute("activities", activities);
		} else {
			currentGold = (Integer) session.getAttribute("currentGold");
			activities = (ArrayList<String>) session.getAttribute("activities");
			session.setAttribute("activities", activities);
		}

		if (farm != null) {
			Integer goldFound = new Random().nextInt(11) + 10;
			currentGold += goldFound;

			session.setAttribute("currentGold", currentGold);
			activities.add(0,
					"You entered a farm and earned " + goldFound + " gold. (" + format.format(new Date()) + ")");

			return "redirect:/processGold";
		}
		if (cave != null) {
			Integer goldFound = new Random().nextInt(6) + 5;
			currentGold += goldFound;

			session.setAttribute("currentGold", currentGold);
			activities.add(0,
					"You entered a cave and earned " + goldFound + " gold. (" + format.format(new Date()) + ")");

			return "redirect:/processGold";
		}
		if (house != null) {
			Integer goldFound = new Random().nextInt(4) + 2;
			currentGold += goldFound;

			session.setAttribute("currentGold", currentGold);
			activities.add(0,
					"You entered a house and earned " + goldFound + " gold. (" + format.format(new Date()) + ")");

			return "redirect:/processGold";
		}
		if (quest != null) {
			Integer goldFound = new Random().nextInt(101) - 50;
			currentGold += goldFound;

			session.setAttribute("currentGold", currentGold);
			if (goldFound < 0) {
				activities.add(0, "You failed the quest and lost " + (goldFound * -1) + " gold. ("
						+ format.format(new Date()) + ")");
			} else {
				activities.add(0, "You completed the quest and earned " + goldFound + " gold. ("
						+ format.format(new Date()) + ")");
			}

			return "redirect:/processGold";
		}

		return "index.jsp";
	}

	@RequestMapping(value = "/reset", method = { RequestMethod.GET, RequestMethod.POST })
	public String reset(HttpSession session) {
		session.setAttribute("currentGold", 0);
		session.setAttribute("activities", new ArrayList<String>());
		return "redirect:/processGold";
	}
}