package newPack;

import java.util.Scanner;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) {

		System.out.println("Wellcome to My application ...");
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("PRESS 1 to ADD Student");
			System.out.println("PRESS 2 to Delete Student");
			System.out.println("Press 3 to display Student");
			System.out.println("PRESS 4 to exit app");

			int c = sc.nextInt();
			sc.nextLine();

			if (c == 1) {
				// add student 
				
				// gating the information for the user
				
				System.out.print("Enter a student name : ");
				String studentName = sc.nextLine();
				
				System.out.print("Enter a student phone number : ");
				String studentPhone = sc.nextLine();
				
				System.out.print("Enter a student City : ");
				String studentCity = sc.nextLine();
				
				// creating a Student object 
				
				Student st = new Student(studentName, studentPhone, studentCity);
				
				
				boolean ans = StudentDao.insertStudentToDb(st);
				
				if (ans) {
					System.out.println(st.toString());
					System.out.println("The above student added successfully ...");
				} else {
					System.out.println("Something gatting wrong ...");
				}
				
			
			} else if (c == 2) {
				
				// delete a Student form the database 
				
				System.out.print("Enter a student id to delete the student : ");
				int sid = sc.nextInt();
				sc.nextLine();
				
				boolean ans = StudentDao.deleteStudent(sid);
				
				if (ans) {
					System.out.println(sid + "is deleted successfully ...");
				} else {
					System.out.println("Something gatting wrong ...");
				}
			
			} else if (c == 3) {
				
				// show all the students form the database 
				
				StudentDao.showAllStudent();
			
			} else if (c == 4) {
				// exit

				break;
			} else {
				// if the user do nothing then else block execute and program run again
			}
			
			
		}
		
		System.out.println("Thank you for using my application ....");
		System.out.println("See you soon ... Bye Bye ");
 	}

}
