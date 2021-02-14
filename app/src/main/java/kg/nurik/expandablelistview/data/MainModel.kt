package kg.nurik.expandablelistview.data

data class MainModel(
    val id: Int,
    val title: String,
    val subList: List<SecondModel>
)
