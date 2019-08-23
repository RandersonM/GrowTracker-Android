package me.anon.grow

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_holder.*
import me.anon.grow.fragment.EventListFragment

class EventsActivity : BaseActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)

		setContentView(R.layout.fragment_holder)
		setSupportActionBar(toolbar)

		if (intent.extras == null || !intent.hasExtra("plant"))
		{
			finish()
			return
		}

		if (supportFragmentManager.findFragmentByTag("fragment") == null)
		{
			supportFragmentManager.beginTransaction()
				.replace(R.id.fragment_holder, EventListFragment.newInstance(intent.extras), "fragment")
				.commit()
		}
	}
}
