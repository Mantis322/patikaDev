public class River extends BattleZone{

    public River(Player player) {
        super("G�l", player, new Bear(), "Water",3);
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

            System.out.println("�uan Buradas�n�z: " + this.getName());
            System.out.println("Burada " + randomMonster + " tane " + this.getMonster().getName() + " ya��yor ");
            System.out.print("Sava� ya da Ka�  (Sava�mak i�i ' S ' , Ka�mak i�in 'K'): ");

            String selectCase = scan.nextLine();
            selectCase = selectCase.toUpperCase();

            if (selectCase.equals("S") && combat(randomMonster)) {
                System.out.println("Bu sava�� kazand�n...");
                System.out.println(this.getAward() + " �d�l�n� kazand�n�z. ");
                return true;
            }
            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("�ld�n�z");
                return false;
            }
            if (this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFirewood() && this.getPlayer().getInventory().isFood()) {
                System.out.println("Tebrikler oyunu kazand�n�z.");
                return false;
            }
            return true;
        }else {
            System.out.println("Su �d�l�n� zaten ald�n�z.");
            return true;
        }
    }
}
