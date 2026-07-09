public class GradeMethod {
    public static void main(String[] args) {
        int javaScore = 80 , englishScore = 70 , mathScore = 60;
        double average = calculateAverage(javaScore, englishScore, mathScore) ;
        String grade = getGrade(average) ;

        System.out.println("Average="+average);
        System.out.println("Grade="+grade);
    }

    public static double calculateAverage(int javaScore, int englishScore, int mathScore){
        return(javaScore+englishScore+mathScore) / 3;
    }

    public static String getGrade(double average){
        if(average >= 90){
            return"A" ;
        }else if(average >= 80){
            return"B" ;
        }else if(average >=70){
            return"C" ;
        }else if(average >=60){
            return"D" ;
        }else
            return"F" ;
    }
}
/*
課堂實作題
建立 GradeMethod.java，寫兩個方法：

public static double calculateAverage(int javaScore, int englishScore, int mathScore)
public static String getGrade(double average)
getGrade() 依照平均分數回傳 A、B、C、D、F。
 */