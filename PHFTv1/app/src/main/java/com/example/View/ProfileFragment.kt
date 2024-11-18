package com.example.View

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.backend.SessionManager
import com.example.phftv1.ActivityCategories
import com.example.phftv1.ExercisePlans
import com.example.phftv1.GoalSetting
import com.example.phftv1.MainActivity
import com.example.phftv1.PaymentIntegration
import com.example.phftv1.R
import com.example.phftv1.ReviewTrainer
import com.example.phftv1.Subscription
import com.example.phftv1.Tracking
import com.example.phftv1.UpdateUserInfo

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access your button by ID
        val workouts = view.findViewById<TextView>(R.id.workouts)
        val log_out = view.findViewById<TextView>(R.id.log_out)
        val update_info = view.findViewById<TextView>(R.id.update_info)
        val subscriptions = view.findViewById<TextView>(R.id.subscriptions)
        val excercisePlan = view.findViewById<TextView>(R.id.excercisePlan)

        val userNameTextView = view.findViewById<TextView>(R.id.name)
        val weightTextView = view.findViewById<TextView>(R.id.weight)
        val heightTextView = view.findViewById<TextView>(R.id.height)
        val ageTextView = view.findViewById<TextView>(R.id.age)


        // Set the text with first name and last name
        userNameTextView.text = "${SessionManager.currentUser.name}"
        weightTextView.text = "${SessionManager.currentUser.weight} lbs"
        heightTextView.text = "${SessionManager.currentUser.height} cm"
        ageTextView.text = "${SessionManager.currentUser.age} years"



        // Set a click listener
        update_info.setOnClickListener {
            val intent = Intent(requireContext(), UpdateUserInfo::class.java)
            startActivity(intent)
        }
        log_out.setOnClickListener {
            context?.let { it1 -> SessionManager.logout(it1) }
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        workouts.setOnClickListener {
            val intent = Intent(requireContext(), Tracking::class.java)
            startActivity(intent)
        }
        subscriptions.setOnClickListener {
            val intent = Intent(requireContext(), Subscription::class.java)
            startActivity(intent)
        }
        excercisePlan.setOnClickListener {
            val intent = Intent(requireContext(), ExercisePlans::class.java)
            startActivity(intent)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}