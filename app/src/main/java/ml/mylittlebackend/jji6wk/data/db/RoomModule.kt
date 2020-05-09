package ml.mylittlebackend.jji6wk.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    companion object {
        private const val DB_NAME = "imagy-db"
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): ImagyDatabase {
        return Room.databaseBuilder(
            context,
            ImagyDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCityDao(imagyDatabase: ImagyDatabase) =
        cityBroDatabase.cityDao()

}