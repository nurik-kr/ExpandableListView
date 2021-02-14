package kg.nurik.expandablelistview.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.nurik.expandablelistview.data.MainModel
import kg.nurik.expandablelistview.data.SecondModel

class MainViewModel : ViewModel() {

    val data = MutableLiveData<List<MainModel>>()

    init {
        generateMainData()
    }

    private fun generateMainData() {
        val list = arrayListOf<MainModel>()

        for (i in 0..100) {
            val item = MainModel(
                id = i,
                title = "title of primary data $i",
                subList = generateSecondData(i)
            )
            list.add(item)
        }
        data.postValue(list)
    }

    private fun generateSecondData(pos: Int): ArrayList<SecondModel> {
        val list = arrayListOf<SecondModel>()
        val random = (1..10).random()
        for (i in 0..random) {
            list.add(SecondModel(id = i, title = "title of second data $pos $i"))
        }
        return list
    }
}