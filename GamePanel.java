package project;

import java.awt.*; // Graphics,color
import java.awt.event.*;// ActionListener,KeyListener
import javax.swing.*;//Timer
import java.util.Random;
import javax.swing.JPanel;
// Jpanel where gaming is drawing
// ActionListener is timer which is used for game update
public class GamePanel extends JPanel implements ActionListener{

	static final int SCREEN_WIDTH =600;
	static final int SCREEN_HEIGHT =600;
	static final int UNIT_SIZE =20;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY=92;// snake speed
	final int x[] = new int[GAME_UNITS];// part of snake position in x and y
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten = 0;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer; 
	Random random;
	
	// Constructor
	GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);// Keyboard input,this indicate present GamePanel
		this.addKeyListener(new MykeyAdapter());//snake move
		starGame();
	}
	public void starGame() {
		newApple();
		running = true;
		timer = new Timer (DELAY,this);
		timer.start();
		
	}
	// When JPanel is refreshing it is calling
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);// Drawing entire game
		
		
	}
	public void draw(Graphics g) {
		
		if(running) {
			// Draw small box
		for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE,0, i*UNIT_SIZE,SCREEN_HEIGHT);
			g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH, i*UNIT_SIZE);
		}
		// draw apple
		g.setColor(Color.red);
		g.fillOval(appleX, appleY,UNIT_SIZE , UNIT_SIZE); // fillOval is graphics method used for draw circle
		// Draw Snake
		for(int i=0; i< bodyParts;i++) {
			if(i==0) {                     // Head color and size
				g.setColor(Color.green);
				g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
			}
			else {  // body
				g.setColor(new Color(45,180,0));
				g.setColor(new Color(random.nextInt(255),(random.nextInt(255)),(random.nextInt(255))));
				//g.setColor(Color.red);
				g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
			}
		}
		// Draw Score box
		g.setColor(Color.red);
    	g.setFont(new Font("Ink free",Font.BOLD,40));
    	FontMetrics metrices = getFontMetrics(g.getFont());
    	g.drawString("Score : "+applesEaten,(SCREEN_WIDTH - metrices.stringWidth("Score: "+applesEaten))/2 , g.getFont().getSize());
	}
		else {
			gameOver(g);
		}
	}
	
	
	public void newApple() {
		
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	public void move() {
		for(int i= bodyParts;i>0;i--) {
			x[i] = x[i-1]; //Each body part moves to the position of the part before it
			y[i] = y[i-1];
		}
		switch(direction) {  //"সাপের মাথা কোন দিকে যাবে সেটা direction অনুযায়ী ঠিক করা হয়
		case 'U' :
			y[0]=y[0] - UNIT_SIZE;
			break;
		case 'D' :
			y[0]=y[0] + UNIT_SIZE;
			break;
		case 'L' :
			x[0]=x[0] - UNIT_SIZE;
			break;
		case 'R' :
			x[0]=x[0] + UNIT_SIZE;
			break;
			
		}
	}
	public void checkApple() {
		if((x[0]==appleX)&&(y[0]==appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}	
	}
	
    public void checkCollisions() {
    	//check if head collides with body
    	for(int i= bodyParts;i>0;i--) {
    		if((x[0]==x[i])&&(y[0]==y[i])) {
    			running = false;
    		}
    	}
    	
    	// check if head touches left border
    	if(x[0]<0) {
    		running = false;
    	}
    	// check if head touches left border
    	if(x[0]>SCREEN_WIDTH) {
    		running = false;
    	}
    	// check if head touches up border
    	if(y[0]<0) {
    		running = false;
    	}
    	// check if head touches bottom border
    	if(x[0]>SCREEN_HEIGHT) {
    		running = false;
    	}
    	if(!running) {
    		timer.stop();
    	}
		
	}
    public void gameOver(Graphics g) {
    	//score
    	g.setColor(Color.red);
    	g.setFont(new Font("Ink free",Font.BOLD,40));
    	FontMetrics metrices1 = getFontMetrics(g.getFont());
    	g.drawString("Score : "+applesEaten,(SCREEN_WIDTH - metrices1.stringWidth("Score: "+applesEaten))/2 , g.getFont().getSize());
    	// Game over text
    	g.setColor(Color.red);
    	g.setFont(new Font("Ink free",Font.BOLD,75));
    	FontMetrics metrices2 = getFontMetrics(g.getFont());
    	g.drawString("Game Over",(SCREEN_WIDTH - metrices2.stringWidth("Game Over"))/2 , SCREEN_HEIGHT/2);
		
	}
	
	// ActionListener interface এর একটি মেথড ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) { // When timer work actionevent created and game update
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();  // Draw snake and game over
		
	}
	// KeyAdapter holo helping class used for handling keyboard events
	public class MykeyAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			}	
		}	
	}
}
