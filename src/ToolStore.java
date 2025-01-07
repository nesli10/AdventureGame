public class  ToolStore extends NormalLock{
    public ToolStore(Player player){
        super(player,"mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("mağazaya hoşgeldiniz");
        boolean showMenu = true;
        while (showMenu){
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
                    buyArmor();
                    break;
                case 3 :
                    System.out.println("bir daha bekleriz:))");
                    showMenu = false;
                    break;
            }

        }
        return true;
    }
    public void printWeapon(){
        System.out.println("silahlar");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId()+ "-" + w.getName() + " <para : " + w.getPrice() + ", hasar : "  + w.getDamage() + ">");
        }
        System.out.println( "0 - Çıkış yap");
    }

    public void buyWeapon(){
        System.out.println("bir silah seçiniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("geçersiz değer tekrar giriniz!!");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID !=0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
            if (selectedWeapon != null){
                if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("yeterli paranız bulunmamaktadır!!");

                }
                else {
                    System.out.println(selectedWeapon.getName() + "  silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("kalan bakiye : " + this.getPlayer().getMoney());
                    System.out.println("önceki silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }
    public void printArmor(){
        System.out.println("------zırhlar-----");
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() + " <Para : " + a.getPrice() + ", Zırh : " + a.getBlock() + " >");
        }
        System.out.println( "0 - Çıkış yap");
    }
    public void buyArmor(){
        System.out.println("bir zırh seçiniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length){
            System.out.println("geçersiz değer tekrar giriniz!!");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
            if (selectedArmor != null){
                if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("yeterli paranız bulunmamaktadır!!");

                }
                else {
                    System.out.println(selectedArmor.getName() + "  zırhını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("kalan bakiye : " + this.getPlayer().getMoney());
                }
            }
        }

    }


}
