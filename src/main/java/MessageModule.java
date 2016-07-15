import dagger.Module;
import dagger.Provides;

@Module()
class MessageModule {
    @Provides
    MyMessage provideMessage() {
        return new MyMessage();
    }
}
