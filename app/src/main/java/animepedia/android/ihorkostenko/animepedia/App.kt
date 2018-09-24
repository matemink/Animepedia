package animepedia.android.ihorkostenko.animepedia

import android.app.Application
import animepedia.android.ihorkostenko.animepedia.di.apiDataSourceModule
import animepedia.android.ihorkostenko.animepedia.di.mainModule
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(apiDataSourceModule, mainModule))
    }
}