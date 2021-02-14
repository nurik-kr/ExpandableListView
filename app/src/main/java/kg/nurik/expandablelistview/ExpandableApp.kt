package kg.nurik.expandablelistview

import android.app.Application
import kg.nurik.expandablelistview.di.appModules
import org.koin.android.ext.android.startKoin

class ExpandableApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}