public class Match {
    Fighter f1;
    Fighter f2;
    int maxWeight;
    int minWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    void run() {
        if (isCheck()) {
            while (this.f1.health > 0 && this.f2.health > 0) {
                if (firstStrike()<=50){
                    System.out.println("======== YENÝ ROUND ===========");
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    healthVision();
                }
                if (firstStrike()>50) {
                    System.out.println("======== YENÝ ROUND ===========");
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    healthVision();
                }
            }
        } else {
            System.out.println("Sikletler uyuþmuyor.");
        }
    }

    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (f1.health == 0) {
            System.out.println(" Kazanan: " + f2.name);
            healthVision();
            return true;
        }
        if (f2.health == 0) {
            System.out.println(" Kazanan: " + f1.name);
            healthVision();
            return true;
        }
        return false;
    }

    void healthVision(){
        System.out.println(f1.name + " Kalan can: " + f1.health);
        System.out.println(f2.name + " Kalan can: " + f2.health);
    }

    double firstStrike(){
        double randomStrike = Math.random() * 100;
        return randomStrike;
    }
}
