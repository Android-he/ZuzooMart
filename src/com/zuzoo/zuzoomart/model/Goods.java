package com.zuzoo.zuzoomart.model;

public class Goods {
	private String searchword;
	private Image image;
	private String unit;
	private String showTag;
	private String name;
	private String price;
	private String deductPercent;
	private String brand;
	private String capacitys;
	private String kind;
	private String version;
	private String isOnShelf;
	private String leaseTerm;
	private String totalSales;
	private String stock;
	private String leaseTerms;
	private String objectId;
	private String createdAt;
	private String updatedAt;
	public Goods() {
		super();
	}
	public Goods(String searchword, Image image, String unit, String showTag, String name, String price,
			String deductPercent, String brand, String capacitys, String kind, String version, String isOnShelf,
			String leaseTerm, String totalSales, String stock, String leaseTerms, String objectId, String createdAt,
			String updatedAt) {
		super();
		this.searchword = searchword;
		this.image = image;
		this.unit = unit;
		this.showTag = showTag;
		this.name = name;
		this.price = price;
		this.deductPercent = deductPercent;
		this.brand = brand;
		this.capacitys = capacitys;
		this.kind = kind;
		this.version = version;
		this.isOnShelf = isOnShelf;
		this.leaseTerm = leaseTerm;
		this.totalSales = totalSales;
		this.stock = stock;
		this.leaseTerms = leaseTerms;
		this.objectId = objectId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getShowTag() {
		return showTag;
	}
	public void setShowTag(String showTag) {
		this.showTag = showTag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDeductPercent() {
		return deductPercent;
	}
	public void setDeductPercent(String deductPercent) {
		this.deductPercent = deductPercent;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCapacitys() {
		return capacitys;
	}
	public void setCapacitys(String capacitys) {
		this.capacitys = capacitys;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getIsOnShelf() {
		return isOnShelf;
	}
	public void setIsOnShelf(String isOnShelf) {
		this.isOnShelf = isOnShelf;
	}
	public String getLeaseTerm() {
		return leaseTerm;
	}
	public void setLeaseTerm(String leaseTerm) {
		this.leaseTerm = leaseTerm;
	}
	public String getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(String totalSales) {
		this.totalSales = totalSales;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getLeaseTerms() {
		return leaseTerms;
	}
	public void setLeaseTerms(String leaseTerms) {
		this.leaseTerms = leaseTerms;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
