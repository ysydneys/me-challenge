package com.ysydneys.meapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ysydneys.meapplication.extension.addFragment
import com.ysydneys.meapplication.extension.replaceToBackStack
import com.ysydneys.meapplication.ui.BaseFragment
import com.ysydneys.meapplication.ui.detail.DetailFragment
import com.ysydneys.meapplication.ui.list.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BaseFragment.FragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            addFragment(ListFragment(), R.id.fragmentHolder)
        }
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun onEmployeeSelected(selectedEmployeeId: Int) {
        replaceToBackStack(DetailFragment.newInstance(selectedEmployeeId), R.id.fragmentHolder)
    }

    override fun showToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}