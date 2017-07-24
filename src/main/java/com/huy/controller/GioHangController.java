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

import com.huy.domain.GioHang;
import com.huy.service.GioHangService;
import com.huy.domain.SanPham;
import com.huy.service.SanPhamService;

@Controller
public class GioHangController {
	
	@Autowired
	private GioHangService giohangService;
	
	@Autowired
	private SanPhamService sanphamService;

	@GetMapping("/giohang")
	public String index(Model model) {
		model.addAttribute("giohangs", giohangService.findAll());
		model.addAttribute("sanphams",sanphamService.findAll());
		return "giohang_list";
	}

	@GetMapping("/giohang/create")
	public String create(Model model) {
		model.addAttribute("giohang", new GioHang());
		model.addAttribute("sanphams",sanphamService.findAll());
		return "giohang_form";
	}
	
	@GetMapping("/")
	public String trangchu(Model model) {
		model.addAttribute("giohang", new GioHang());
		model.addAttribute("sanphams",sanphamService.search("Bàn"));
		return "giohang_form";
	}
	
	@GetMapping("/ptban")
	public String ptban(Model model) {
		model.addAttribute("giohang", new GioHang());
		model.addAttribute("sanphams",sanphamService.search("Bàn"));
		return "giohang_form";
	}
	
	@GetMapping("/ptghe")
	public String ptghe(Model model) {
		model.addAttribute("giohang", new GioHang());
		model.addAttribute("sanphams",sanphamService.search("Ghế"));
		return "giohang_form";
	}
	
	@GetMapping("/ptgiuong")
	public String ptgiuong(Model model) {
		model.addAttribute("giohang", new GioHang());
		model.addAttribute("sanphams",sanphamService.search("Giường"));
		return "giohang_form";
	}

	@GetMapping("/giohang/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("giohang", giohangService.findOne(id));
		model.addAttribute("sanphams",sanphamService.findAll());
		return "giohang_form";
	}

	@PostMapping("/giohang/save")
	public String save(@Valid GioHang giohang, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "giohang_form";
		}
		giohangService.save(giohang);
		redirect.addFlashAttribute("success", "Đã lưu giỏ hàng");
		return "redirect:/giohang";
	}

	@GetMapping("/giohang/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		giohangService.delete(id);
		redirect.addFlashAttribute("success", "Đã xoá giỏ hàng");
		return "redirect:/giohang";
	}

	@GetMapping("/giohang/search")
	public String search(@RequestParam("q") String q, Model model) {
		if (q.equals("")) {
			return "redirect:/giohang";
		}

		model.addAttribute("giohangs", giohangService.search(q));
		model.addAttribute("sanphams",sanphamService.findAll());
		return "giohang_list";
	}

}
