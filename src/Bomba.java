import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Bomba extends Bomb{
    
    public Bomba(){
        super();
    }
    @Override
    public void slice() {
        super.slice();
    }
    @Override
    void addImage() {
        Image img=new Image("pictures/bomb.png",false);
        getCircle().setFill(new ImagePattern(img));
    }
    @Override
    void explode() {
        Image img=new Image("pictures/explosion.gif",false);
        getCircle().setFill(new ImagePattern(img));
    }
}
