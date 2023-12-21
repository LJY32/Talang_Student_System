package studentdata;
import java.util.ArrayList;
import files.*;
public class StudentManager {
    public static ArrayList<Student> students;

    public StudentManager() { //创建一个ArrayList用于存放信息，并且把csv里的数据载入students中
        students = new ArrayList<>();
        CsvOperation csvOperation = new CsvOperation();
        students = csvOperation.loadStudentsFromCSV();
    }
    public void addStudent(Student student) { //在students中增加一行信息，并使用writeToFile写入csv
        students.add(student);
        CsvOperation.writeToFile();
    }
    public void deleteStudent(String id) { //遍历students，当学号相等时删除
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
        System.out.println("姓名\t学号\t语文成绩\t数学成绩\t英语成绩\t总分");
        for (Student student : students) {  //遍历输出
            System.out.println(student.getName() + "\t" + student.getId() + "\t" + student.getChineseScore() + "\t" + student.getMathScore() + "\t" + student.getEnglishScore() + "\t" + student.getTotalScore());
        }
    }

}