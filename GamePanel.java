package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Screet settings
    final int originalTileSize=16;//32x32 tiles
    final int scale=2;
    public final int tileSize=originalTileSize*scale;
    final int maxScreenCol=32;
    final int maxScreenRow=18;
    final int screenWidth=tileSize*maxScreenCol;
    final int screenHeight=tileSize*maxScreenRow;
    int FPS=60;
    KeyHandler keyH= new KeyHandler();
    Thread gameThread;
    Player player= new Player(this,keyH);
    //set player default position

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread= new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval=1000000000/FPS; //0.0166 seconds
        double nextDrawTime=System.nanoTime()+drawInterval;
        long timer=0;
        int drawCount=0;
        long lastTime= System.nanoTime();
        while(gameThread!= null){
            long currentTime=System.nanoTime();
            //System.out.println(currentTime);
            timer+=(currentTime-lastTime);
            lastTime=currentTime;
        //Update
            update();
        //Draw
            repaint();
            drawCount++;
            try {
                double remaingTime=nextDrawTime- System.nanoTime();
                remaingTime=remaingTime/1000000;
                if (remaingTime < 0){
                    remaingTime=0;
                }
                Thread.sleep((long) remaingTime);
                nextDrawTime+=drawInterval;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            if (timer>=1000000000){
                System.out.println("FPS: "+ drawCount);
                drawCount=0;
                timer=0;
            }


        }
    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        player.draw(g2);
        g2.dispose();
    }
}
