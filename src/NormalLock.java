public class  NormalLock extends  Location {

    public NormalLock(Player player, String name){
        super(player, name);
    }


    @Override
   public boolean onLocation(){
        return false;
    }

}
