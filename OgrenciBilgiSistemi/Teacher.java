public class Teacher {
    String name;
    String mpno;
    String branch;

    Teacher(String name, String mpno, String branch) {
        this.name = name;
        this.mpno = mpno;
        this.branch = branch;
    }

    void print() {
        System.out.println("Ad�: " + this.name);
        System.out.println("Telefon Numaras�: " + this.mpno);
        System.out.println("B�l�m�: " + this.branch);
    }
}
