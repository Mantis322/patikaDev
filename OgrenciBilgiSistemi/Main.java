public class Main {

    public static void main(String[] args) {
        Teacher t1 = new Teacher("Mahmut", "5", "FZK");
        Teacher t2 = new Teacher("Selami", "6", "MAT");
        Teacher t3 = new Teacher("Aysu", "7", "KMY");

        Course mat = new Course("Matematik", "101", "MAT");
        Course fizik = new Course("Fizik", "101", "FZK");
        Course kimya = new Course("Kimya", "101", "KMY");

        mat.addTeacher(t2);
        fizik.addTeacher(t1);
        kimya.addTeacher(t3);

        Student s1 = new Student("Genç", "23", "4", mat, fizik, kimya);
        s1.addExamNote(100,50,60);
        s1.addSpeakingExamNote(80,70,60);
        s1.isPass();

        Student s2 = new Student("Fatma", "48", "4", mat, fizik, kimya);
        s2.addExamNote(10,50,70);
        s2.addSpeakingExamNote(53,23,65);
        s2.isPass();

        Student s3 = new Student("Tamer", "80", "4", mat, fizik, kimya);
        s1.addExamNote(55,89,48);
        s1.addSpeakingExamNote(32,100,67);
        s3.isPass();
    }
}
