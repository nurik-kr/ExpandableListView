package kg.nurik.expandablelistview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kg.nurik.expandablelistview.databinding.ActivityMainBinding
import kg.nurik.expandablelistview.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val adapter by lazy { ExpandableAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupExpandable()
        setupViewModel()
    }

    private fun setupExpandable() {
        binding.listView.setAdapter(adapter)
    }

    private fun setupViewModel() {
        vm.data.observe(this, Observer {
            adapter.update(it)
        })
    }
}