
public class Player extends GameObject {
private String name;
private int health;
public Player(String name, int x, int y, int width, int height, int health) {
	super(x, y, width, height);
	setName(name);
	setHealth(health);
}
public String getName() {
	return name;
}
public void setName(String name) {
    if (name == null || name.trim().length() == 0) {
        System.out.println("Ime ne smije biti prazno.");
        return;
    }
    String[] rijeci = name.trim().split("\\s+");
    String novoIme = "";
    for (int i = 0; i < rijeci.length; i++) {
        String r = rijeci[i];
        novoIme = novoIme + Character.toUpperCase(r.charAt(0)) + r.substring(1).toLowerCase();
        if (i < rijeci.length - 1) {
            novoIme = novoIme + " ";
        }
    }
    this.name = novoIme;
}

public int getHealth() {
	return health;
}
public void setHealth(int health) {
	 if (health < 0 || health > 100) {
	      System.out.println("Health mora biti između 0 i 100.");
		 }else {  		
		this.health=health;
		 }
	}
@Override
public String toString() {
	return "Player[" + name + "] @ (" + getX() + "," + getY() + ") " + getWidth() + "x" + getHeight() + " HP=" +  health;
}
	


}
