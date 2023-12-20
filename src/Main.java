import java.util.Scanner;
import studentdata.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean quit = false;
        while (!quit) {
            System.out.println("1. 添加学生");
            System.out.println("2. 列出所有学生");
            System.out.println("3. 退出系统");
            System.out.print("请输入相应数字：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("请输入学生名: ");
                    String name = scanner.next();
                    System.out.print("请输入学号: ");
                    int id = scanner.nextInt();
                    System.out.print("请输入 "+name+" 的语文成绩:");
                    int chineseScore = scanner.nextInt();
                    System.out.print("请输入 "+name+" 的数学成绩:");
                    int mathScore = scanner.nextInt();
                    System.out.print("请输入 "+name+" 的英语成绩:");
                    int englishScore = scanner.nextInt();
                    Student student = new Student(name, id, chineseScore, mathScore, englishScore);
                    manager.addStudent(student);
                    break;
                case 2:
                    manager.printAllStudents();
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
        scanner.close();
    }
}