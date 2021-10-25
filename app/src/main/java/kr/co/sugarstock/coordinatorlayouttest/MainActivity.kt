package kr.co.sugarstock.coordinatorlayouttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import kr.co.sugarstock.coordinatorlayouttest.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private val binding: ActivityMainBinding by binding(R.layout.activity_main)
    private var fragmentHome: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.apply {
            activity = this@MainActivity
        }
        runFragment()
    }

    private fun runFragment() {
        // 프래그먼트 실행 또는 전환시, 존재하지 않으면 생성하고 있으면 유지
        if (fragmentHome == null) {
            fragmentHome = BlankFragment()
            supportFragmentManager.beginTransaction().add(
                R.id.fragment,
                fragmentHome as BlankFragment
            ).commit()
        }
        fragmentHome?.let {
            // 모든 프래그먼트를 hide하고, 해당 프래그먼트만 show 하도록 구현
            supportFragmentManager.beginTransaction().apply {
                show(it)
                commit()
            }
        }
    }
}