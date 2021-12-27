import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FruitJanissary extends Application{
    TextField adField;
    TextField soyadField;
    TextField epostaField;
    TextField kullaniciField2;
    TextField sifreField2;
    TextField kullaniciField1;
    TextField sifreField1;
    ListView listView=new ListView();
    ListView listView2=new ListView();
    Label ad=new Label();
    Label soyad=new Label();
    Label eposta=new Label();
    Label kullanici=new Label();
    Label sifre=new Label();
    TableView table1;
    BorderPane border6=new BorderPane();
    BorderPane border7=new BorderPane();
    HBox hbox6=new HBox();
    HBox hbox7=new HBox();
    private Connection baglanti;
    private Statement statement;
    boolean i;
    boolean i2;
    GridPane grid4;
    int score;
    String time;
    @Override
    public void start(Stage primaryStage) throws Exception {
        baglan();
        //ANA SAYFA EKRANI
        BorderPane border1=new BorderPane();
        Scene scene1=new Scene(border1,350,300);
        StackPane stack=new StackPane();
        GridPane grid1=new GridPane();
        
        Font font = Font.font("ARIAL", FontWeight.BOLD, 32);
        Text text=new Text("Fruit Janissary");
        text.setFont(font);
        stack.getChildren().add(text);
        
        Button giris1=new Button("Giriş Yap");
        Button kaydol1=new Button("Kayıt Ol");
        grid1.add(giris1, 0, 0);
        grid1.add(kaydol1, 1, 0);
        
        grid1.setPadding(new Insets(0, 0, 50, 0));
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(30);
        
        border1.setCenter(stack);
        border1.setBottom(grid1);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Fruit Janissary");
        primaryStage.show();

        //GİRİŞ YAP EKRANI
        BorderPane border2=new BorderPane();
        Scene scene2=new Scene(border2,300,300);
        GridPane grid2=new GridPane();
        HBox hbox1=new HBox();
        HBox hbox2=new HBox();
        grid2.add(hbox1, 0, 2);
        grid2.add(hbox2, 1, 2);
        grid2.setAlignment(Pos.BASELINE_CENTER);
        
        Text kullaniciAdi1=new Text("Kullanıcı Adı: ");
        kullaniciAdi1.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid2.add(kullaniciAdi1, 0, 0);
        Text sifre1=new Text("Şifre: ");
        sifre1.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid2.add(sifre1, 0, 1);
        
        kullaniciField1=new TextField();
        grid2.add(kullaniciField1, 1, 0);
        sifreField1=new TextField();
        grid2.add(sifreField1, 1, 1);
        
        Button giris2=new Button("Giriş");
        hbox2.getChildren().add(giris2);
        hbox2.setAlignment(Pos.BASELINE_RIGHT);
        Button geri1=new Button("Geri");
        hbox1.getChildren().add(geri1);
        hbox1.setAlignment(Pos.BASELINE_LEFT);
        
        grid2.setPadding(new Insets(50,20,0,20));
        grid2.setVgap(40);
        grid2.setHgap(20);
        
        giris1.setOnAction((event) -> {
            primaryStage.setScene(scene2); 
            primaryStage.show();
        });
        border2.setCenter(grid2);
        
        geri1.setOnAction(((event) -> {
            primaryStage.setScene(scene1);
            primaryStage.show();
        }));
        
        //KAYIT OL EKRANI
        BorderPane border3=new BorderPane();
        Scene scene3=new Scene(border3,300,470);
        GridPane grid3=new GridPane();
        HBox hbox3=new HBox();
        HBox hbox4=new HBox();
        grid3.add(hbox3, 0, 5);
        grid3.add(hbox4, 1, 5);
        grid3.setAlignment(Pos.BASELINE_CENTER);
        
        Text ad1=new Text("Ad: ");
        ad1.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid3.add(ad1, 0, 0);
        Text soyad1=new Text("Soyad: ");
        soyad1.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid3.add(soyad1, 0, 1);
        Text eposta1=new Text("E-Posta: ");
        eposta1.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid3.add(eposta1, 0, 2);
        Text kullaniciAdi2=new Text("Kullanıcı Adı: ");
        kullaniciAdi2.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid3.add(kullaniciAdi2, 0, 3);
        Text sifre2=new Text("Şifre: ");
        sifre2.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid3.add(sifre2, 0, 4);
        
        adField=new TextField();
        grid3.add(adField, 1, 0);
        soyadField=new TextField();
        grid3.add(soyadField, 1, 1);
        epostaField=new TextField();
        grid3.add(epostaField, 1, 2);
        kullaniciField2=new TextField();
        grid3.add(kullaniciField2, 1, 3);
        sifreField2=new TextField();
        grid3.add(sifreField2, 1, 4);
        
        Button kaydol2=new Button("Kayıt Ol");
        hbox4.getChildren().add(kaydol2);
        hbox4.setAlignment(Pos.BASELINE_RIGHT);
        Button geri2=new Button("Geri");
        hbox3.getChildren().add(geri2);
        hbox3.setAlignment(Pos.BASELINE_LEFT);
        
        grid3.setPadding(new Insets(50,20,0,20));
        grid3.setVgap(40);
        grid3.setHgap(20);
        
        border3.setCenter(grid3);
        
        kaydol1.setOnAction(((event)-> { 
            primaryStage.setScene(scene3);
            primaryStage.show();
        }));
        
        kaydol2.setOnAction(((event)-> {
            kayıtYap();
            if(i2){
                primaryStage.setScene(scene1);
                primaryStage.show();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bildirim");
                alert.setHeaderText(null);
                alert.setContentText("Başarıyla Kayıt Oldunuz");
                alert.showAndWait();
                adField.clear();
                soyadField.clear();
                epostaField.clear();
                kullaniciField2.clear();
                sifreField2.clear();
            }
        }));
        
        geri2.setOnAction(((event) -> {
            primaryStage.setScene(scene1);
            primaryStage.show();
        }));
        
        //OYUNCU EKRANI
        BorderPane border4=new BorderPane();
        Scene scene4=new Scene(border4,300,400);
        AnchorPane anchor1=new AnchorPane();
        HBox hbox5=new HBox();
        FlowPane flow1=new FlowPane(Orientation.VERTICAL,0,30);
        
        Button profilim=new Button("Profili Gör");
        hbox5.getChildren().add(profilim);
        anchor1.getChildren().add(hbox5);
        AnchorPane.setRightAnchor(hbox5,10d);
        AnchorPane.setTopAnchor(hbox5,10d);
        
        Button skorlarim=new Button("Skorlarım");
        Button liderTablosu=new Button("Lider Tablosu");
        Button oyunaBasla=new Button("Oyuna Başla");
        Button cikis=new Button("Çıkış");
        flow1.getChildren().addAll(oyunaBasla,skorlarim,liderTablosu,cikis);
        flow1.setAlignment(Pos.CENTER);
        border4.setTop(anchor1);
        border4.setCenter(flow1);
        giris2.setOnAction(((event) -> {
            girisYap();
            if(i){
                primaryStage.setScene(scene4);
                primaryStage.show();
                kullaniciField1.clear();
                sifreField1.clear();
            }
        }));
        
        cikis.setOnAction(((event) -> {
            primaryStage.setScene(scene1);
            primaryStage.show();
        }));
        
        //PROFİLİ GÖR EKRANI
        BorderPane border5=new BorderPane();
        Scene scene5=new Scene(border5,300,420);
        grid4=new GridPane();
        grid4.setAlignment(Pos.BASELINE_CENTER);
        
        Text ad2=new Text("Ad: ");
        ad2.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid4.add(ad2, 0, 0);
        Text soyad2=new Text("Soyad: ");
        soyad2.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid4.add(soyad2, 0, 1);
        Text eposta2=new Text("E-Posta: ");
        eposta2.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid4.add(eposta2, 0, 2);
        Text kullaniciAdi3=new Text("Kullanıcı Adı: ");
        kullaniciAdi3.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid4.add(kullaniciAdi3, 0, 3);
        Text sifre3=new Text("Şifre: ");
        sifre3.setFont(Font.font("ARIAL", FontWeight.BOLD, 14));
        grid4.add(sifre3, 0, 4);
        
        grid4.add(ad, 1, 0);
        grid4.add(soyad, 1, 1);
        grid4.add(eposta, 1, 2);
        grid4.add(kullanici, 1, 3);
        grid4.add(sifre, 1, 4);
        
        Button geri3=new Button("Geri");
        grid4.add(geri3, 0, 5);
        grid4.setPadding(new Insets(50,20,0,20));
        grid4.setVgap(40);
        grid4.setHgap(20);
        border5.setCenter(grid4);
        
        profilim.setOnAction(((event) -> {
            profilGor();
            primaryStage.setScene(scene5);
            primaryStage.show();
        }));
        
        geri3.setOnAction(((event) -> {
            primaryStage.setScene(scene4);
            primaryStage.show();
        }));
        
        //SKORLARIM EKRANI
        Scene scene6=new Scene(border6,300,370);
        Button geri4=new Button("Geri");
        hbox6.getChildren().add(geri4);
        border6.setBottom(hbox6);
        hbox6.setPadding(new Insets(10, 0, 10, 10));
        
        skorlarim.setOnAction(((event) -> {
            border6.setCenter(listView);
            listView.setPadding(new Insets(20, 0, 0,0));
            skorlariGoster();
            primaryStage.setScene(scene6);
            primaryStage.show();
        }));
        
        geri4.setOnAction(((event) -> {
            listView.getItems().clear();
            primaryStage.setScene(scene4);
            primaryStage.show();
        }));
        
        //LİDER TABLOSU EKRANI
        Scene scene7=new Scene(border7,300,370);
        Button geri5=new Button("Geri");
        hbox7.getChildren().add(geri5);
        border7.setBottom(hbox7);
        hbox7.setPadding(new Insets(10, 0, 10, 10));
        
        liderTablosu.setOnAction(((event) -> {
            border7.setCenter(listView2);
            listView2.setPadding(new Insets(20, 0, 0,0));
            liderleriGoster();
            primaryStage.setScene(scene7);
            primaryStage.show();
        }));
        
        geri5.setOnAction(((event) -> {
            listView2.getItems().clear();
            primaryStage.setScene(scene4);
            primaryStage.show();
        }));
        
        //OYUNA BAŞLA EKRANI 
        Game game=new Game();
        game.pane.setOnDragDetected(event ->game.pane.startFullDrag());
        game.scoreText.setFont(game.font);
        game.timeText.setFont(game.font);
        game.time=new Timeline(new KeyFrame(Duration.seconds(1),new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.second++;
                if(game.second==60){
                    game.minute++;
                    game.second=0;
                }
                if(game.minute==60){
                    game.hour++;
                    game.minute=0;
                }
                game.timeText.setText(game.hour+":"+game.minute+":"+game.second);
            }
        }));
        game.time.setCycleCount(Timeline.INDEFINITE);
        game.grid.add(game.hbox1, 0, 0);
        game.grid.add(game.hbox2, 1, 0);
        game.grid.add(game.timeText, 0, 1);
        game.grid.setAlignment(Pos.CENTER);
        game.hbox1.getChildren().add(game.scoreText);
        game.hbox2.getChildren().add(game.durdur);
        game.grid.setPadding(new Insets(10,20,0,20));
        game.grid.setHgap(230);
        game.grid.setVgap(5);
        game.pane.setTop(game.grid);
        game.gameOver.setFont(game.font1);
        game.hbox4.getChildren().add(game.gameOver);
        game.hbox4.setAlignment(Pos.CENTER);
        game.hbox3.getChildren().addAll(game.yeniOyun,game.oyunMenu,game.cikis1);
        game.hbox3.setAlignment(Pos.CENTER);
        game.flow.getChildren().addAll(game.hbox4,game.hbox3);
        game.flow.setAlignment(Pos.CENTER);
        game.flow.setVgap(20);
        game.flow.setVisible(false);
        game.pane.setCenter(game.flow);
        
        oyunaBasla.setOnAction(((event) -> {
            game.score=0;
            game.notSliced=0;
            game.time.play();
            game.creatGame();
            primaryStage.setScene(game.scene);
            primaryStage.show();
        }));
        game.cikisMenu.setOnAction(((event) -> {
            game.hbox2.getChildren().removeAll(game.devam,game.cikisMenu);
            game.hbox2.getChildren().add(game.durdur);
            game.grid.setHgap(230);
            game.timeline.play();
            game.second=0;
            game.minute=0;
            game.hour=0;
            game.score=0;
            game.scoreText.setText("Score "+score);
            game.timeText.setText(game.hour+":"+game.minute+":"+game.second);
            game.timeline.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    game.timeline.stop();
                }
            });
            primaryStage.setScene(scene4);
            primaryStage.show();
        }));
           
        game.oyunMenu.setOnAction(((event) -> {
            score=game.score;
            time=game.timeText.getText();
            scoreGonder();
            game.second=0;
            game.minute=0;
            game.hour=0;
            game.score=0;
            game.scoreText.setText("Score "+game.score);
            game.timeText.setText(game.hour+":"+game.minute+":"+game.second);
            game.flow.setVisible(false);
            game.durdur.setVisible(true);
            primaryStage.setScene(scene4);
            primaryStage.show();
        }));
        game.cikis1.setOnAction(((event) -> {
            score=game.score;
            time=game.timeText.getText();
            scoreGonder();
            game.second=0;
            game.minute=0;
            game.hour=0;
            game.score=0;
            game.scoreText.setText("Score "+game.score);
            game.timeText.setText(game.hour+":"+game.minute+":"+game.second);
            game.flow.setVisible(false);
            game.durdur.setVisible(true);
            primaryStage.setScene(scene2);
            primaryStage.show();
        }));
        game.yeniOyun.setOnAction(((event) -> {
            score=game.score;
            time=game.timeText.getText();
            scoreGonder();
            game.second=0;
            game.minute=0;
            game.hour=0;
            game.score=0;
            game.scoreText.setText("Score "+game.score);
            game.timeText.setText(game.hour+":"+game.minute+":"+game.second);
            game.flow.setVisible(false);
            game.durdur.setVisible(true);
            game.notSliced=0;
            game.time.play();
            game.creatGame();
            primaryStage.setScene(game.scene);
            primaryStage.show();
        }));
    }
    private void baglan() {
        String url = "jdbc:mysql://127.0.0.1:3306/javaproje";
        Properties connectionProps = new Properties();
        connectionProps.setProperty("user","root");
        connectionProps.setProperty("password","mYsqL1354mF38");
        connectionProps.setProperty("useSSL","false");
        connectionProps.setProperty("serverTimezone","UTC");
        connectionProps.setProperty("allowPublicKeyRetrieval","true");

        //Create connection and statement
        try {
            baglanti = (Connection) DriverManager.getConnection(url, connectionProps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void baglantiKapat(Connection connection)throws SQLException{
        if(connection != null){
            System.out.println("Bağlantı Kapatılıyor");
            connection.close();
        }

    }
    public void stop() throws Exception {
        baglantiKapat(baglanti);
    }
    private void kayıtYap(){
        String ad=adField.getText();
        String soyad=soyadField.getText();
        String kullaniciadi=kullaniciField2.getText();
        String email=epostaField.getText();
        String sifre=sifreField2.getText();
        EmailRegex emailRegex=new EmailRegex();
        Sifreleme sifreleme=new Sifreleme();
        String sifreli=sifreleme.Sifre(sifreField2.getText());
        if(emailRegex.eslestir(epostaField.getText())){
            i2=true;
            String insert = "insert into javaproje.members(ad, soyad, kullaniciadi, email, sifre)"+"values('"+ ad +"','"+ soyad +"','"+ kullaniciadi +"','"+ email +"','"+ sifreli +"')";
            String table="CREATE TABLE `javaproje`.`"+kullaniciadi.toLowerCase()+"scores` (\n" +"  `score` INT NOT NULL,\n" +"  `time` VARCHAR(20) NOT NULL);";
            try {
                statement = (Statement) baglanti.createStatement();
                statement.executeUpdate(table);
                statement.executeUpdate(insert);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bildirim");
            alert.setHeaderText(null);
            alert.setContentText("Lütfen Geçerli Bir E-Mail Giriniz!!!");
            alert.showAndWait();
        }
            
    }
    String kullaniciadi;
    String sifresi;
    private void girisYap(){
        //ResultSet rs=null;
        String kullaniciAdi=kullaniciField1.getText();
        Sifreleme sifreleme=new Sifreleme();
        String sifreli=sifreleme.Sifre(sifreField1.getText());
        String query = "select kullaniciadi,sifre from members where kullaniciadi= '"+kullaniciAdi+"' and sifre= '"+sifreli+"'";
        try {
            statement = (Statement) baglanti.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                i=true;
                kullaniciadi=kullaniciAdi;
                sifresi=sifreli;
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bildirim");
                alert.setHeaderText(null);
                alert.setContentText("Kullanıcı Adı veya Şifre Yanlış!!!");
                alert.showAndWait();
            } 
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
    }
    private void profilGor(){
        String query = "select ad, soyad, email from members where kullaniciadi='"+kullaniciadi+"' and sifre='"+sifresi+"'";
        try {
            statement = (Statement) baglanti.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
               ad.setText(rs.getString("ad"));
               ad.setFont(Font.font("ARIAL", FontWeight.NORMAL, 14));
               soyad.setText(rs.getString("soyad"));
               soyad.setFont(Font.font("ARIAL", FontWeight.NORMAL, 14));
               eposta.setText(rs.getString("email"));
               eposta.setFont(Font.font("ARIAL", FontWeight.NORMAL, 14));
               kullanici.setText(kullaniciadi);
               kullanici.setFont(Font.font("ARIAL", FontWeight.NORMAL, 14));
               Sifreleme sifreleme=new Sifreleme();
               String yenisifre=sifreleme.GeriSifre(sifresi);
               sifre.setText(yenisifre);
               sifre.setFont(Font.font("ARIAL", FontWeight.NORMAL, 14));
               
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bildirim");
                alert.setHeaderText(null);
                alert.setContentText("Kullanıcı Adı veya Şifre Yanlış!!!");
                alert.showAndWait();
            }   
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
            
    }
    private void scoreGonder(){
        String insert = "insert into javaproje."+kullaniciadi.toLowerCase()+"scores(score,time)"+"values("+score+",'"+ time +"')";
        String insert2 = "insert into javaproje.highscores(kullaniciadi,skor,sure)"+"values('"+kullaniciadi+"',"+score+",'"+ time +"')";
        try {
            statement = (Statement) baglanti.createStatement();
            statement.executeUpdate(insert);
            statement.executeUpdate(insert2);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
            
    }
    private void skorlariGoster(){
        ResultSet rs = null;
        String query = "select * from "+kullaniciadi.toLowerCase()+"scores order by score desc";
        try {
            statement = (Statement) baglanti.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                listView.getItems().add("     "+rs.getString("score")+"                  "+rs.getString("time"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
            
    }
    private void liderleriGoster(){
        ResultSet rs = null;
        String query = "select * from highscores order by skor desc limit 10";
        try {
            statement = (Statement) baglanti.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                listView2.getItems().add("     "+rs.getString("kullaniciadi")+"          "+rs.getString("skor")+"          "+rs.getString("sure"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
            
    }
}
