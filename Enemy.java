
public class Enemy extends GameObject {
	private String type;
	private int damage;
	private int health;
	public Enemy(String type, int x, int y, int width, int height, int damage, int health) {
		super(x, y, width, height);
		setType(type);
		setDamage(damage);
		setHealth(health);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if (type == null || type.trim().length() == 0) {
			System.out.println("Tip neprijatelja ne smije biti prazan.");
		} else {
			this.type = type.trim();
		}
	}
		
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		if (damage < 0 || damage > 100) {
			System.out.println("Damage mora biti izmedju 0 i 100.");
		} else {
		this.damage = damage;
		}
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if (health < 0 || health > 100) {
			System.out.println("Health mora biti izmedju 0 i 100.");
		} else {
		this.health = health;
		}
	}
	public int getEffectiveDamage() {
	    return damage;
	}
	@Override
	public String toString() {
		return "Enemy[" + type + "] @ (" + getX() + "," +  getY() + ") " + getWidth()  + "x" + getHeight() + " DMG=" + damage+ " HP=" + health;
	}
	
	

}
