package be.ucll.integrationexercise;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, WorkOrder.class}, version = 1, exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public  abstract WorkOrderDao workOrderDao();

    private static volatile UserRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static UserRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class)
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.

                UserDao userDao = INSTANCE.userDao();

                WorkOrderDao workOrderDao = INSTANCE.workOrderDao();

                User user = new User("jonasB", "test123", "Jonas", "Bourguignon");
                userDao.insert(user);

                WorkOrder order1 = new WorkOrder("jonasB", "Leuven", "Microgolf", "A02", "Francis");
                WorkOrder order2 = new WorkOrder("jonasB", "Hasselt", "Vaatwasmachine", "B04", "Peter");
                WorkOrder order3 = new WorkOrder("jonasB", "Antwerpen", "Kookplaat", "C07", "Francesca");
                WorkOrder order4 = new WorkOrder("jonasB", "Gent", "Printer", "D05", "Peter");
                WorkOrder order5 = new WorkOrder("jonasB", "Brussel", "Fax", "F09", "Marleen");
                workOrderDao.insert(order1);
                workOrderDao.insert(order2);
                workOrderDao.insert(order3);
                workOrderDao.insert(order4);
                workOrderDao.insert(order5);
            });
        }
    };

}
