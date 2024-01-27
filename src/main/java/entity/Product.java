package entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private int id;
	private String name;
	private int price;
	private String imgName;
	private boolean isNew;
	private int quantity;
	private String description;
    

	public Product(int id, String name, int price, String imgName, boolean isNew) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgName = imgName;
		this.isNew = isNew;
	}
	

	public Product(int id, String name, int price, String imgName, int quantity, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgName = imgName;
		this.quantity = quantity;
		this.description = description;
	}

	public boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
	@Override
	public int hashCode() {
		int hash=3;
		hash=32*hash+id;
		return hash;
	}
	public boolean equals(Object obj) {
		Product product=(Product) obj;
		return this.id==product.getId();
	}

}
