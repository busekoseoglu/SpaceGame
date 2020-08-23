import javax.swing.JFrame;

public class OyunEkranı extends JFrame{
	
	
	public OyunEkranı() {

		super("Uzay Oyunu");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		setFocusable(false);
		
	}
	
	
	public static void main(String[] args) {
		OyunEkranı ekran = new OyunEkranı();
		Panel p = new Panel();
		p.requestFocus();
		p.addKeyListener(p);
		p.setFocusable(true);
		p.setFocusTraversalKeysEnabled(false);
		ekran.add(p);
		ekran.setVisible(true);
	
	}

}
