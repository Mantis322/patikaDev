public class Course {
    Teacher teacher;
    String name;
    String code;
    String prefix;
    int note;
    int speakingNote;

    Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0;
        this.speakingNote = 0;

    }

    void addTeacher(Teacher teacher) {
        if (this.prefix.equals(teacher.branch)) {
            this.teacher = teacher;
        } else {
            System.out.println("Öðretmen ve ders uyuþmazlýðý");
        }
    }

    void printTeacher() {
        System.out.println(this.teacher);
    }
}
