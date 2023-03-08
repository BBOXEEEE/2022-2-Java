import java.util.Arrays;
import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * 제12장 접근제어, Object 클래스
 * Order 클래스
 * 배열 타입의 멤버변수가 있을 때 hashCode, equals, clone, toString의 구현 
 * 객체 배열: 올바르게 깊은 복사를 해야 하면 각 요소를 복제해야 함
 */

final class Item implements Cloneable{
	private String name;
	private int price;
	public Item(String name, int price) {
		this.name = Objects.requireNonNull(name);
		this.price = price;
	}
	public String name() {
		return name;
	}
	public int price() {
		return price;
	}
	public void setPrice(int price) {
		if(price>0) this.price = price;
	}
	@Override public String toString() {
		return String.format("(상품명: %s, 가격: %,d원)", name, price);
	}
	@Override public int hashCode() {
		return Objects.hash(name, price);
	}
	@Override public boolean equals(Object other) {
		if(other==null||getClass()!=other.getClass()) return false;
		if(this==other) return true;
		Item item = (Item)other;
		return name.equals(item.name) && price == item.price;
	}
	@Override public Item clone() {
		Item cloned = null;
		try {
			cloned = (Item)super.clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}

public class Order implements Cloneable{
	private int id;
	private int price = 0;
	private Item[] items = null;
	public Order(int id, Item... items) {
		if(items.length==0) throw new IllegalArgumentException();
		this.id = id;
		this.items = items;
		for(var item: this.items) price += item.price();
	}
	public Item getItem(int index) {
		if(index>=0&&index<items.length) return items[index];
		else return null;
	}
	@Override public String toString() {
		return String.format("(주문번호: %d, 총금액: %,d원, 주문목록: %s)", 
			id, price, Arrays.toString(items));
	}
	@Override public int hashCode() {
		return Objects.hash(id, price, Arrays.hashCode(items));
	}
	@Override public boolean equals(Object other) {
		if(other==null||getClass()!=other.getClass()) return false;
		if(this==other) return true;
		Order order = (Order)other;
		return id==order.id && price == order.price
			&& Arrays.equals(items, order.items);
	}
	@Override public Order clone() {
		Order cloned = null;
		try {
			cloned = (Order)super.clone();
			//cloned.items = items.clone();
			cloned.items = new Item[items.length];
			for(int i=0; i<items.length; ++i)
				cloned.items[i] = items[i].clone();
		}
		catch(CloneNotSupportedException e) {}
		return cloned;
	}
}
