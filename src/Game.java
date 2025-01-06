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
        Location location = null;

        while (true){
                System.out.println("bölgeler:");
                System.out.println("1 - güvenli ev");
                System.out.println("2  - mağaza");
                System.out.print("lütfen gitmek istediğiniz bölgeyi seçiniz : ");
                int selectLock = input.nextInt();
                switch (selectLock){
                    case 1 :
                        location = new SafeHouse(player);
                        break;
                    case 2 :
                        location = new ToolStore(player);
                        break;
                    default:
                        location = new SafeHouse(player);

                }
                if(!location.onLocation()){
                    System.out.println("oyun bitti!!!!");
                    break;
                }

        }
    }





}
