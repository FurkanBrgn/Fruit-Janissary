import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Apple extends Fruit{
    private int score=0;
    public Apple() {
        super();
    }
    
    @Override
    public void slice() {
        super.slice();
    }

    @Override
    void addImage() {
        Image img=new Image("pictures/apple.png",false);
        getCircle().setFill(new ImagePattern(img));
        Image img1=new Image("pictures/applehalf.png",false);
        getArc1().setFill(new ImagePattern(img1));
        Image img2=new Image("pictures/applehalf2.png",false);
        getArc2().setFill(new ImagePattern(img2));
    }
    
    @Override
    void scorePlus() {
        this.score+=5;
    }
    
    @Override
    int getScore() {
        return this.score;
    }
    
    
}
