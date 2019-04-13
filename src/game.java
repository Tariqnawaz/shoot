import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Image;
public class game extends JFrame{
int x,y;
int keyCode;
private Image i;
private Graphics gp;
Font f =new Font("Arial", Font.ITALIC | Font.BOLD  ,20);
	public class AL extends KeyAdapter{
	public void keyPressed(KeyEvent e){
		keyCode = e.getKeyCode();
		if (keyCode == e.VK_LEFT){
			if ( x <= 0)
			x = 0;
			else
			x += -5;
			}
			if (keyCode == e.VK_RIGHT){
				if(x <= 230)
				x = 230;
				else
				x += +5;
				}
				if (keyCode == e.VK_UP){
					if(y <= 20)
					y = 20;
					else
					y += -5;
					}if (keyCode == e.VK_DOWN){
						if(y <= 230)
						y =230;
						else
			            y += +5;
			}
}
	public void KeyReleased(KeyEvent e){
		//int keyCode1=e.getKeyCode();
		if(keyCode==e.VK_LEFT){
			if(x == -5)
			x--;
			}
			if(keyCode==e.VK_RIGHT){
						x++;
			}
			if(keyCode==e.VK_UP){
						y--;
			}
			if(keyCode==e.VK_DOWN){
						y++;
			}
		}
	}

   game(){
	addKeyListener(new AL());
	setTitle("Java Games");
	setSize(350,350);
	setResizable(false);
	setVisible(true);
	setBackground(Color.CYAN);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	x =150;
	y=150;
}
public void paint(Graphics g){
    i = createImage(getWidth() , getHeight());
    gp =i.getGraphics();
    paintComponent(gp);
    g.drawImage(i,0,0,this);
	}
public void paintComponent(Graphics g){
	g.setFont(f);
	g.setColor(Color.MAGENTA);
	g.drawString("Try This Out...!!!!",50,50);
	g.setColor(Color.RED);
g.fillOval(x,y,15,15);
repaint();

}
public static void main(String args[]){
new game();
}

}