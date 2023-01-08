package com.ars.epoxydemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ars.epoxydemo2.databinding.ActivityMainBinding
import com.ars.epoxydemo2.epoxy.UserEpoxyController

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val controller = UserEpoxyController()
        binding.epoxyRv.setController(controller)
        controller.setData(getUsers())

    }

























    private fun getUsers(): List<User> =
        listOf(
            User(1, "Hamza", R.drawable.avatar_1),
            User(2, "ars", R.drawable.avatar_2),
            User(3, "tsfdf", R.drawable.avatar_3),
            User(4, "ahmed", R.drawable.avatar_4),
            User(5, "test", R.drawable.avatar_5),
            User(6, "hhtgdf", R.drawable.avatar_6)
        )

}