// package package1;
import java.util.*;


// import importedPackage.*;  ///importing pacakage


class auth{  //authentication class auth
	String username;
	String password;
	public auth() {  //default constructor
		username=null;
		password=null;
	}
	public auth(String username,String password) {  //parameterized constructor
		this.username=username;
		this.password=password;
	}
	public boolean check(String u,String p) {
		boolean a=u.equals(username);
		boolean b=p.equals(password);
		if(a && b) {
			return true;
		}
		else {
			return false;
		}
	}
}

class personalDetails{
	String name;
	int age;
	String mobileNumber;
	String aadharNo;
	public personalDetails() {
		name=null;
		age=0;
		mobileNumber=null;
		aadharNo=null;
	}
	public personalDetails(String name,int age,String mobileNumber,String aadharNo) {
		this.name=name;
		this.age=age;
		this.mobileNumber=mobileNumber;
		this.aadharNo=aadharNo;
	}
	
	public void showReport() {
		System.out.println("---------------------PERSONAL DETAILS----------------------");
		System.out.println("  NAME -         "+ name);
		System.out.println("  AGE -          "+ age);
		System.out.println("  MOB NO -       "+mobileNumber);
		System.out.println("  AADHAR NO-     "+aadharNo);
		System.out.println("------------------------------------------------------------");
	}
	
	
}

class vaccineDetails extends personalDetails{  //inheritance
	String userID;
	String vaccineName;
	int doseCount;
	String centre;
	public vaccineDetails(){
		super();
		userID=null;
		vaccineName=null;
		doseCount=0;
		centre=null;
	}
	public vaccineDetails(String name,int age,String mobileNumber,String aadharNo,String userID,String vaccineName,int doseCount,String centre){
		super(name,age,mobileNumber,aadharNo);
		this.userID=userID;
		this.vaccineName=vaccineName;
		this.doseCount=doseCount;
		this.centre=centre;
	}
	
	public void showReport(int days,String feedback) {  //method overriding
		System.out.println("----------------------------VACCINATION CERTIFICARE---------------------------------");
		System.out.println("    NAME -                  "+ name);
		System.out.println("    AGE -                   "+ age);
		System.out.println("    MOB NO -                "+mobileNumber);
		System.out.println("    AADHAR NO-              "+aadharNo);
		System.out.println("    userID-                 "+userID);
		System.out.println("    Vaccine Name-           "+vaccineName);
		System.out.println("    Dose Number-            "+doseCount);
		System.out.println("    Vaccination Centre-     "+centre);
//		if(vaccineName.equalsIgnoreCase("covaxin")) {
//			days=30;
//		}
//		else if(vaccineName.equalsIgnoreCase("covishield")) {
//			days=90;
//		}
		if(doseCount==1) {
			System.out.println("    Your next scheduled slot is after "+days+" days");
		}
		else if(doseCount==2){
			System.out.println("    You have successfully completed your 2 doses of covid-19 vaccination.");
		}
		
		System.out.println("    Feedback-     "+feedback);
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	
	
}

class RTPCR extends personalDetails{  //inheritance
	String sampleID;
	String sampleCollectionDate;
	String resultDate;
	String centre;
	
	public RTPCR(){
		super();
		sampleID=null;
		sampleCollectionDate=null;
		resultDate=null;
		centre=null;
	}
	public RTPCR(String name,int age,String mobileNumber,String aadharNo,String sampleID,String sampleCollectionDate,String resultDate,String centre) {
		super(name,age,mobileNumber,aadharNo);
		this.sampleID=sampleID;
		this.sampleCollectionDate=sampleCollectionDate;
		this.resultDate=resultDate;
		this.centre=centre;
		
	}
	
	public void showReport(int testResult) {
		String s=null;
		if(testResult==1) {
			s="POSITIVE";
		}
		else if(testResult==2){
			s="NEGATIVE";
		}
		System.out.println("-------------------------RT-PCR REPORT-------------------------------");
		System.out.println("  NAME -                      "+ name);
		System.out.println("  AGE -                       "+ age);
		System.out.println("  MOB NO -                    "+mobileNumber);
		System.out.println("  AADHAR NO-                  "+aadharNo);
		System.out.println("  Sample ID-                  "+sampleID);
		System.out.println("  Sample Collection Date-     "+sampleCollectionDate);
		System.out.println("  Report Date-                "+resultDate);
		System.out.println("  Test centre-                "+centre);
		System.out.println("  TEST RESULT-                "+s);
		System.out.println("----------------------------------------------------------------------");
		
	}
	
}


abstract class mobileSMS{  //abstract class 
	
	public void sendSMSforVaccine(String doseDate,int doseCount,String vaccineName,int days) {
		System.out.println("\n");
		String s=null;
		if(doseCount==1) {
			s="first";
		}
		else if(doseCount==2) {
			s="second";
		}
		System.out.println("--------------------------------------message sent-----------------------------------");
		System.out.println(" You have been vaccinated with your "+s+"shot of "+vaccineName+"." );
		if(doseCount==1) {
			System.out.println(" Your next scheduled slot is after "+days+" days");
		}
		else if(doseCount==2){
			System.out.println(" You have successfully completed your 2 doses of covid-19 vaccination");
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
	public void sendSMSforRTPCR(String resultDate,int testResult) {
		System.out.println("\n");
		String pOn=null;
		if(testResult==1) {
			pOn="Positive";
		}
		else {
			pOn="Negative";
		}
		System.out.println("------------------------------------message sent---------------------------------------------");
		System.out.println("This is to inform you that you have hbeen test covid "+pOn+" as on "+resultDate);
		if(testResult==1) {
			System.out.println("Please follow covid-19 guidielines and stay Safe");
		}
		System.out.println("----------------------------------------------------------------------------------------------");
	}
	
}

class generateMessage extends mobileSMS{
	//calling abstract class methods.
	
}

interface ifPositive{   //interface 
	
	public void showPositiveGuidelines();
}

class covidMeasures implements ifPositive{   //implementing interface
	public void showPositiveGuidelines() {
		System.out.println("Patient must isolate himself from other household members, stay in the identified room and away from\r\n"
				+ "other people in home, especially elderlies and those with co-morbid conditions like hypertension,\r\n"
				+ "cardiovascular disease, renal disease etc.\r\n"
				+ " The patient should be kept in a well-ventilated room with cross ventilation and windows should be kept\r\n"
				+ "open to allow fresh air to come in.\r\n"
				+ " Patient should at all times use triple layer medical mask. Discard mask after 8 hours of use or earlier\r\n"
				+ "if they become wet or visibly soiled. In the event of care giver entering the room, both care giver\r\n"
				+ "and patient may consider using N 95 mask.\r\n"
				+ " Mask should be discarded only after disinfecting it with 1% Sodium Hypochlorite.\r\n"
				+ " Patient must take rest and drink lot of fluids to maintain adequate hydration.\r\n"
				+ " Follow respiratory etiquettes at all times.\r\n"
				+ " Frequent hand washing with soap and water for at least 40 seconds or clean with alcohol-based\r\n"
				+ "sanitizer.\r\n"
				+ " Don�t share personal items with other people in the household.");
	}
	
}



//*********************generating random ID***************************

class RandomString {
	  
    // function to generate a random string of length n
    static String getAlphaNumericString(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
}


class creator  
{
    String name;
    String USN;
    String dept;
  
    public creator(String name,String USN,String dept)
    {
        this.name=name;
        this.USN=USN;
        this.dept=dept;
    }
  
    public void display(creator c)  //passing object as parameter
    {
       System.out.println("created by "+c.name+", "+c.USN +", dept: "+c.dept);
    }
}
//************************************************************************

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Covid Vaccine Certificate Generator");
		System.out.println("\n Note: only Admins can generate vaccine certificates.\nYou need to first LOGIN!");
		
//		*********************************************************************
		

		
		String name;
		int age=0;
		String mobileNumber;
		String aadharNo;
		String userID;
		String vaccineName;
		int doseCount=0;
		String sampleID;
		String sampleCollectionDate;
		String resultDate;
		String centre;
		int choice;
		int days=30;
		String feedback;
		String doseDate;
		int testResult;
//		*********************************************************************
		
		auth a1=new auth("user123","user123");
		
		
		String uname,pass;
		
		Scanner sc=new Scanner(System.in);  //scanner class
		System.out.println("Enter the username: ");
		uname=sc.next();
		System.out.println("Enter the password: ");
		pass=sc.next();
		boolean ans=a1.check(uname, pass);
		if(ans==true) {
			System.out.println("Successfully logged in!You are the Admin.");
			
			System.out.println("Enter personal details: ");
			
			System.out.println("Enter your name: ");
			name=sc.next();
			System.out.println("Enter your age: ");
			
			age=sc.nextInt();
			
			System.out.println("Enter your mobile number: ");
			mobileNumber=sc.next();
			System.out.println("Enter your aadhar No: ");
			aadharNo=sc.next();
			
			personalDetails p=new personalDetails(name,age,mobileNumber,aadharNo);
			p.showReport();
			
			System.out.println("Choose what you want to generate!");
			System.out.println("1. COVID Vaccine Certificate");
			System.out.println("2. RTPCR Test Report");
			System.out.println("Choose 1 or 2: ");
			
			
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: 
//				*************************for vaccine****************************
				
				System.out.println("System generating userID: ");
				userID=RandomString
                        .getAlphaNumericString(10);
				System.out.println("your user id is : "+userID);
				System.out.println("Enter the vaccine name you got: ");
				vaccineName=sc.next();
				System.out.println("dose count (Enter 1 for first dose, 2 for second dose): ");
				try {
				doseCount=sc.nextInt();
				}
				catch(InputMismatchException e) {
					System.out.println(e);
				}
				
				System.out.println("Enter the vaccination centre: ");
				centre=sc.next();
				System.out.println("Enter the vaccination date: ");
				
				doseDate=sc.next();
				
				vaccineDetails v=new vaccineDetails(name,age,mobileNumber,aadharNo,userID,vaccineName,doseCount,centre);
				
				
				if(vaccineName.equalsIgnoreCase("covaxin")) {
					days=30;
				}
				else if(vaccineName.equalsIgnoreCase("covishield")) {
					days=90;
				}
				
				
				System.out.println("Enter your valuable feedback");
				feedback=sc.next();
				v.showReport(days,feedback);
				System.out.println("\n");
				System.out.println("sending Mobile SMS... ");
				generateMessage gM=new generateMessage();
				
				gM.sendSMSforVaccine(doseDate,doseCount,vaccineName,days);
				
				
				
				
				
		
				
				break;
//				***********************for RTPCR**************************
			case 2:
				System.out.println("System generating sampleID: ");
				sampleID=RandomString
                        .getAlphaNumericString(10);
				System.out.println("your sample id is : "+sampleID);
				System.out.println("Enter the sample Collection Date : ");
				sampleCollectionDate=sc.next();
				System.out.println("Enter the report dateuser: ");
				resultDate=sc.next();
				System.out.println("Enter the place of test centre: ");
				centre=sc.next();
				
				
				RTPCR r=new RTPCR(name,age,mobileNumber,aadharNo,sampleID,sampleCollectionDate,resultDate,centre);
				
				System.out.println("Enter the RT-PCR test Result(positive--1/negative--0): ");
				
				testResult=sc.nextInt();
				r.showReport(testResult);
				System.out.println("\n");
				System.out.println("sending Mobile SMS... ");
				
				generateMessage gM2=new generateMessage();
				
				gM2.sendSMSforRTPCR(resultDate,testResult);
				System.out.println("\n");
				System.out.println("\n");
				if(testResult==1) {
					System.out.println("Follow these guidelines:  ");
					System.out.println("\n");
					
					covidMeasures cM=new covidMeasures();
					cM.showPositiveGuidelines();
					
				}
				
				
				
				
				break;
				
			default: System.out.println("wrong input!!!ReRun the program !!");	
			
			}
			
			
			
		}
		else {
			System.out.println("wrong credentials! App exited!");
			
		}
		System.out.println("--------------------imp COVID-19 Links-------------------------");
		
// 		govInfo g=new govInfo();
// 		g.start();
// 		g.join();
// 		System.out.println("---------------------------------------------------------------");
		
//		---------------------------my credentials-----------------------------------
		creator c1 = new creator("Ankur Hirwani","4NI20IS022","ISE 'A'");
		c1.display(c1);
	}
}
