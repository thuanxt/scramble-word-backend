import com.google.inject.AbstractModule;
import databases.MockDb;

public class Module extends AbstractModule {
    protected void configure() {
        bind(MockDb.class).asEagerSingleton();
    }
}