import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Tomasz on 26.09.2016.
 */
public class TransactionManager implements Runnable {

    private Account account;

    public TransactionManager(Account account) {
        this.account = account;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TransactionManager(new Account(1000.00, "Tom")));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++){
            executorService.execute(thread);
        }

    }

    @Override
    public void run() {
        account.withdraw();

    }
}
