package com.example.foodorderingapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.foodorderingapp.databinding.ActivitySignupBinding
import com.example.foodorderingapp.model.signupinfo
import com.google.firebase.firestore.FirebaseFirestore
class signup : AppCompatActivity() {
    private lateinit var databinding: ActivitySignupBinding
//    private var viewmodel:signviewmodel?=null
    private val db = FirebaseFirestore.getInstance()
    private var signupperson: signupinfo = signupinfo("", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding=DataBindingUtil.setContentView(this, R.layout.activity_signup)
//        viewmodel=ViewModelProvider(this).get((signviewmodel::class.java))

//        with(databinding) {
//            lifecycleOwner = this@signup
//            signupdata = this@signup.viewmodel
//            setupobservation()
            databinding.creatAccbtn.setOnClickListener {
                var name:String
                var email:String
                var password:String
                    name= databinding.txtname.text.toString()
                    email= databinding.txtemail.text.toString()
                    password= databinding.txtpassword.text.toString()
signupperson= signupinfo(name,email,password)
                    db.collection("Signup Person").document("${signupperson.name}")
                        .set(signupperson!!)
                        .addOnSuccessListener {
                            Toast.makeText(this@signup, "Successfully add", Toast.LENGTH_SHORT).show()
                }
                        .addOnFailureListener{
                            Toast.makeText(this@signup, "Error", Toast.LENGTH_SHORT).show()
                        }
            }
//        }

    }
//    fun setupobservation(){
//       viewmodel?.name?.observe(this){
//            signupperson?.name=it.toString()
//        }
//        viewmodel?.email?.observe(this){
//        signupperson?.email=it.toString()
//        }
//        viewmodel?.password?.observe(this){
//        signupperson?.password=it.toString()
//        }
//
//    }
}


