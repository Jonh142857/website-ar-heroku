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
@Table(name = "giohang")
public class GioHang implements Serializable {
//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gh_id", nullable = false)
    private int id;

    @Column(name = "sp_id")
    private int idsanpham;

    public GioHang() {
        super();
    }

	public GioHang(int id, int idsanpham) {
		super();
		this.id = id;
		this.idsanpham = idsanpham;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdsanpham() {
		return idsanpham;
	}

	public void setIdsanpham(int idsanpham) {
		this.idsanpham = idsanpham;
	}

}