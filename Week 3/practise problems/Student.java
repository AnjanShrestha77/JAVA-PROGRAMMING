public class Student {
    //private instance variables:
   private String studentId;
  private String name;
  private double grade;
  private String course;
  Student(){
studentId="RA1";
name="ANJAN SHRESTHA";
grade=100;
course="DSA";     
  }
//Parameterized constructor
Student(String studentId,String name,double grade,String course){
    this.studentId=studentId;
    this.name=name;
    this.grade=grade;
    this.course=course;
}
// setter methods
void setName(String Name){
    name=Name;
}
void setStudentId(String id){
   studentId=id;
}
void setGrade(double gra){
    grade=gra;
}
void setCourse(String cour){
    course=cour;
}

//getter methods
String getName(){
    return name;
}
String getStudentId(){
return studentId;
}
String getCourse(){
    return course;
}

double getGrade(){
    return grade;
}

//method to calculate letter grade
char calculateLetterGrade(){
    char letterGrade=' ';
    if (grade>=90){
        letterGrade='A';
 }
 else if (grade>=80&&grade<90){
    letterGrade='B';
 }
  else if (grade>=70&&grade<80){
    letterGrade='C';
 } else if (grade>=60&&grade<70){
    letterGrade='D';
 } else if (grade<60){
    letterGrade='F';
 }
 return letterGrade;
}
void displayInfo(){
    System.out.println("StudentID: "+studentId);
        System.out.println("Student name: "+name);
    System.out.println("Grade: "+grade);
    System.out.println("Course: "+course);
}

public static void main(String [] args){
    Student s1=new Student();
    Student s2=new Student("AR11","KAIRI LIMBU",98,"app");
    // setter methods
    s1.setCourse("MATH");
    s1.setName("SKYALR TAMANG");
    s1.setGrade(34);
    s1.setStudentId("RQ23");

    //getter methods demo
    System.out.println("using getter methods");
    System.out.println("Name of the student in object1:"+s1.getName());
    System.out.println("Student ID:"+s1.getStudentId());
    System.out.println("Grade :"+s1.getGrade());

    //displaying the information including letter grade
    System.out.println("Details of student1 :");
    s1.displayInfo();
    System.out.println("Grade: "+s1.calculateLetterGrade());
    System.out.println("Details of student2 :");
    s2.displayInfo();
    System.out.println("Grade: "+s2.calculateLetterGrade());

}
}
