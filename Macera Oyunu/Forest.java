public class Forest extends BattleZone{
    public Forest( Player player) {
        super("Orman", player, new Vampire(), "Firewood",3);
    }

    @Override
    public void isWin(){
        super.isWin();
        this.getPlayer().getInventory().setFirewood(true);
    }

    public boolean onZone() {
        if (!this.getPlayer().getInventory().isFirewood()) {
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
        } else {
            System.out.println("Odun ödülünü zaten aldýnýz.");
            return true;
        }
    }
}
