package studentdata;
public class Student {
    private final String name;
    private final String id;
    private final int chineseScore;
    private final int mathScore;
    private final int englishScore;
    private final int totalScore;

    public Student(String name, String id, int chineseScore, int mathScore, int englishScore) {
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

    public String getId() {
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