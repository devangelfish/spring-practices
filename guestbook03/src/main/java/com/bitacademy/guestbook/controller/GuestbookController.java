package com.bitacademy.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.guestbook.repository.GuestbookRepository;
import com.bitacademy.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository repository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = repository.findAll();
		model.addAttribute("list", list);
		model.addAttribute("line", "\r\n");
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String index(GuestbookVo vo) {
		repository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		repository.delete(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable Long no, Model model) {
		model.addAttribute("no", no);
		return "delete";
	}
}
