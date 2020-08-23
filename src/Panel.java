import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



class Ates{
	
	int x;
	int y;
	public Ates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
	
	
	
	
}

public class Panel extends JPanel implements KeyListener, ActionListener{
	
	private int süre = 0;
	private int harcanan_ates = 0;
	private BufferedImage image;
	private ArrayList<Ates> atesler = new ArrayList<Ates>();
	private int atesdirY = 2;
	private int topX = 0;
	private int topdirX = 2;
	private int uzayGemisiX = 0;
	private int diruzayX = 20;

	
	
	Timer timer  = new Timer(5,this);
	public Panel() {
		
		
		setBackground(Color.black);
		
		try {
			image = ImageIO.read(new FileImageInputStream(new File("uzayGemisi.png")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.start();
		
	}
	public boolean kontrolEt() {
		
		
		for(Ates ates : atesler) {
			
			if(new Rectangle(ates.getX(), ates.getY(), 10, 20).intersects(new Rectangle(topX, 0 , 20,20))) {
				return true;
			}
			
		}
		return false;
		
		
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		süre += 5;
		g.setColor(Color.red);
		
		g.fillOval(topX, 0, 20, 20);
		
		g.drawImage(image, uzayGemisiX, 490, image.getWidth()/3, image.getHeight()/3, this);
		
		for(Ates ates : atesler) {
			if(ates.getY() < 0 ) {
				atesler.remove(ates);
			}
		}
		g.setColor(Color.blue);
		
		for(Ates ates : atesler) {
			
			g.fillRect(ates.getX(), ates.getY(), 10, 20);
			
		}
		
		if(kontrolEt()) {
			timer.stop();
			String mesaj = "Kazandýnýz\n"+
			               "Geçen süre: " + (süre / 1000.0) + " saniye" 
			               + "Harcanan ateþ: " + harcanan_ates;
			JOptionPane.showMessageDialog(this, mesaj);
			System.exit(0);
		}
		
	}
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(Ates ates : atesler) {
			ates.setY(ates.getY() - atesdirY);
		}
		
		topX += topdirX;
		
		if(topX >= 750) {
			topdirX = -topdirX;
		}
		if(topX <= 0) {
			topdirX = -topdirX;
		}
		repaint();
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//uzay mekiði hareketi için
		
				int c = e.getKeyCode(); //klavyeden geleni aldýk
				
				if(c == KeyEvent.VK_LEFT) { //sola gidiþine bakýyoruz
					
					if(uzayGemisiX <= 0) {
						uzayGemisiX = 0;
					}
					else {
						uzayGemisiX -= diruzayX;
					}
					
				}
				else if(c == KeyEvent.VK_RIGHT){
					
					if(uzayGemisiX >= 720) {
						uzayGemisiX = 720;
					}
					else {
						uzayGemisiX += diruzayX;
					}
				}
				else if(c == KeyEvent.VK_CONTROL) {
					atesler.add(new Ates(uzayGemisiX+30, 490));
					harcanan_ates++;
				}
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
		
	}

}
