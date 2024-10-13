package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    public BufferedImage stayPNG;
    public BufferedImage Ch1PNG;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction="stay";
    }
    public void getPlayerImage(){
        try{


           Ch1PNG= ImageIO.read(getClass().getResourceAsStream("/Character.png"));
           // up1= ImageIO.read(getClass().getResourceAsStream("/Img/Charater2.png"));
          // stayPNG= ImageIO.read(getClass().getResourceAsStream("src/resources/stay.png"));

        }catch (IOException e){
                e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed==true){
            //direction="up";
            y-=speed;
        } else if (keyH.downPressed==true) {
            //direction="down";
            y+=speed;
        }
        else if(keyH.leftPressed==true){
            x-=speed;
        }
        else if(keyH.rightPressed==true){
            x+=speed;
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image=Ch1PNG;

        //BufferedImage image=null;
       // switch (direction){
       //     case "up":
       //         image=up1;
       // }

        g2.drawImage(image, x,y,gp.tileSize,gp.tileSize,null);
      //  g2.setColor(Color.white);
      //  g2.fillRect(x,y,gp.tileSize,gp.tileSize);
    }
}
