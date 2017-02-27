package com.emc.ps.appmod.tnt.domain.utilities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookSearch implements Serializable {

	private static final long serialVersionUID = -5839461571479169912L;

	private String name;

	private String author;

	private String isbn;

	private String url;

	private BigDecimal price;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fromPurchaseDate;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date toPurchaseDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getFromPurchaseDate() {
		return fromPurchaseDate;
	}

	public void setFromPurchaseDate(Date fromPurchaseDate) {
		this.fromPurchaseDate = fromPurchaseDate;
	}

	public Date getToPurchaseDate() {
		return toPurchaseDate;
	}

	public void setToPurchaseDate(Date toPurchaseDate) {
		this.toPurchaseDate = toPurchaseDate;
	}

}
