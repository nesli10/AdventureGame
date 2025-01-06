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
                buyWeapon();
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
            System.out.println(w.getId()+ "-" + w.getName() + " <para : " + w.getPrice() + ", hasar : "  + w.getDamage() + ">");
        }
    }

    public void buyWeapon(){
        System.out.println("bir silah seçiniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){
            System.out.println("geçersiz değer tekrar giriniz!!");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
        if (selectedWeapon != null){
            if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                System.out.println("yeterli paranız bulunmamaktadır!!");

            }
            else {
                System.out.println(selectedWeapon.getName() + "  silahını satın aldınız.");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("kalan paranız : " + this.getPlayer().getMoney());
                System.out.println("önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }
    public void printArmor(){
        System.out.println("zırhlar");
    }
}
