
public class MeleeEnemy extends Enemy {

	public MeleeEnemy(String type, int x, int y, int width, int height, int damage, int health) {
		super(type, x, y, width, height, damage, health);
	}

	@Override
	public String toString() {
        return "MeleeEnemy[" + getType() + "] @ (" + getX() + "," + getY() + ") " + getWidth() + "x" + getHeight()
                + " DMG=" + getDamage() + " HP=" + getHealth();
	}


}
