import javax.swing.JFrame;

public class OyunEkraný extends JFrame{
	
	
	public OyunEkraný() {

		super("Uzay Oyunu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		setFocusable(false);
		
	}
	
	
	public static void main(String[] args) {
		OyunEkraný ekran = new OyunEkraný();
		Panel p = new Panel();
		p.requestFocus();
		p.addKeyListener(p);
		p.setFocusable(true);
		p.setFocusTraversalKeysEnabled(false);
		ekran.add(p);
		ekran.setVisible(true);
	
	}

}
