
package opp;

import java.util.Scanner ;
import java.text.ParseException;
import java.util.ArrayList ;
import java.util.Date ;
import java.text.SimpleDateFormat ;
import java.util.logging.Level;
import java.util.logging.Logger;

class Student {
    public String id , fullname , major ;
    public float gpa ;
    Date birthday ;
    public void Student (String id , String fullname , String major , float gpa , Date birthday ) {
        this.id = id ;
        this.fullname = fullname ;
        this.major = major ;
        this.gpa = gpa ;
        this.birthday = birthday ;
    }
    
    public void Enter (){
        Scanner input = new Scanner (System.in);
        System.out.println("Enter your id : "); id = input.nextLine() ;
        System.out.println("Enter your fullname : "); fullname = input.nextLine() ;
        System.out.println("Enter your major : "); major = input.nextLine() ;
        System.out.println("Enter your gpa : "); gpa = input.nextFloat();
        System.out.println("Enter you birthday "); input.nextLine() ;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat ("dd MM yyyy") ;
            birthday = sdf.parse(input.nextLine()) ;
        }
        catch (ParseException e) {
            System.out.println("dinh dang ngay sinh khong hop le");
        }
    }
    public void EditById () {
        Scanner input = new Scanner (System.in);
        System.out.print("nhap ten can sua : ");
        fullname = input.nextLine() ;
        System.out.print("nhap cong viec can sua : ");
        major = input.nextLine() ;
        System.out.print("nhap gpa can sua : ");
        gpa = input.nextFloat();
        System.out.print("nhap ngay sinh can sua : "); input.nextLine() ;
        
        SimpleDateFormat sdf = new SimpleDateFormat ("dd MM yyyy") ;
        try {
            birthday = sdf.parse(input.nextLine()) ;
        } catch (ParseException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void print () {
         SimpleDateFormat sdf = new SimpleDateFormat ("dd MM yyyy") ;
        System.out.println("Id : " + id);
        System.out.println("fullname : " + fullname);
        System.out.println("major : " + major);
        System.out.println("gpa : " + gpa);
        System.out.println("birthday  : " + sdf.format(birthday));
        System.out.println("------------------------");
    }
}
class StudentList  {
    ArrayList<Student> s1 = new ArrayList<> () ;
    public void AddStudent (Student a ) {
        s1.add(a) ;
    }
    public void PrintSv () {
        if (s1.isEmpty()) {
            System.out.println("danh sach sv trong ");
        }
        else {
            for (Student x : s1) {
                x.print(); 
            }
        }
    }
    public void DeleteSv (String id ) {
        for(Student x : s1 ) {
            if (x.id.equals(id)) {
                s1.remove(x) ;
                System.out.println("Da xoa thanh cong");
                break ;
            }
        }
    }
    public void EditIdStudent (String id) {
        for(Student x : s1 ) {
            if (x.id.equals(id)) {
               x.EditById();
                System.out.println("thanh cong !!");
                return ;
            }
            else {
                System.out.println("id sv can chinh sua kh dung !");
            }
        }
    }
} 
public class Opp {
public static void main (String[] args ) {
        StudentList a  = new StudentList () ;
        Scanner input = new Scanner (System.in);
        while (true ) {
            System.out.println("------------BANG SINH VIEN-----------");
            System.out.println("1.Nhap sinh vien");
            System.out.println("2.In ra danh sach sinh vien");
            System.out.println("3.Xoa sinh vien theo id ");
            System.out.println("4.Chinh sua sv theo id ");
            System.out.println("5.Thoat ");
            System.out.print("Nhap lua chon : "); 
            int lc = input.nextInt() ;
            switch (lc) {
                case 1 :
                    Student s1 = new Student () ;
                     s1.Enter(); 
                    a.AddStudent(s1);
                    break ;
                case 2 :
                    a.PrintSv(); 
                    break ;
                case 3 :
                    System.out.print("Nhap id sv ban can xoa :");
                    input.nextLine() ;
                    String idDelete = input.nextLine() ;
                    a.DeleteSv(idDelete);
                    break ;
                case 4 :
                    input.nextLine() ;
                    System.out.print("Nhap id sv can sua : ");
                    String id = input.nextLine() ;
                    a.EditIdStudent(id);
                    break ;
                case 5 : 
                    System.out.println("good byee");
                    return ;
            }
        }
    }
}
