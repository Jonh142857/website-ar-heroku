package com.huy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "donhang")
public class DonHang implements Serializable {
//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dh_id", nullable = false)
    private int id;

    @NotEmpty
    @Column(name = "dh_ngaydat", nullable = true)
    private String ngaydat;

    @Column(name = "dh_ngaygiao", nullable = true)
    private String ngaygiao;
    
    @Column(name = "dh_trangthai", nullable = true)
    private String trangthai;
    
    @Column(name = "hd_ten")
    private String name;
    
    @Column(name = "hd_diachi")
    private String diachi;
    
    @Column(name = "hd_email")
    private String email;
    
    @Column(name = "hd_sdt")
    private String sdt;
    
    @Column(name = "httt_id")
    private String httt;

    public DonHang() {
        super();
    }

	public DonHang(int id, String ngaydat, String ngaygiao, String trangthai, String name, String diachi, String email,
			String sdt, String httt) {
		super();
		this.id = id;
		this.ngaydat = ngaydat;
		this.ngaygiao = ngaygiao;
		this.trangthai = trangthai;
		this.name = name;
		this.diachi = diachi;
		this.email = email;
		this.sdt = sdt;
		this.httt = httt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNgaydat() {
		return ngaydat;
	}

	public void setNgaydat(String ngaydat) {
		this.ngaydat = ngaydat;
	}

	public String getNgaygiao() {
		return ngaygiao;
	}

	public void setNgaygiao(String ngaygiao) {
		this.ngaygiao = ngaygiao;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getHttt() {
		return httt;
	}

	public void setHttt(String httt) {
		this.httt = httt;
	}
}