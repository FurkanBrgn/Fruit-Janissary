import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Watermelon extends Fruit{
    private int score=0;
    public Watermelon() {
        super();
    }
    @Override
    public void slice() {
        super.slice();
    }

    @Override
    void addImage() {
        Image img=new Image("pictures/watermelon.png",false);
        getCircle().setFill(new ImagePattern(img));
        Image img1=new Image("pictures/watermelonhalf.png",false);
        getArc1().setFill(new ImagePattern(img1));
        Image img2=new Image("pictures/watermelonhalf2.png",false);
        getArc2().setFill(new ImagePattern(img2));
    }
    
    @Override
    void scorePlus() {
        this.score+=10;
    }
    
    @Override
    int getScore() {
        return this.score;
    }
}
