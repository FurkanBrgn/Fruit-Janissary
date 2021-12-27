import java.util.Base64;

public class Sifreleme {

    public String Sifre(String key){
        String Sifrelenmis=Base64.getEncoder().encodeToString(key.getBytes());
        System.out.println(Sifrelenmis);
        return Sifrelenmis;

    }
    public String GeriSifre(String sifre){
        byte[] coz=Base64.getDecoder().decode(sifre);
        String cozulmus=new String(coz);

        return cozulmus;
    }





}
