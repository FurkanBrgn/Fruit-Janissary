import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Game{
    
    public BorderPane pane=new BorderPane();
    public Scene scene=new Scene(pane,400,450);
    public GridPane grid=new GridPane();
    public FlowPane flow=new FlowPane(Orientation.VERTICAL);
    public HBox hbox1=new HBox();
    public HBox hbox2=new HBox();
    public HBox hbox3=new HBox();
    public HBox hbox4=new HBox();
    public Font font = Font.font("ARIAL", FontWeight.BOLD, 15);
    public Font font1 = Font.font("ARIAL", FontWeight.BOLD, 28);
    public Text scoreText=new Text("Score: 0");
    public Text timeText=new Text("Time: ");
    public Button durdur=new Button("Durdur");
    public Button devam=new Button("Devam Et");
    public Button cikisMenu=new Button("Oyun Menüsüne Dön");
    public Text gameOver=new Text("Game Over");
    public Button yeniOyun=new Button("Yeni Oyun");
    public Button oyunMenu=new Button("Oyun Menüsüne Dön");
    public Button cikis1=new Button("Çıkış");
    public AnchorPane anchor=new AnchorPane();
    public HBox hbox=new HBox();
    public int score=0;
    public int second=0;
    public int minute=0;
    public int hour=0;
    public Timeline timeline;
    public Timeline time;
    public EventHandler eventHandler;
    public double dx1 = 1;
    public double dy1 = -5;
    public double dx2 = 1.4;
    public double dy2 = 5;
    public double dx3 = -1.4;
    public double dy3 = 5;
    public int notSliced=0;
    public int lastScore;
    public String lastTime;
    public boolean timelineStop;
    public boolean gameOverOldu=false;
    public boolean cikisMenuBasildi=false;
    public EventHandler eventHandler1 =(EventHandler) (Event event) -> {
        dy1 = -(dy1);
        dx1 = -(dx1);
        creatGame();
    };
    public void creatFruit(Fruit fruit){
        fruit.addImage();
        int a= (int)(Math.random()*373);
        fruit.getCircle().relocate(a , 450);
        fruit.getArc1().relocate((a+14) , 464);
        fruit.getArc2().relocate((a-13) , 464);
        pane.getChildren().addAll(fruit.getArc1(),fruit.getArc2(),fruit.getCircle());
        if(notSliced>=480)
        {
                timelineStop=true;
                time.stop();
                flow.setVisible(true);
                durdur.setVisible(false);
        }
        eventHandler=(EventHandler<ActionEvent>) (ActionEvent t) -> {
            if(fruit.getCircle().getLayoutX() >= 225)
            {
                dx1 = -(dx1);
            }
            fruit.getArc1().setVisible(false);
            fruit.getArc2().setVisible(false);
            fruit.getCircle().setOnMouseDragExited((event) -> {
                fruit.slice();
                fruit.scorePlus();
                score+=fruit.getScore();
                scoreText.setText("Score: "+score);
            });
            if(!fruit.isSliced()){
                notSliced+=1;
                fruit.getCircle().setLayoutX(fruit.getCircle().getLayoutX() + dx1);
                fruit.getCircle().setLayoutY(fruit.getCircle().getLayoutY() + dy1);
                fruit.getArc1().setLayoutX(fruit.getArc1().getLayoutX() + dx1);
                fruit.getArc1().setLayoutY(fruit.getArc1().getLayoutY() + dy1);
                fruit.getArc2().setLayoutX(fruit.getArc2().getLayoutX() + dx1);
                fruit.getArc2().setLayoutY(fruit.getArc2().getLayoutY() + dy1);
                
            }
            else{
                fruit.getCircle().setVisible(false);
                fruit.getArc1().setVisible(true);
                fruit.getArc2().setVisible(true);
                fruit.getArc1().setLayoutX(fruit.getArc1().getLayoutX() + dx2);
                fruit.getArc1().setLayoutY(fruit.getArc1().getLayoutY() + dy2);
                fruit.getArc2().setLayoutX(fruit.getArc2().getLayoutX() + dx3);
                fruit.getArc2().setLayoutY(fruit.getArc2().getLayoutY() + dy3);
            }
            if( (fruit.getCircle().getLayoutY()) <= 80 &&
                (fruit.getArc1().getLayoutY()) <= 94 &&
                (fruit.getArc2().getLayoutY()) <= 94)
            {
                fruit.getCircle().setLayoutX(fruit.getCircle().getLayoutX() + 1);
                fruit.getArc1().setLayoutX(fruit.getArc1().getLayoutX() + 1);
                fruit.getArc2().setLayoutX(fruit.getArc2().getLayoutX() + 1);
                dy1 = -(dy1);
            }
        };
    }
    public void creatBomb(Bomb bomb){
        bomb.addImage();
        int a= 27+(int)(Math.random()*373);
        bomb.getCircle().relocate(a , 450);
        pane.getChildren().add(bomb.getCircle());
        if(notSliced>=480)
        {
                timelineStop=true;
                time.stop();
                flow.setVisible(true);
                durdur.setVisible(false);
        }
        eventHandler=(EventHandler<ActionEvent>) (ActionEvent t) -> {
            if(bomb.getCircle().getLayoutX() >= 225)
            {
                dx1 = -(dx1);
            }
            bomb.getCircle().setOnMouseDragExited((event) -> {
                bomb.slice();
            });
            if(!bomb.isSliced()){
                bomb.getCircle().setLayoutX(bomb.getCircle().getLayoutX() + dx1);
                bomb.getCircle().setLayoutY(bomb.getCircle().getLayoutY() + dy1);
            }
            else{
                timeline.stop();
                time.stop();
                durdur.setVisible(false);
                bomb.explode();
                Timeline explodeTime=new Timeline(new KeyFrame(Duration.seconds(1),new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        bomb.getCircle().setVisible(false);
                    }
                }));
                explodeTime.setCycleCount(1);
                explodeTime.play();
                flow.setVisible(true);
                durdur.setVisible(false);
            }
            if( (bomb.getCircle().getLayoutY()) <= 80)
            {
                bomb.getCircle().setLayoutX(bomb.getCircle().getLayoutX() + 1);
                dy1 = -(dy1);
            }
        };
    }
    public void creatGame(){
        int b= (int) (Math.random()*5);
        Fruit meyve;
        Bomb bomba;
        switch (b){
            case 0:
                meyve = new Lemon();
                creatFruit(meyve);
                break;
            case 1:
                meyve = new Apple();
                creatFruit(meyve);
                break;
            case 2:
                meyve = new Peach();
                creatFruit(meyve);
                break;
            case 3:
                meyve = new Watermelon();
                creatFruit(meyve);
                break;
            case 4:
                bomba= new Bomba();
                creatBomb(bomba);
                break;
        }
        timeline = new Timeline(new KeyFrame(Duration.millis(25),eventHandler));
        timeline.setCycleCount(160);
        timeline.play();
        if(timelineStop){
            timeline.stop();
        }
        durdur.setOnAction(((event) -> {
            hbox2.getChildren().remove(durdur);
            hbox2.getChildren().addAll(devam,cikisMenu);
            grid.setHgap(100);
            timeline.stop();
            time.stop();
        }));
        devam.setOnAction(((event) -> {
            hbox2.getChildren().removeAll(devam,cikisMenu);
            hbox2.getChildren().add(durdur);
            grid.setHgap(230);
            timeline.play();
            time.play();
        }));
        timeline.setOnFinished(eventHandler1);
    }
}