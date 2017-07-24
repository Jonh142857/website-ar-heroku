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

import com.huy.domain.SanPham;
import com.huy.service.SanPhamService;
import com.huy.domain.LoaiSanPham;
import com.huy.service.LoaiSanPhamService;
import com.huy.domain.NhaSanXuat;
import com.huy.service.NhaSanXuatService;
import com.huy.domain.KhuyenMai;
import com.huy.service.KhuyenMaiService;

@Controller
public class SanPhamController {
	
	@Autowired
	private SanPhamService sanphamService;
	
	@Autowired
	private LoaiSanPhamService loaisanphamService;
	
	@Autowired
	private NhaSanXuatService nhasanxuatService;
	
	@Autowired
	private KhuyenMaiService khuyenmaiService;
	
    @GetMapping("/sanpham")
    public String sanpham(Model model) {
        model.addAttribute("sanphams", sanphamService.findAll());
        model.addAttribute("loaisanphams", loaisanphamService.findAll());
        model.addAttribute("nhasanxuats", nhasanxuatService.findAll());
        model.addAttribute("khuyenmais", khuyenmaiService.findAll());
        return "sanpham_list";
    }
    
    @GetMapping("/sanpham/ban")
    public String sanphamban(Model model) {
        model.addAttribute("sanphams", sanphamService.search("Bàn"));
        model.addAttribute("loaisanphams", loaisanphamService.findAll());
        model.addAttribute("nhasanxuats", nhasanxuatService.findAll());
        model.addAttribute("khuyenmais", khuyenmaiService.findAll());
        return "sanpham_list";
    }
    
    @GetMapping("/sanpham/ghe")
    public String sanphamghe(Model model) {
        model.addAttribute("sanphams", sanphamService.search("Ghế"));
        model.addAttribute("loaisanphams", loaisanphamService.findAll());
        model.addAttribute("nhasanxuats", nhasanxuatService.findAll());
        model.addAttribute("khuyenmais", khuyenmaiService.findAll());
        return "sanpham_list";
    }
    
    @GetMapping("/sanpham/giuong")
    public String sanphamgiuong(Model model) {
        model.addAttribute("sanphams", sanphamService.search("Giường"));
        model.addAttribute("loaisanphams", loaisanphamService.findAll());
        model.addAttribute("nhasanxuats", nhasanxuatService.findAll());
        model.addAttribute("khuyenmais", khuyenmaiService.findAll());
        return "sanpham_list";
    }
    
    @GetMapping("/sanpham/create")
    public String create(Model model) {
        model.addAttribute("sanpham", new SanPham());
        model.addAttribute("loaisanphams", loaisanphamService.findAll());
        model.addAttribute("nhasanxuats", nhasanxuatService.findAll());
        model.addAttribute("khuyenmais", khuyenmaiService.findAll());
        return "sanpham_form";
    }
    
    @GetMapping("/sanpham/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("sanpham", sanphamService.findOne(id));
        model.addAttribute("loaisanphams", loaisanphamService.findAll());
        model.addAttribute("nhasanxuats", nhasanxuatService.findAll());
        model.addAttribute("khuyenmais", khuyenmaiService.findAll());
        return "sanpham_form";
    }
    
    @PostMapping("/sanpham/save")
    public String save(@Valid SanPham sanpham, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "sanpham_form";
        }
        sanphamService.save(sanpham);
        redirect.addFlashAttribute("success", "Đã lưu sản phẩm");
        return "redirect:/sanpham";
    }
    
    @GetMapping("/sanpham/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
    	sanphamService.delete(id);
        redirect.addFlashAttribute("success", "Đã xoá sản phẩm");
        return "redirect:/sanpham";
     }
    
    @GetMapping("/sanpham/search")
    public String search(@RequestParam("q") String q, Model model) {
        if (q.equals("")) {
            return "redirect:/sanpham";
        }
        
        model.addAttribute("sanphams", sanphamService.search(q));
        model.addAttribute("loaisanphams", loaisanphamService.findAll());
        model.addAttribute("nhasanxuats", nhasanxuatService.findAll());
        model.addAttribute("khuyenmais", khuyenmaiService.findAll());
        return "sanpham_list";
    }

}
