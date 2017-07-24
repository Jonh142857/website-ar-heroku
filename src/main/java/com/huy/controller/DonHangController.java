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

import com.huy.domain.DonHang;
import com.huy.service.DonHangService;
import com.huy.domain.HinhThucThanhToan;
import com.huy.service.HinhThucThanhToanService;
import com.huy.domain.TrangThai;
import com.huy.service.TrangThaiService;

@Controller
public class DonHangController {
	
	@Autowired
	private DonHangService donhangService;
	
	@Autowired
	private HinhThucThanhToanService hinhthucthanhtoanService;
	
	@Autowired
	private TrangThaiService trangthaiService;

	@GetMapping("/donhang")
	public String index(Model model) {
		model.addAttribute("donhangs", donhangService.findAll());
		model.addAttribute("hinhthucthanhtoans", hinhthucthanhtoanService.findAll());
		model.addAttribute("trangthais", trangthaiService.findAll());
		return "donhang_list";
	}

	@GetMapping("/donhang/create")
	public String create(Model model) {
		model.addAttribute("donhang", new DonHang());
		model.addAttribute("hinhthucthanhtoans", hinhthucthanhtoanService.findAll());
		model.addAttribute("trangthais", trangthaiService.findAll());
		return "donhang_form";
	}
	
	@GetMapping("/dathang")
	public String dathang(Model model) {
		model.addAttribute("donhang", new DonHang());
		model.addAttribute("hinhthucthanhtoans", hinhthucthanhtoanService.findAll());
		model.addAttribute("trangthais", trangthaiService.findAll());
		return "dathang_form";
	}

	@GetMapping("/donhang/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("donhang", donhangService.findOne(id));
		model.addAttribute("hinhthucthanhtoans", hinhthucthanhtoanService.findAll());
		model.addAttribute("trangthais", trangthaiService.findAll());
		return "donhang_form";
	}

	@PostMapping("/donhang/save")
	public String save(@Valid DonHang donhang, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "donhang_form";
		}
		donhangService.save(donhang);
		redirect.addFlashAttribute("success", "Đã lưu đơn hàng");
		return "redirect:/donhang";
	}
	
	@PostMapping("/dathang/save")
	public String dathang(@Valid DonHang donhang, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "dathang_form";
		}
		donhangService.save(donhang);
		return "redirect:/dathang";
	}

	@GetMapping("/donhang/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		donhangService.delete(id);
		redirect.addFlashAttribute("success", "Đã xoá đơn hàng");
		return "redirect:/donhang";
	}

	@GetMapping("/donhang/search")
	public String search(@RequestParam("q") String q, Model model) {
		if (q.equals("")) {
			return "redirect:/donhang";
		}

		model.addAttribute("donhangs", donhangService.search(q));
		model.addAttribute("hinhthucthanhtoans", hinhthucthanhtoanService.findAll());
		model.addAttribute("trangthais", trangthaiService.findAll());
		return "donhang_list";
	}

}
