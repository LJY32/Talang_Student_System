package studentdata;
public class Student {
    private String name;
    private int id;
    private int chineseScore;
    private int mathScore;
    private int englishScore;
    private int totalScore;

    public Student(String name, int id, int chineseScore, int mathScore, int englishScore) {
        this.name = name;
        this.id = id;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.totalScore = chineseScore + mathScore + englishScore;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}