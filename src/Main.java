import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Login page");
        String userName="";
        String password;
        boolean success=false;
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter your username");
            userName= input.next();
            System.out.println("Please enter your password");
            password= input.next();

            if(login(userName,password)){
                success=true;
                break;
            }
            System.out.println("username or password is not correct");
        }

        if (!success){
            System.out.println("Failed to login try again in 15 minutes");
            terminator();
        }
        //example of user data since I don't have a database
        int[] userData = {111,17};

        int choice;
        while(true){
            System.out.println("to check your profile type 1");
            System.out.println("to start the next challenge type 2");//since I didn't have challenges when you choose this you will have a random chance of succeeding or failing
            System.out.println("to logout type 3");
            choice=input.nextInt();
            switch (choice){
                case 1: profile(userName,userData);break;
                case 2: userData=challenge(userData);break;
                case 3:
                    System.out.println("logout successful see you later " + userName);
                    terminator();
                default:
                    System.out.println("Please enter one of the following numbers:");
            }

        }

    }

    public static boolean login(String userName,String password){

        if ((userName.equalsIgnoreCase("Waleed") && password.equals("12345678"))) {
            System.out.println("Welcome " + userName);
            return true;
        }
        return false;
    }

    public static void profile(String userName,int[]userData){
        System.out.println("\n");
        System.out.println("Name: " + userName);
        System.out.println("passed challenges: "+userData[0]);
        System.out.println("remaining challenges: "+userData[1]);
        System.out.println("\n");
    }

    public static int[] challenge(int[]userData){
        System.out.println("\n");
        if(((int)(Math.random()*100))%2==0){
            System.out.println("You passed the challenge");
            userData[0]+=1;
            userData[1]-=1;
        }
        else
            System.out.println("You failed the challenge");
        System.out.println("\n");
        return userData;
    }

    public static void terminator(){
        System.exit(0);
    }
}