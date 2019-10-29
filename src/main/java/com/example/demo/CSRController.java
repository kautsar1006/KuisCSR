package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CSRController {

	@Autowired
	private CSRService service;
	
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<CSRModel>listCSRx = service.listALL();
		model.addAttribute("listCSRx", listCSRx);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewCSRPage(Model model) {
		CSRModel csr = new CSRModel();
		model.addAttribute("csr", csr);
		
		return "new_csr";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveFitness(@ModelAttribute("csr") CSRModel csr) {
		service.Save(csr);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCSRPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView ("edit_csr");
		CSRModel csr = service.get(id);
		mav.addObject("csr", csr);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCSR(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	public String updateCSR(@ModelAttribute("csr") CSRModel csr) {
		service.Save(csr);
		return "/redirect:/";
	}
}
