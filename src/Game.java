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
                player.printInfo();
                System.out.println("bölgeler:");
                System.out.println("1 - Güvenli ev");
                System.out.println("2  - Mağaza");
                System.out.println("3  - Mağara  -----> ödül: <yemek>");
                System.out.println("4  - Orman   -----> ödül: <odun>");
                System.out.println("5  - Nehir   -----> ödül: <su>");
                System.out.print("0 - çıkış yap ");
                int selectLock = input.nextInt();
                switch (selectLock){
                    case 0 :
                        location = null;
                        break;
                    case 1 :
                        location = new SafeHouse(player);
                        break;
                    case 2 :
                        location = new ToolStore(player);
                        break;
                    case 3 :
                        location = new Cave(player);
                        break;
                    case 4 :
                        location = new Forest(player);
                        break;
                    case 5:
                        location = new River(player);
                        break;
                    default:
                        System.out.println("lütfen geçerli bir bölge giriniz!!");

                }
                if (location == null){
                    System.out.println("oyun bitti yine bekleriz:((");
                    break;
                }
                if(!location.onLocation()){
                    System.out.println("oyun bitti!!!!");
                    break;
                }

        }
    }





}
