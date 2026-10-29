// Nikolina Božović 25/075
// Milica Djurkovic 25/065
// Tina Djukanovic 25/049
public class GameObject {
		private int x;
		private int y;
		private int width = 1;
		private int height = 1;
		public GameObject(int x, int y, int width, int height) {
			super();
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			if (width <= 0) {
				System.out.println("Sirina mora biti veca od nule.");
			} else {
				this.width = width;
			}
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			if (height <= 0) {
				System.out.println("Visina mora biti veca od nule.");
			} else {
				this.height = height;
			}
		}	
			public boolean intersects(GameObject other) {
				if(this.x < other.x + other.width
						&& this.x + this.width > other.x
						&& this.y < other.y + other.height
						&& this.y + this.height > other.y)  {
			        return true;
			    }
			    return false;
		}
			@Override
			public String toString() {
				return "GameObject @ (" + x + ", " + y + ")" + width + "x" + height;
			}
			
			
		
}
