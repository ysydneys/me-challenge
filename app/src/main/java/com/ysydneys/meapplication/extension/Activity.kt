package com.ysydneys.meapplication.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager
        .beginTransaction()
        .add(frameId, fragment)
        .commit()
}

fun AppCompatActivity.replaceToBackStack(fragment: Fragment, frameId: Int) {
    supportFragmentManager
        .beginTransaction()
        .replace(frameId, fragment)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}