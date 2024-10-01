import java.lang.Character;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input=new Scanner(System.in);


    public Player(String name){
        this.name= name;
    }
    public void selectChar(){
        GameChar[] characters = {new Samurai(),new Knighter(),new Archer()};
        System.out.println("-----------------------------------------");
        for (GameChar character : characters) {
            System.out.println(
                    "id: " + character.getId() +
                    " \t karakter:" + character.getName() +
                    " \t hasar:" + character.getDamage() +
                                " \t sağlık:" + character.getHealth()+
                            " \t para:" + character.getMoney()
            );
        }
        System.out.println("-----------------------------------------");
        System.out.println("lütfen bir karakter giriniz");
        int  selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
                case 2:
                    initPlayer(new Knighter());
                    break;
                    case 3:
                        initPlayer(new Archer());
                        break;
                        default:
                            initPlayer(new Samurai());
                            break;
        }
        System.out.println( "karakter: " +this.getName());

    }

    public void initPlayer(GameChar gameChar){
   this.damage=gameChar.getDamage();
   this.health=gameChar.getHealth();
   this.money=gameChar.getMoney();
   this.name=gameChar.getName();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
