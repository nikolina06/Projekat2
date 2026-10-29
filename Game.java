import java.util.ArrayList;

public class Game {
	private Player player;
	private Enemy[] enemies = new Enemy[100];
	private int brojNeprijatelja = 0;
	private ArrayList<String> eventLog = new ArrayList<String>();
 
	public Game(Player player) {
		this.player = player;
	}
	public void addEnemy(Enemy e) {
		if (brojNeprijatelja < enemies.length) {
			enemies[brojNeprijatelja] = e;
			brojNeprijatelja++;
			eventLog.add("Dodat neprijatelj: " + e);
		} else {
			System.out.println("Nema mjesta za nove neprijatelje.");
		}
	}public ArrayList<Enemy> findByType(String query) {
		ArrayList<Enemy> pronadjeni = new ArrayList<Enemy>();
		query = query.trim().toLowerCase();
 
		for (int i = 0; i < brojNeprijatelja; i++) {
			if (enemies[i].getType().toLowerCase().contains(query)) {
				pronadjeni.add(enemies[i]);
			}
		}
		return pronadjeni;
	}
 
	public boolean checkCollisions(Player p, Enemy e) {
		return p.intersects(e);
	}
	public void decreaseHealth(Player p, Enemy e) {
		int stariHealth = p.getHealth();
		int steta = e.getEffectiveDamage();
		int noviHealth = stariHealth - steta;
 
		if (noviHealth < 0) {
			noviHealth = 0;
		}
 
		p.setHealth(noviHealth);
 
		eventLog.add("HIT: Player by " + e.getType() + " for " + steta + " -> HP " + stariHealth + " -> " + noviHealth);
	}
 
	public ArrayList<Enemy> collidingWithPlayer() {
		ArrayList<Enemy> sudari = new ArrayList<Enemy>();
 
		for (int i = 0; i < brojNeprijatelja; i++) {
			if (checkCollisions(player, enemies[i])) {
				sudari.add(enemies[i]);
			}
		}
		return sudari;
	}
 
	public void resolveCollisions() {
		ArrayList<Enemy> sudari = collidingWithPlayer();
 
		for (int i = 0; i < sudari.size(); i++) {
			decreaseHealth(player, sudari.get(i));
		}
	}
 
	public static void main(String[] args) {
		
		Player player = new Player("petar   petrovic", 10, 5, 32, 32, 85);
        Game game = new Game(player);

        MeleeEnemy e1 = new MeleeEnemy("Orc", 100, 100, 16, 16, 15, 60);
        game.addEnemy(e1);

        String podaci = "Goblin;12,5;16x16;20;boss";

        int p1 = podaci.indexOf(';');
        String type = podaci.substring(0, p1);

        int p2 = podaci.indexOf(',', p1 + 1);
        int x = Integer.parseInt(podaci.substring(p1 + 1, p2));

        int p3 = podaci.indexOf(';', p2 + 1);
        int y = Integer.parseInt(podaci.substring(p2 + 1, p3));

        int p4 = podaci.indexOf('x', p3 + 1);
        int width = Integer.parseInt(podaci.substring(p3 + 1, p4));

        int p5 = podaci.indexOf(';', p4 + 1);
        int height = Integer.parseInt(podaci.substring(p4 + 1, p5));

        int p6 = podaci.indexOf(';', p5 + 1);
        int damage = Integer.parseInt(podaci.substring(p5 + 1, p6));

        String vrsta = podaci.substring(p6 + 1);

        Enemy e2;

        if (vrsta.equalsIgnoreCase("boss")) {
            e2 = new BossEnemy(type, x, y, width, height, damage, 60);
        } else {
            e2 = new MeleeEnemy(type, x, y, width, height, damage, 60);
        }

        game.addEnemy(e2);

        System.out.println("Igrac:");
        System.out.println(player);

        System.out.println("\nSvi neprijatelji:");

        for (int i = 0; i < game.brojNeprijatelja; i++) {
            System.out.println(game.enemies[i]);
        }

        System.out.println("\nNeprijatelji koji sadrze gob:");

        ArrayList<Enemy> pronadjeni = game.findByType("gob");

        for (int i = 0; i < pronadjeni.size(); i++) {
            System.out.println(pronadjeni.get(i));
        }

        System.out.println("\nNeprijatelji koji se sudaraju sa igracem:");

        ArrayList<Enemy> sudari = game.collidingWithPlayer();

        if (sudari.size() == 0) {
            System.out.println("Nema sudara.");
        } else {
            for (int i = 0; i < sudari.size(); i++) {
                System.out.println(sudari.get(i));
            }
        }

        System.out.println("\nZdravlje prije sudara: " + player.getHealth());

        game.resolveCollisions();

        System.out.println("Zdravlje poslije sudara: " + player.getHealth());

        System.out.println("\nDnevnik dogadjaja:");

        for (int i = 0; i < game.eventLog.size(); i++) {
            System.out.println(game.eventLog.get(i));
        }

	}

}
