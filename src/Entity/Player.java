package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyHandler;
    public Player(GamePanel gamePanel,KeyHandler keyHandler){
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
        direction = "right";
    }
    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 3;
    }
    public void getPlayerImage(){
        try{
            //up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/charmander.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/charmander-right.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/charmander-.png")));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyHandler.upPressed == true) {
            //direction = "up";
            y -= speed;
        } else if (keyHandler.downPressed == true) {
            //direction = "down";
            y += speed;
        } else if (keyHandler.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyHandler.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.green);
//        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        getPlayerImage();
        //BufferedImage image = up1;
        if(direction.equals("right")){
            g2.drawImage(right1,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
        }
        if(direction.equals("left")){
            g2.drawImage(left1,x,y,gamePanel.tileSize,gamePanel.tileSize,null);
        }




    }

}
