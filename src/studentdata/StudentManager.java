package studentdata;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printAllStudents() {
        System.out.println("Name\tID\tChinese\tMath\tEnglish\tTotal");
        for (Student student : students) {
            System.out.println(student.getName() + "\t" + student.getId() + "\t" + student.getChineseScore() + "\t" + student.getMathScore() + "\t" + student.getEnglishScore() + "\t" + student.getTotalScore());
        }
    }
}