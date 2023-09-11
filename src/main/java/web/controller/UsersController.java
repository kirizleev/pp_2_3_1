package web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printUsers(ModelMap model) {

		List<User> users = userService.listUsers();

		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/user_{id}")
	public String showUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getById(id));
		return "user";
	}

	@GetMapping("/edit_{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getById(id));
		return "edit";
	}

	@PostMapping()
	public String create(@ModelAttribute("person") User user) {
		userService.add(user);
		return "redirect:/";
	}

	@PatchMapping("/edit_{id}")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.edit(user);
		return "redirect:/";
	}

	@DeleteMapping("/delete_{id}")
	public String deleteUser(@ModelAttribute("user") User user) {
		userService.delete(user);
		return "redirect:/";
	}

	@GetMapping("/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "/new";
	}

	@GetMapping()
	public String createUser(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/";
	}
}