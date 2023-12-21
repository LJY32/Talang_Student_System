package files;
import studentdata.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvOperation {
    private static final String csvFilePath = "students.csv";

    public ArrayList<Student> loadStudentsFromCSV() {
        ArrayList<Student> students = new ArrayList<>(); //新建一个ArrayList
        try {
            Scanner scanner = new Scanner(Files.newInputStream(Paths.get(csvFilePath)));
            scanner.nextLine(); // 跳过标题行，从第二行读起
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 6) { // 确保每行有5个字段
                    String name = data[0];
                    String id = data[1];
                    int chineseScore = Integer.parseInt(data[2]);//分数转化为int
                    int mathScore = Integer.parseInt(data[3]);
                    int englishScore = Integer.parseInt(data[4]);
                    int totalScore = Integer.parseInt(data[5]);
                    students.add(new Student(name, id, chineseScore, mathScore, englishScore,totalScore)); //添加给students
                } else {
                    System.out.println("写入数据时发生错误: " + line);
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }


    public static void writeToFile() {
        try {
            cleanData();
            FileWriter writer = new FileWriter(csvFilePath,true); //使用追加模式
            for (Student student : StudentManager.students) {
                writer.append(student.getName());
                writer.append(",");
                writer.append(student.getId());
                writer.append(",");
                writer.append(String.valueOf(student.getChineseScore()));
                writer.append(",");
                writer.append(String.valueOf(student.getMathScore()));
                writer.append(",");
                writer.append(String.valueOf(student.getEnglishScore()));
                writer.append(",");
                writer.append(String.valueOf(student.getTotalScore()));
                writer.append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("写入学生数据时发生错误");
            e.printStackTrace();
        }
    }
    private static void cleanData(){
        try{
            FileWriter writer = new FileWriter(csvFilePath);
            writer.write("");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
