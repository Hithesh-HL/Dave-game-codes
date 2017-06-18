

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
 
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Dave extends GraphicsProgram {
	
	/** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 1138;
    public static final int APPLICATION_HEIGHT = 750;
 
    /** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;
    
    private static final int BW = 58;
    private static final int BH = 18;
    private static final int W = 60;
    
	
	public void run() {
		int game = 0;
		setBackground(Color.BLACK);
		setUp();
		getDave();
		addKeyListeners();
		while(game < 13) {
			check(d.getX(),d.getY());
			if(dtb == 1) {
				GRect bl = new GRect(d.getX(),d.getY(),W,((3*BH)+12));
				bl.setFilled(true);
				add(bl);
				d.sendToFront();
				game++;
			}
		}
		dr.setImage("open.jpg");
		dr.setSize(W,((3*BH)+12));
	
		while(true) {
			
			if((d.getX() == dr.getX())&&(d.getY() == dr.getY())){
				go=0;
				GLabel win = new GLabel("SAAKU BIDU GURU");
				win.setLocation((WIDTH-win.getWidth())/2-120,(getHeight()-win.getAscent())/2-36);
				win.setFont("TIMES NEW ROMAN-46");
				win.setColor(Color.MAGENTA);
		
				add(win);
			}
		}
	}

	
	
	private void setUp() {
	
		for(int i = 0; i<19; i++) {
			draw(i*W,0);
		}
		for(int i = 0; i<19; i++) {
			draw(i*W,10*((3*BH)+12));
		}
		
		for(int i = 0; i<19; i++) {
			draw(i*W,9*((3*BH)+12));
		}
		
		for(int i = 0; i<19; i++) {
			draw(i*W,11*((3*BH)+12));
		}
		
		for(int i = 1; i<12; i++) {
			draw(0,i*((3*BH)+12));
		}
		
		for(int i = 1; i<12; i++) {
			draw((19*W)-BW-2,i*((3*BH)+12));
		}
		
		for(int i = 0; i<5;i++) {
			draw((4*i*(W))+W,5*((3*BH)+12));
			poly((4*i*(W))+(3*W/2),5*((3*BH)+12)-24);
		}
		
		for(int i = 1; i<5;i++) {
			draw((4*i*(W))-W,3*((3*BH)+12));
			poly((4*i*(W))-(W/2),3*((3*BH)+12)-24);
		}
		
		for(int i = 0; i<4;i++) {
			draw(4*(W)+(i*(W)),7*((3*BH)+12));
		}
		
		for(int i = 0; i<6;i++) {
			draw(11*(W)+(i*(W)),7*((3*BH)+12));
		}
		
		draw(11*(W),8*((3*BH)+12));
		
		ora(W+13,1*((3*BH)+12)+13);
		ora(W+13,6*((3*BH)+12)+13);
		ora(14*(W+13),1*((3*BH)+12)+13);
		ora(9*(W+15),6*((3*BH)+12)+13);

		GRect p = new GRect(W,8*((3*BH)+12),W-15,((3*BH)+12));
		p.setColor(Color.GRAY);
		p.setFilled(true);
		add(p);
		
		GOval m = new GOval(2*W-30,8*((3*BH)+12)-2,30,((3*BH)+16));
		m.setColor(Color.GRAY);
		m.setFillColor(Color.BLACK);
		m.setFilled(true);
		add(m);
		
		dr = new GImage("doorclosed.jpg");
		dr.setLocation(12*W,8*((3*BH)+12));
		dr.setSize(W,((3*BH)+12));
		add(dr);
	}
	
	private void draw(double x,double y) {
		brick = new GRect(x,y,(BW/3)-2,BH);
		brick.setFilled(true);
		brick.setColor(Color.RED);
		add(brick);
		
		brick = new GRect(x+(BW/3)+2,y,(2*BW)/3,BH);
		brick.setFilled(true);
		brick.setColor(Color.RED);
		add(brick);
		
		brick = new GRect(x,y+BH+4,((2*BW)/3)-2,BH);
		brick.setFilled(true);
		brick.setColor(Color.RED);
		add(brick);
		
		brick = new GRect(x+2+(2*BW)/3,y+4+BH,BW/3,BH);
		brick.setFilled(true);
		brick.setColor(Color.RED);
		add(brick);
		
		brick = new GRect(x,y+BH+BH+8,(BW/2)-2,BH);
		brick.setFilled(true);
		brick.setColor(Color.RED);
		add(brick);
		
		brick = new GRect(x+(BW/2)+2,y+8+BH+BH,BW/2-1,BH);
		brick.setFilled(true);
		brick.setColor(Color.RED);
		add(brick);
		
	}
	private void poly(double x,double y) {
		GPolygon gp = new GPolygon();
		gp.addVertex(0, 20);
		gp.addVertex(-20, 0);
		gp.addVertex(0, -20);
		gp.addVertex(20, 0);
		gp.setColor(Color.CYAN);
		gp.setFilled(true);
		add(gp,x,y);
	}
	
	private void ora(double x,double y) {
		GOval o = new GOval(x,y,34,34);
		o.setColor(Color.BLUE);
		o.setFilled(true);
		add(o);
	}
	
	private void getDave() {
		d = new GImage("dave.jpg");
		d.setLocation(2*W,8*((3*BH)+12));
		d.setSize(W,((3*BH)+12));
		add(d);
	}
	private GRect brick;
	private int flag = 1;
	private GImage d;
	
	public void keyPressed(KeyEvent e) {
		if((flag == 1) && (go == 1)) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			safe(d.getX()+W,d.getY());
			d.setImage("dave.jpg");
			d.setSize(W,((3*BH)+12));
			if((rt == 1)&&(mtb == 0)){
			d.move(W,0);
			}
			rt = 1;
			lt = 0;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			safe(d.getX()-W,d.getY());
			d.setImage("idave.jpg");
			d.setSize(W,((3*BH)+12));
			if((lt == 1)&&(mtb == 0)){
			d.move(-W,0);
			}
			lt = 1;
			rt = 0;
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			safe(d.getX(),d.getY()-((3*BH)+12));
			if(mtb == 0) {
				d.move(0, -((3*BH)+12));
			}
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			safe(d.getX(),d.getY()+((3*BH)+12));
			if(mtb == 0) {
				d.move(0,((3*BH)+12));
			}
		}
		pause(50);
		flag = 0;
		}
	}
	
	
	
	private int rt = 1, lt = 0;
	private int f = 0;
	private GImage dr;
	public void keyReleased(KeyEvent e) {
		flag = 1;
	}
	
	
	private void safe(double x,double y) {
		mtb = 0;
		for(int i = 0; i<19; i++) {
			if((x == i*W) && (y == 0))	mtb = 1;
		}
		for(int i = 0; i<19; i++) {
			if((x ==i*W) && (y == 10*((3*BH)+12))) mtb = 1;
				
		}
		
		for(int i = 0; i<19; i++) {
			if((x ==i*W)&&(y==9*((3*BH)+12)))	mtb = 1;
		}
		
		for(int i = 0; i<19; i++) {
			if((x ==i*W)&&(y==11*((3*BH)+12)))	mtb = 1;
		}
		
		for(int i = 1; i<12; i++) {
			if((x ==0)&&(y==i*((3*BH)+12)))	mtb = 1;
		}
		
		for(int i = 1; i<12; i++) {
			if((x ==(19*W)-BW-2)&&(y==i*((3*BH)+12)))	mtb = 1;
		}
		
		for(int i = 0; i<5;i++) {
			if((x ==(4*i*(W))+W)&&(y==5*((3*BH)+12)))	mtb = 1;
			
		}
		
		for(int i = 1; i<5;i++) {
			if((x ==(4*i*(W))-W)&&(y==3*((3*BH)+12)))	mtb = 1;
			
		}
		
		for(int i = 0; i<4;i++) {
			if((x ==4*(W)+(i*(W)))&&(y==7*((3*BH)+12)))	mtb = 1;
		}
		
		for(int i = 0; i<6;i++) {
			if((x ==11*(W)+(i*(W)))&&(y==7*((3*BH)+12)))	mtb = 1;
		}
		
		if((x ==11*(W))&&(y==8*((3*BH)+12)))	mtb = 1;
		
		if((x ==1*(W))&&(y==8*((3*BH)+12)))	mtb = 1;
	}
	
	private int mtb = 0,go=1;
	
	private void check(double x,double y) {
		dtb = 0;
		if((x == W)&&(y == ((3*BH)+12))&&(a1==1))	{a1 = 0;dtb = 1;}
		if((x == 17*W)&&(y == ((3*BH)+12))&&(a2==1))	{a2 = 0;dtb = 1;}
		if((x == 3*W)&&(y == 2*((3*BH)+12))&&(a3==1)){a3 = 0;	dtb = 1;}
		if((x == 7*W)&&(y == 2*((3*BH)+12))&&(a4==1)){a4 = 0;	dtb = 1;}
		if((x == 11*W)&&(y == 2*((3*BH)+12))&&(a5==1)){a5 = 0;	dtb = 1;}
		if((x == 15*W)&&(y == 2*((3*BH)+12))&&(a6==1)){a6 = 0;	dtb = 1;}
		if((x == W)&&(y == 4*((3*BH)+12))&&(a7==1))	{a7 = 0;dtb = 1;}
		if((x == 5*W)&&(y == 4*((3*BH)+12))&&(a8==1)){a8 = 0;	dtb = 1;}
		if((x == 9*W)&&(y == 4*((3*BH)+12))&&(a9==1)){a9 = 0;	dtb = 1;}
		if((x == 13*W)&&(y == 4*((3*BH)+12))&&(a10==1)){a10 = 0;	dtb = 1;}
		if((x == 17*W)&&(y == 4*((3*BH)+12))&&(a11==1)){a11 = 0;	dtb = 1;}
		if((x == 1*W)&&(y == 6*((3*BH)+12))&&(a12==1)){a12 = 0;	dtb = 1;}
		if((x == 11*W)&&(y == 6*((3*BH)+12))&&(a13==1)){a13 = 0;	dtb = 1;}
	}
	private int dtb = 0,a1=1,a2=1,a3=1,a4=1,a5=1,a6=1,a7=1,a8=1,a9=1,a10=1,a11=1,a12=1,a13=1;
}


