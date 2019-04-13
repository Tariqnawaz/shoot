import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;
public class shooting extends JFrame implements Runnable{
int x,y,bx,by,xDirection;
int keyCode;
private Image i;
private Graphics gp;
boolean readyToFire , shot = false;
Rectangle bullet;


	public void run(){
		try{
			while(true){
							shoot();
							move();
							Thread.sleep(5);
                        	}
			}
			catch(Exception e)
				{
				System.out.println("Error");
				}
		}
	public void move(){
		x +=xDirection;

		if(x <= 0)
		x=0;
		if( x >= 360)
		x=360;

		}
		public void setXDirection(int xDir){
			xDirection = xDir;
			}

	public class AL extends KeyAdapter{
	public void keyPressed(KeyEvent e){
		keyCode = e.getKeyCode();
		if (keyCode == e.VK_LEFT){
			setXDirection(-1);
			}
			if (keyCode == e.VK_RIGHT){
				setXDirection(+1);
				}
				if (keyCode == e.VK_SPACE){
					if (bullet == null)
					readyToFire = true;
					if(readyToFire){
						//x+18,y-7
						bx = x+18;
						by = y-7;
						bullet = new Rectangle(bx,by,3,5);
						shot = true;
						}
					}
}
	public void KeyReleased(KeyEvent e){
		//int keyCode1=e.getKeyCode();
		if(keyCode==e.VK_LEFT){
			setXDirection(0);
			}
			if(keyCode==e.VK_RIGHT){
			setXDirection(0);
			}
			if(keyCode==e.VK_SPACE){
			readyToFire = false;
			if(bullet.y <= -5){
				bullet = new Rectangle(0,0,0,0);
				shot = false;
				readyToFire = true;
				}
			}
		}
	}

shooting(){
	//loading images
	//ImageIcon ii =new ImageIcon("E:/aaaaa/images/ficon1new.jpg");
	//face =ii.getImage();
	// games properties
	addKeyListener(new AL());
	setTitle("Java Shooting Games");
	setSize(400,300);
	setResizable(false);
	setVisible(true);
	setBackground(Color.CYAN);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	x =300;
	y=275;
}
public void paint(Graphics g){
    i = createImage(getWidth() , getHeight());
    gp =i.getGraphics();
    paintComponent(gp);
    g.drawImage(i,0,0,this);
	}
public void paintComponent(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(x,y,40,10);
	g.fillRect(x+18,y-7,4,7);
	if(shot){
		g.setColor(Color.BLACK);
		g.fillRect(bullet.x,bullet.y,bullet.width,bullet.height);
		}
	//g.drawString("Try This Out...!!!!",50,50);

repaint();

}
public void shoot(){
	if(shot)
	bullet.y--;
	}
public static void main(String args[]){
shooting jg = new shooting();
Thread t=new Thread(jg);
t.start();
}

}