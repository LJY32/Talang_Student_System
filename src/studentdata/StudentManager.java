package studentdata;
import java.util.ArrayList;
import files.*;
public class StudentManager {
    public static ArrayList<Student> students;
    public StudentManager() {
        students = new ArrayList<Student>();
    }

    public void addStudent(Student student) {
        students.add(student);
        CsvOperation.writeToFile();
    }
    public void deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                CsvOperation.writeToFile();
                return;
            }
        }
        System.out.println("找不到对应学号的学生： " + id);
    }
    public void findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("姓名: " + student.getName());
                System.out.println("学号: " + student.getId());
                System.out.println("总分: " + student.getTotalScore());
                return;
            }
        }
        System.out.println("找不到对应学号的学生: " + id);
    }
    public void printAllStudents() {
        System.out.println("Name\tID\tChinese\tMath\tEnglish\tTotal");
        for (Student student : students) {
            System.out.println(student.getName() + "\t" + student.getId() + "\t" + student.getChineseScore() + "\t" + student.getMathScore() + "\t" + student.getEnglishScore() + "\t" + student.getTotalScore());
        }
    }
}