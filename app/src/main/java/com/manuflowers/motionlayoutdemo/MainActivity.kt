package com.manuflowers.motionlayoutdemo

import android.os.Build
import android.os.Bundle
import android.transition.TransitionManager
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.motion_01_start_layout.*

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   // private var container1 = findViewById<ConstraintLayout>(R.id.clContainer1)
   // private var constraint2 = R.layout.motion_01_end_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_01_basic)



      //  addAnimationOperations()
    }

    private fun addAnimationOperations(){
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(clContainer1)

        val constraint2= ConstraintSet()
        constraint2.clone(this, R.layout.motion_01_end_layout)

        button.setOnClickListener{
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                TransitionManager.beginDelayedTransition(clContainer1)
                val constraint  = if(set) constraint1 else constraint2
                constraint.applyTo(clContainer1)
                set = !set
            }
        }
    }
}
