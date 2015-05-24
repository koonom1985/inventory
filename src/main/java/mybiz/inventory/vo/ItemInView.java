package mybiz.inventory.vo;

// Generated 2015-2-14 12:51:33 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ItemIn view object
 */
public class ItemInView implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long itemInId;
	private String code;
	private String name;
	private BigDecimal purcahasPrice;
	private Date purchaseDatetime;
	private Integer purchaseSize;
	private String address;
	private BigDecimal telephone;
	private String isTrans;
	
	private BigDecimal sellSize;
	private BigDecimal sellPrice;
	private String sellAddress;
	private BigDecimal sellTelphone;
	
	public ItemInView() {
	}

	public ItemInView(int itemInId) {
		this.itemInId = itemInId;
	}

	public ItemInView(int itemInId, String code, String name,
			BigDecimal purcahasPrice, Date purchaseDatetime,
			Integer purchaseSize, String address, BigDecimal telephone,
			String isTrans) {
		this.itemInId = itemInId;
		this.code = code;
		this.name = name;
		this.purcahasPrice = purcahasPrice;
		this.purchaseDatetime = purchaseDatetime;
		this.purchaseSize = purchaseSize;
		this.address = address;
		this.telephone = telephone;
		this.isTrans = isTrans;
	}

	public long getItemInId() {
		return this.itemInId;
	}

	public void setItemInId(long itemInId) {
		this.itemInId = itemInId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPurcahasPrice() {
		return this.purcahasPrice;
	}

	public void setPurcahasPrice(BigDecimal purcahasPrice) {
		this.purcahasPrice = purcahasPrice;
	}

	public Date getPurchaseDatetime() {
		return this.purchaseDatetime;
	}

	public void setPurchaseDatetime(Date purchaseDatetime) {
		this.purchaseDatetime = purchaseDatetime;
	}

	public Integer getPurchaseSize() {
		return this.purchaseSize;
	}

	public void setPurchaseSize(Integer purchaseSize) {
		this.purchaseSize = purchaseSize;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getTelephone() {
		return this.telephone;
	}

	public void setTelephone(BigDecimal telephone) {
		this.telephone = telephone;
	}

	public String getIsTrans() {
		return this.isTrans;
	}

	public void setIsTrans(String isTrans) {
		this.isTrans = isTrans;
	}

	public BigDecimal getSellSize() {
		return sellSize;
	}

	public void setSellSize(BigDecimal sellSize) {
		this.sellSize = sellSize;
	}

	public String getSellAddress() {
		return sellAddress;
	}

	public void setSellAddress(String sellAddress) {
		this.sellAddress = sellAddress;
	}

	public BigDecimal getSellTelphone() {
		return sellTelphone;
	}

	public void setSellTelphone(BigDecimal sellTelphone) {
		this.sellTelphone = sellTelphone;
	}

	public BigDecimal getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}

}
