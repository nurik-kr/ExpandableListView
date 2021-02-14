package kg.nurik.expandablelistview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import kg.nurik.expandablelistview.R
import kg.nurik.expandablelistview.data.MainModel

class ExpandableAdapter : BaseExpandableListAdapter() {

    private val list = arrayListOf<MainModel>()

    fun update(list: List<MainModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_parent, parent, false)
        }
        view?.findViewById<TextView>(R.id.tv_parent)?.text = list[groupPosition].title

        return view!!
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_child, parent, false)
        }

        view?.findViewById<TextView>(R.id.tv_child)?.text =
            list[groupPosition].subList[childPosition].title
        return view!!
    }

    override fun getGroupCount() = list.size

    override fun getGroup(groupPosition: Int) = list[groupPosition]

    override fun getChildrenCount(groupPosition: Int) = list[groupPosition].subList.size // или можем другую верстку отдать

    override fun getChild(groupPosition: Int, childPosition: Int) =
        list[groupPosition].subList[childPosition]

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()

    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true

    override fun hasStableIds() = true
}