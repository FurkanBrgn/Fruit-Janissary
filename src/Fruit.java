import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public abstract class Fruit implements Sliceable{
    private Circle circle;
    private Arc arc1;
    private Arc arc2;
    private boolean sliced=false;
    
    public Fruit() {
        circle=new Circle(27);
        arc1=new Arc();
        arc1.setRadiusX(27);
        arc1.setRadiusY(27);
        arc1.setStartAngle(0);
        arc1.setLength(180);
        arc1.setType(ArcType.CHORD);
        arc1.setStroke(null);
        arc1.setRotate(90);
        arc2=new Arc();
        arc2.setRadiusX(27);
        arc2.setRadiusY(27);
        arc2.setStartAngle(0);
        arc2.setLength(180);
        arc2.setType(ArcType.CHORD);
        arc2.setStroke(null);
        arc2.setRotate(270);
    }
    @Override
    public void slice() {
       this.sliced=true;
    }
    abstract void addImage();
    abstract void scorePlus();
    
    public boolean isSliced() {
        return sliced;
    }
    
    public Circle getCircle() {
        return circle;
    }

    public Arc getArc1() {
        return arc1;
    }
    
    public Arc getArc2() {
        return arc2;
    }
    
    abstract int getScore();
}
