package breakout;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class powerUp {
    public static final int POWERUP_SPEED = 100;
    public static final int POWERUP_SIZE = 25;

    public static final String STRENGTH_POWERUP_FILE = "strengthPowerUp.png";
    public static final String TIME_POWERUP_FILE = "timePowerUp.png";
    public static final String LENGTH_POWERUP_FILE = "lengthPowerUp.png";
    public static final String HEALTH_POWERUP_FILE = "healthPowerUp.png";

    Image StrengthPowerUp = new Image(this.getClass().getClassLoader().getResourceAsStream(STRENGTH_POWERUP_FILE));
    Image TimePowerUp = new Image(this.getClass().getClassLoader().getResourceAsStream(TIME_POWERUP_FILE));
    Image LengthPowerUp = new Image(this.getClass().getClassLoader().getResourceAsStream(LENGTH_POWERUP_FILE));
    Image HealthPowerUp = new Image(this.getClass().getClassLoader().getResourceAsStream(HEALTH_POWERUP_FILE));

    Image image;
    private ImageView myView;

    private int initXPosition;
    private int initYPosition;
    private int mySpeed = 0;
    private boolean Enabled;

    private String myPowerUpType;

    public powerUp(int xPosition, int yPosition, String type){
        initXPosition = xPosition;
        initYPosition = yPosition;

        set_Type(type);

        myView = new ImageView(image);

        int size = POWERUP_SIZE;
        myView.setFitWidth(size);
        myView.setFitHeight(size);

        myView.setX(initXPosition); //REFACTOR LATER IN THE STYLE THAT IS IN BOUNCER.JAVA
        myView.setY(initYPosition);

        Enabled = true;
        //myView.setImage(null);
    }

    public void move(double elapsedTime){
        myView.setY(myView.getY() + mySpeed * elapsedTime);
    }

    public void set_Type(String typeOfPowerUp){
        myPowerUpType = typeOfPowerUp;
        if(typeOfPowerUp.equals("strength")){
            set_Skin(1);
        }
        else if(typeOfPowerUp.equals("time")){
            set_Skin(2);
        }
        else if(typeOfPowerUp.equals("length")){
            set_Skin(3);
        }
        else if(typeOfPowerUp.equals("health")){
            set_Skin(4);
        }
    }

    public void set_Skin(int val){
        if(val == 1){
            image = StrengthPowerUp;
        }
        else if (val == 2){
            image = TimePowerUp;
        }
        else if (val ==3){
            image = LengthPowerUp;
        }
        else{
            image = HealthPowerUp;
        }
    }

    public void showImage(){   //Can get rid of later.
        myView.setImage(image);
    }

    private void hideImage(){
        myView.setImage(null);
    }

    private void disable(){
        Enabled=false;
    }

    public void delete(){
        disable();
        hideImage();
    }

    public void startDrop(){
        mySpeed = POWERUP_SPEED;
    }

    public int getXPos(){
        return initXPosition;
    }

    public int getYPos(){
        return initYPosition;
    }

    public String getPowerType(){
        return myPowerUpType;
    }

    public boolean isEnabled(){
        return Enabled;
    }

    /**
     * Internal View of Powerup Object
     */
    public Node getView () {
        return myView;
    }
}