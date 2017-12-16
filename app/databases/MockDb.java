package databases;

import javax.inject.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import play.inject.ApplicationLifecycle;
import play.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

// This creates an `ApplicationStart` object once at start-up.
@Singleton
public class MockDb {
    final static Logger logger = LoggerFactory.getLogger(MockDb.class);
    private final static String DB_FILE = "DB.txt";
    public static Map<Integer, String> data = new HashMap<>();
    public static Set<String> dataSet = new HashSet<>();

    // Inject the application's Environment upon start-up and register hook(s) for shut-down.
    @Inject
    public MockDb(ApplicationLifecycle lifecycle, Environment environment) {

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(DB_FILE))) {
            String line;
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                this.data.put(++i,line);
                this.dataSet.add(line);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        // Shut-down hook
        lifecycle.addStopHook( () -> {
            this.data = null;
            this.dataSet = null;
            return CompletableFuture.completedFuture(null);
        } );
    }
}