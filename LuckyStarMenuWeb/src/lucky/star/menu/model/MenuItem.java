package lucky.star.menu.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.NumberFormat;

public class MenuItem implements Comparable<MenuItem> {
	private int itemNo;
	private String itemDesc;
	private double itemPrice;
	private int quantity;
	
	MenuItem(int itemNo, String itemDesc, double itemPrice ) {
		this.setItemNo(itemNo);
		this.setItemDesc(itemDesc);
		this.setItemPrice(itemPrice);
		this.setQuantity(0);
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
    public String toString () {
    	ByteArrayOutputStream bs = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(bs);
    	ps.printf("%4s     %-30s", getItemNo(), getItemDesc());
    	String s = bs.toString();
    	NumberFormat nf = NumberFormat.getCurrencyInstance();
    	return s + nf.format( getItemPrice() );
    }
    
	@Override
	public int compareTo(MenuItem mi) {
		return getItemNo() - mi
				.getItemNo();
	}

}
