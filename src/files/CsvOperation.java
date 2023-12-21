package files;

import studentdata.*;
import java.io.FileWriter;
import java.io.IOException;

public class CsvOperation {
    private static final String csvFilePath = "students.csv";
    public static void writeToFile() {//这个函数得改
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
