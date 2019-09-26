import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class StrStJavThread implements Runnable {

    private Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private int interval;

    public StrStJavThread(int interval) {
        this.interval = interval;
    }

    void start() {
        worker = new Thread(this);
        worker.start();
    }

    void stop() {
        running.set(false);
    }
    // ----------

    boolean isRunning() {
        return running.get();
    }

//    boolean isStopped() {
//        return stopped.get();
//    }

    // ----------
    @Override
    public void run() {
        ArrayList<Integer> arI = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry ent : map.entrySet()) {
            System.out.println(ent.getKey() + ": " + ent.getValue());
        }

        running.set(true);
        while(running.get()) {
            try {
                Thread.sleep(interval);
                System.out.println("In TRY");
                stop();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interupted");
            }
        }
        System.out.println("Set running - false");
        running.set(false);

    }

    void runThis() {
        start();
    }

    public static void main(String[] args) {
        StrStJavThread st = new StrStJavThread(100);
        st.runThis();
    }

}
