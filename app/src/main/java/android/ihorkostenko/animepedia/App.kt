package android.ihorkostenko.animepedia

import android.app.Application
import android.ihorkostenko.animepedia.di.apiDataSourceModule
import android.ihorkostenko.animepedia.di.mainModule
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(apiDataSourceModule, mainModule))
    }
}