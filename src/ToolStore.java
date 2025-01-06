public class  ToolStore extends NormalLock{
    public ToolStore(Player player){
        super(player,"mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("mağazaya hoşgeldiniz");
        System.out.println("1  - silahlar");
        System.out.println("2  - zırhlar");
        System.out.println("3  - çıkış yap");
        System.out.print("seçiminiz : ");
        int selectCase = input.nextInt();
        while (selectCase < 1 || selectCase > 3){
            System.out.println("geçersiz değer. tekrar giriniz : ");
             selectCase = input.nextInt();

        }
        switch (selectCase){
            case 1 :
                printWeapon();
                break;
            case 2:
                 printArmor();
                 break;
            case 3 :
                System.out.println("bir daha bekleriz:))");
                return true;
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("silahlar");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getName() + " <para : " + w.getPrice() + ", hasar : "  + w.getDamage() + ">");
        }


    }
    public void printArmor(){
        System.out.println("zırhlar");
    }
}
