

import java.util.Scanner;
public class SuperMarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Scanner sc =new Scanner(System.in);
   Cloth c=new Cloth();
   Customer a=new Customer();
   Electronic b=new Electronic();
   Food f=new Food();
   Stafff d=new Stafff();
   Stationary11 e=new Stationary11();
   int x =0;
   do {
	   System.out.println("\nlist:\nPress 1:Cloth\nPress 2:Customer\nPress 3:Electronic\nPress 4:Food\nPress 5:Staff\nPress 6:Stationart");
   
   x=sc.nextInt();
   switch (x) {
     case 1:
   c.display();
         break;
     case 2:
   a.display();
         break;
     case 3:
    b.display();
    	break;
	 case 4:
    f.display();
	    break;
     case 5:
    d.display();
        break;
    case 6:
    e.display();
   }}
	 while(x!=0);


	}}
