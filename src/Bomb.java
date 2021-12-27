import javafx.scene.shape.Circle;

public abstract class Bomb implements Sliceable{
    private Circle circle;
    private boolean sliced=false;

    public Bomb() {
        circle=new Circle(27);
    }
    @Override
    public void slice() {
        this.sliced=true;
    }
    
    abstract void addImage();
    abstract void explode();
    
    public boolean isSliced() {
        return sliced;
    }
    
    public Circle getCircle() {
        return circle;
    }
}
