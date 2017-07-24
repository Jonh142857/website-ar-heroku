package com.huy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.huy.domain.TrangThai;
import com.huy.service.TrangThaiService;

@Controller
public class TrangThaiController {
	
	@Autowired
	private TrangThaiService trangthaiService;

    @GetMapping("/trangthai")
    public String index(Model model) {
        model.addAttribute("trangthais", trangthaiService.findAll());
        return "trangthai_list";
    }
    
    @GetMapping("/trangthai/create")
    public String create(Model model) {
        model.addAttribute("trangthai", new TrangThai());
        return "trangthai_form";
    }
    
    @GetMapping("/trangthai/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("trangthai", trangthaiService.findOne(id));
        return "trangthai_form";
    }
    
    @PostMapping("/trangthai/save")
    public String save(@Valid TrangThai trangthai, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "trangthai_form";
        }
        trangthaiService.save(trangthai);
        redirect.addFlashAttribute("success", "Đã lưu trạng thái");
        return "redirect:/trangthai";
    }
    
    @GetMapping("/trangthai/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
    	trangthaiService.delete(id);
        redirect.addFlashAttribute("success", "Đã xoá trạng thái");
        return "redirect:/trangthai";
     }
    
    @GetMapping("/trangthai/search")
    public String search(@RequestParam("q") String q, Model model) {
        if (q.equals("")) {
            return "redirect:/trangthai";
        }
        
        model.addAttribute("trangthais", trangthaiService.search(q));
        return "trangthai_list";
    }

}
