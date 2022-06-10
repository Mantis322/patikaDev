public class Student {
    Course mat;
    Course fizik;
    Course kimya;
    String name;
    String stuNo;
    String classes;
    double avarage;
    boolean isPass;

    Student(String name, String stuNo, String classes, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        this.avarage = 0.0;
        this.isPass = false;
    }

    void addExamNote(int mat, int fizik, int kimya) {
        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }
        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }
        if (kimya >= 0 && mat <= 100) {
            this.kimya.note = kimya;
        }

    }

    void addSpeakingExamNote(int mat, int fizik, int kimya) {
        if (mat >= 0 && mat <= 100) {
            this.mat.speakingNote = mat;
        }
        if (fizik >= 0 && fizik <= 100) {
            this.fizik.speakingNote = fizik;
        }
        if (kimya >= 0 && mat <= 100) {
            this.kimya.speakingNote = kimya;
        }
    }

    void calcAvarage() {
        double fizikAvarage = ((this.fizik.note * 0.8) + (this.fizik.speakingNote * 0.2));
        double kimyaAvarage = ((this.kimya.note * 0.8) + (this.kimya.speakingNote * 0.2));
        double matAvarage = ((this.mat.note * 0.8) + (this.mat.speakingNote * 0.2));
        this.avarage = (matAvarage + fizikAvarage + kimyaAvarage) / 3.0;
    }

    void isPass() {
        calcAvarage();
        if (this.avarage > 55) {
            this.isPass = true;
            printNote();
            System.out.println("Ortalaman�z: " + this.avarage);
            System.out.println("S�n�f� ge�tiniz.");
        } else {
            printNote();
            System.out.println("Ortalaman�z: " + this.avarage);
            System.out.println("Kald�n�z.");
        }
    }

    void printNote() {
        System.out.println("=========================");
        System.out.println("��renci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Matematik S�zl� Notu : " + this.mat.speakingNote);
        System.out.println("Fizik S�zl� Notu : " + this.fizik.speakingNote);
        System.out.println("Kimya S�zl� Notu : " + this.kimya.speakingNote);
    }
}
