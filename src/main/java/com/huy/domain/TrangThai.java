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
@Table(name = "trangthai")
public class TrangThai implements Serializable {
//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tt_id", nullable = false)
    private int id;

    @NotEmpty
    @Column(name = "tt_ten", nullable = false)
    private String name;

    @Column(name = "tt_ghichu")
    private String noidung;

    public TrangThai() {
        super();
    }

	public TrangThai(int id, String name, String noidung) {
		super();
		this.id = id;
		this.name = name;
		this.noidung = noidung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

}