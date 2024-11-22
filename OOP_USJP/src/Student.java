import java.util.regex.Pattern;
public class Student {
    private String studentName;
    private String studentEmail;
    private char studentGender;


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getStudentName() {
        return studentName;
    }


    public void setStudentEmail(String studentEmail) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (Pattern.matches(emailRegex , studentEmail)){
            this.studentEmail= studentEmail;
        }else{
            throw  new RuntimeException("Email must Contain @ and . ");
        }
        this.studentEmail = studentEmail;
    }


    public String getStudentEmail() {
        return studentEmail;

    }


    public void setStudentGender(char studentGender) {
        if (studentGender == 'M' || studentGender == 'F'|| studentGender=='f' || studentGender=='m') {
            this.studentGender = studentGender;
        } else {
            throw new IllegalArgumentException("Gender must be 'M' or 'F'");
        }
    }


    public char getStudentGender() {
        return studentGender;
    }
}
