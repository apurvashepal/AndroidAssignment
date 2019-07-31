import java.util.*;
import java.util.Scanner;

public class NumberOperation{
        /**
        *Function to print number from 1 to 100
        * input
        * output: 1 to 100 series
        */
        private void printNumbers() {
            
                for(int number=1;number<=100;number++)
                System.out.print(number +" ");        
            }
            
        /**
        *Function to test Divisibility by 3 & 7 in 1 to 100
        *input: - 
        *output: numbers Divisible by 3 & 7
        */
        private void divisibilityTest()
            {  int number=1;
                System.out.println("numbers Divisible by 3 and 7 in 1 to 100 ");
                while(number<101)
                    {
                    if (number % 3 == 0 && number % 7 == 0){
                        System.out.print(number + " ");  
                    }
                    else { 
                        number++;
                        continue;
                        }
                number++;
                }
            }
        /**
            *Function to calculate factorial of number
            *input  : int 
            *Return :int
         */
        private int CalculateFactorial(int num){
                int factorial=1;
                while(num != 0)
                {
                    factorial=factorial * num ;
                    num--;
                }
                return factorial;
            }

        private boolean Isprime(int num){
                int checkcondiion= num/2;
                while(checkcondiion > 1){
                    
                    if(num % checkcondiion != 0)
                    checkcondiion--;
                    
                    
                    else 
                    return false;
                    }
        
                    return true;
                }
                /**
                *Function to print Fibonacci Series
                *int : input
                *Return : -
                */
        private void fibonacci_series(int num){
        /* 
            Function will print Fibonacci Series for the number of terms user has enetered  */
                    int numzero=0;
                    int num1=1;
                    int num2=1;
                    int num3;
                    System.out.print(numzero + " "+ num1 +" " +num2+" ");
                    for(int count=0; count<=num-3;count++)
                    {
                    
                        num3= num1+num2;
                        System.out.print(num3+ " ");
                        num1=num2;
                        num2=num3;
                    }
                }

        private boolean IsPalindrome(int num){           
            /* 
            The function will check weather string is palindrome or not by reversing the number 
            and comaparison. 
            */
            try{
                    int reverse=0 ,rem;
                    int num1=num;
                    while(num1>0)
                    {
                        rem=num1%10;
                        reverse=reverse*10 +rem ;
                        num1=num1/10;
                        
                    }
                    if(num==reverse)
                    return true;
                
                    else 
                    return false;
                    }catch(Exception ex){
                        System.out.print(ex );
                    }
                }



        public static void main(String Args[])
         {
        //System.out.println("1.print numbers 1 to 100  2.print numbers which are divisible by 3 and 7 in range 1 to 100 3.calculateFactorial(no)  4.isPrime(no)  5.isPalindrome(no)   6.fibonaccii_series(no) 7.exit()  Enter Your choice");
        Scanner inputObj = new Scanner(System.in);
         char ch;
    do{  
      int choice=inputObj.nextInt();
        switch(choice){
                case 1: 
                        NumberOperation numberPrint =  new NumberOperation();
                        numberPrint.printNumbers();
                        break;
                case 2:        
                        NumberOperation numberDivisibility = new NumberOperation();
                        numberDivisibility.divisibilityTest(); 
                        break;
                case 3:        
                        NumberOperation factorialObj = new NumberOperation();
                        System.out.print("Enter number to calculate factorial for");
                        int inputFact =inputObj.nextInt();
                        int  factorial = factorialObj.CalculateFactorial(inputFact);
                        System.out.print(factorial);
                        break;
                case 4:  
                        System.out.print("Enter to check Prime number");
                        NumberOperation primeCheck = new NumberOperation();
                        int numberP = inputObj.nextInt();
                        boolean numPrime = primeCheck.Isprime(numberP);
                        if (numPrime==true)
                        System.out.print("Prime Number");
                        else
                        System.out.print("  Not Prime Number");
                        break;
                case 5:  
                        System.out.print("Enter size of Fibonacci series");
                        NumberOperation fibSeries = new NumberOperation();
                        int numberF = inputObj.nextInt();
                        fibSeries.fibonacci_series(numberF);
                        break;

                case 6: 
                      try{
                        System.out.print("Enter number to check wheather it is palindrome or not");
                        NumberOperation palindromeCheck = new NumberOperation();
                        int numberPalindrome = inputObj.nextInt();
                        boolean numPalindrom = palindromeCheck.IsPalindrome(numberPalindrome);
                        
                        if (numPalindrom==true) 
                            System.out.print("Number is a Palindrome");
                        else 
                            System.out.print("Not a palindrome");
                    
                    }catch(Exception ex){
                        System.out.print("Exception occured");
                     }

                    break;
                case 7: System.exit(0); 
                    }
        System.out.print("Do you want to continue? Y/N");
        ch=inputObj.next().charAt(0);
        }while(ch =='y'|| ch =='Y');
        }
}