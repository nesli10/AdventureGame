import java.util.Scanner;

public class Game
{
    private Scanner input =new Scanner(System.in);
    public void Start(){
        System.out.println("Oyuna Hoşgeldiniz:)");
        System.out.print("Lütfen bir isim giriniz:");
        String playerName =input.next();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " hoşgeldiniz");
        player.selectChar();
    }





}
