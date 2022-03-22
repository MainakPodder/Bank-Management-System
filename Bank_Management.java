import java.util.Scanner;
import java.io.*;
class account{
   String name;
   int acc_num,year;
   double balance;
    void Customer_Get_Details(){
        Scanner input_a=new Scanner(System.in);
        System.out.println("Enter your name:");
        name=input_a.nextLine();
        System.out.println("Enter your account number:");
        acc_num=input_a.nextInt();
        System.out.println("Enter your balance:(Min.1000/-)");
        do{
            balance=input_a.nextDouble();
            if(balance>=1000){
                break;
            }
            else{
                System.out.println();
                System.out.println("Oops!Your balance less than 1000.");
                System.out.println("Let's try again!");
                System.out.println();
                System.out.println("Plese,Re-enter your balance.");
            }   
        }while(balance<1000);
    System.out.println();
    }
    //input_a.close();
    void Customer1_Get_Details(){
        Scanner input_a=new Scanner(System.in);
        System.out.println("Enter your name:");
        name=input_a.nextLine();
        System.out.println("Enter your account number:");
        acc_num=input_a.nextInt();
        System.out.println("Enter the year:");
        year=input_a.nextInt();
        System.out.println("Enter your balance:(Min.1000/-)");
         do{
            balance=input_a.nextDouble();
            if(balance>=1000){
                break;
            }
            else{
                System.out.println();
                System.out.println("Oops!Your balance less than 1000.");
                System.out.println("Let's try again!");
                System.out.println();
                System.out.println("Plese,Re-enter your choice.");
            }   
        }while(balance<1000);
    }
    void Customer_Show_Details(int choice){
        System.out.println();
        System.out.println("Your Details:-");
        System.out.println("Your name:"+name);
        System.out.println("Your Account NUmber:"+acc_num);
        if(choice==1)
        System.out.println("Your Account Type is:Current");
        else
        System.out.println("Your Account Type is:Saving");
        System.out.println("Your balance:"+balance);
        System.out.println();
    }
    void Customer1_Show_Details(int choice){
        System.out.println();
        System.out.println("Your Details:-");
        System.out.println("Your name:"+name);
        System.out.println("Your Account NUmber:"+acc_num);
        if(choice==1)
        System.out.println("Your Account Type is:Current");
        else
        System.out.println("Your Account Type is:Saving");
        System.out.println("Your balance:"+balance);
        System.out.println("Your year:"+year);
        System.out.println();
    }
}
class cur_acc extends account{
    public void Deposite_C(){
       double deposite_c;
        Scanner input_c=new Scanner(System.in);
        System.out.println("Enter the ammount you want to deposite:");
        deposite_c=input_c.nextDouble();
        balance=balance+deposite_c;
        System.out.println("!!!Money Deposited!!!");
    }
    public void Withdrawl_C(){
        double withdrawl_c;int panalty=50;
        String reciver_name;
        Scanner input_c=new Scanner(System.in);
        System.out.println("Enter the name of cheque reciver:");
        reciver_name=input_c.nextLine();
        System.out.println("Enter the amount of money:");
        withdrawl_c=input_c.nextDouble();
        if(balance-withdrawl_c>50){
            if(balance-withdrawl_c<500 && balance-withdrawl_c>=100){
                System.out.println("We are imposing panalty(50/-) for low minimum balance.");
                balance=balance-(withdrawl_c+panalty);
                //System.out.println("Reciver Name:"+reciver_name);
                System.out.println("!!!Transaction Successfull!!!");
            }
            else if(balance-withdrawl_c<500 && balance-withdrawl_c<100 && balance-withdrawl_c<=50){
                System.out.println("Transaction cannot be done.");
            }
            else{
                balance=balance-withdrawl_c;
                System.out.println("!!!Transaction Successfull!!!");
            }
        }
        else{
            System.out.println("Transaction cannot be done.");
        }
    }
}
class sav_acc extends account{
    public void Deposite_S(){
        double deposite_s;
        Scanner input_s=new Scanner(System.in);
        System.out.println("Enter the ammount you want to deposite:");
        deposite_s=input_s.nextDouble();
        balance=balance+deposite_s;
        System.out.println("!!!Money Deposited!!!");
    }
    public void Withdrawl_S(){
        double withdrawl_s;
        Scanner input_s=new Scanner(System.in);
        System.out.println("Enter the amount of money:");
        withdrawl_s=input_s.nextInt();
        if(balance-withdrawl_s>50){
            if(balance==0){
                System.out.println("Transaction cannot be done.");
            }
            else{
                balance=balance-withdrawl_s;
                System.out.println("!!!Transaction Successfull!!!");
            }
        }
        else{
            System.out.println("Transaction cannot be done.");
        }
    }
    public void Interest_S(){
        double rate=5.4;
        Scanner input_s=new Scanner(System.in);
        double interest=balance*(Math.pow((1+rate/100),year));
        System.out.println("Your Interest:"+interest);
        balance=balance+interest;
    }
}
class Bank_Management {
    public static void main(String[] args) {
        System.out.println("--------------------------------Account--------------------------------");
        System.out.println("1.Current Account                         2.Saving Account");
        System.out.println("a)No Interest                             a)Compound Interest(5%)");
        System.out.println("b)Cheque-book Facility                    b)Withdrawl Facility");
        System.out.println("c)Maintaina minimun balance(500/-)        c)No Cheque-book Facility");
        System.out.println("\n");
        System.out.println("!!!ATTENTION PLESE!!!");
        System.out.println("->If you want to open a bank account,you have to pay 1000/- rupees.");
        System.out.println("->Current account holders should also maintaina minimun balance(500/-),otherwise a servise charge(50/-) will be imposed.");
        System.out.println("\n");
        System.out.println("What kind of account do you want to open?");
        System.out.println("Press (1) for Current Account.");
        System.out.println("Press (2) for Sevings Account.");
        System.out.println("Press (3) for Exit.");
        int choice;
        Scanner input=new Scanner(System.in);
        do{
        choice=input.nextInt();
            switch(choice)
            {
                case 1:int choice_c,create_c; 
                       cur_acc obj_c=new cur_acc(); 
                       System.out.println("-------------------------Current Account-------------------------"); 
                       do{
                          System.out.println("Press (1) for Create a new account.");
                          create_c=input.nextInt();
                            switch(create_c) {
                                case 1:obj_c.Customer_Get_Details();
                                        break;
                                default:System.out.println();
                                        System.out.println("Oops!Something went wrong.");
                                        System.out.println("Let's try again!");
                                        System.out.println();
                                        System.out.println("Plese,Re-enter your choice.");
                                        break;
                            }         
                        }while(create_c!=1);
                     do{
                        System.out.println();
                        System.out.println("Your Options:-");
                        System.out.println("Press (1) for Deposite.");
                        System.out.println("Press (2) for Withdrawl.(Cheque)");
                        System.out.println("Press (3) for Details.");
                        System.out.println("Press (4) for Exit.");
                        choice_c=input.nextInt();
                            switch(choice_c){
                            case 1:obj_c.Deposite_C();
                                   break;
                            case 2:obj_c.Withdrawl_C();
                                   break;
                            case 3:obj_c.Customer_Show_Details(choice);
                                   break;
                            case 4:System.out.println("Exit");
                                    return;
                            default:System.out.println("Oops!Something went wrong.");
                                    System.out.println("Let's try again!");
                                    System.out.println();
                                    System.out.println("Plese,Re-enter your choice.");
                                    break;
                            }
                       }while(choice_c!=4);            
                case 2:int choice_s,create_s;
                       sav_acc obj_s=new sav_acc();
                       do{
                          System.out.println("-------------------------Savings Account-------------------------"); 
                          System.out.println("Press (1) for Create a new account.");
                          create_s=input.nextInt();
                            switch(create_s) {
                                case 1:obj_s.Customer1_Get_Details();
                                       break;
                                default:System.out.println("Oops!Something went wrong.");
                                        System.out.println("Let's try again!");
                                        System.out.println();
                                        System.out.println("Plese,Re-enter your choice.");
                                        break;
                            }
                        }while(create_s!=1); 
                       do{
                       System.out.println();
                       System.out.println("Your Options:-");
                       System.out.println("Press (1) for Deposite.");
                       System.out.println("Press (2) for Withdrawl.");
                       System.out.println("Press (3) for Interest.(Compound)");
                       System.out.println("Press (4) for Details.");
                       System.out.println("Press (5) for Exit.");
                       choice_s=input.nextInt();
                            switch(choice_s){
                                case 1:obj_s.Deposite_S();
                                       break;
                                case 2:obj_s.Withdrawl_S();
                                       break;
                                case 3:obj_s.Interest_S();
                                       break;
                                case 4:obj_s.Customer1_Show_Details(choice);
                                       break;
                                case 5:System.out.println("Exit");
                                       return;
                                default:System.out.println("Oops!Something went wrong.");
                                        System.out.println("Let's try again!");
                                        System.out.println();
                                        System.out.println("Plese,Re-enter your choice.");
                                        break;
                       }

                   }while(choice_s!=5);
                case 3:System.out.println("Exit");
                       return;
                default:System.out.println();
                        System.out.println("Oops!Something went wrong.");
                        System.out.println("Let's try again!");
                        System.out.println();
                        System.out.println("Plese,Re-enter your choice.");
                        break;
            }
        }while(choice>3);   
    }
}
