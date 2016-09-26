import java.util.Random;

/**
 * Created by Tomasz on 26.09.2016.
 */
public class Account {
    private double balance;
    private String name;
    private Random random = new Random();

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public Account(double balance, String name) {

        this.balance = balance;
        this.name = name;
    }

    public synchronized void withdraw() {
        System.out.println(Thread.currentThread().getName());
        try{
            System.out.println("Balance before transaction" + balance);
            if(balance > 0){
                balance = balance - random.nextInt(50);
                System.out.println("Balance after transaction" + balance);
            }
            else
                throw new NotEnoughExeption("Not enough money");

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}