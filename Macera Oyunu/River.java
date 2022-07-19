public class River extends BattleZone{

    public River(Player player) {
        super("Göl", player, new Bear(), "Water",3);
    }

    @Override
    public void isWin(){
        super.isWin();
        this.getPlayer().getInventory().setWater(true);
    }

    @Override
    public boolean onZone(){
        if(!this.getPlayer().getInventory().isWater()){
            int randomMonster = randomMonsterNumber();

            System.out.println("Þuan Buradasýnýz: " + this.getName());
            System.out.println("Burada " + randomMonster + " tane " + this.getMonster().getName() + " yaþýyor ");
            System.out.print("Savaþ ya da Kaç  (Savaþmak içi ' S ' , Kaçmak için 'K'): ");

            String selectCase = scan.nextLine();
            selectCase = selectCase.toUpperCase();

            if (selectCase.equals("S") && combat(randomMonster)) {
                System.out.println("Bu savaþý kazandýn...");
                System.out.println(this.getAward() + " ödülünü kazandýnýz. ");
                return true;
            }
            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Öldünüz");
                return false;
            }
            if (this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFirewood() && this.getPlayer().getInventory().isFood()) {
                System.out.println("Tebrikler oyunu kazandýnýz.");
                return false;
            }
            return true;
        }else {
            System.out.println("Su ödülünü zaten aldýnýz.");
            return true;
        }
    }
}
