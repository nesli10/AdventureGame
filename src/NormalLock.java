public class  NormalLock extends  Location {

    public NormalLock(Player player, String name){
        super(player);
    }


    @Override
   public boolean onLocation(){
        return false;
    }

}
