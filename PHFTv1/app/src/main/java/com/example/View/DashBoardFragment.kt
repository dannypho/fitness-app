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
import com.example.phftv1.GoalSetting
import com.example.phftv1.PaymentIntegration
import com.example.phftv1.R
import com.example.phftv1.ReviewTrainer
import com.example.phftv1.Subscription
import com.example.phftv1.Tracking

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashBoard.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashBoardFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_dash_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access your button by ID
        val trackingCardView = view.findViewById<CardView>(R.id.btn_tracking)
        val activitiesCardView = view.findViewById<CardView>(R.id.btn_activity_categories)
        val goalsCardView = view.findViewById<CardView>(R.id.btn_goal_setting)
        val reviewCardView = view.findViewById<CardView>(R.id.btn_trainer_reviews)
        val subscriptionCardView = view.findViewById<CardView>(R.id.btn_subscription)
        val purchaseCardView = view.findViewById<CardView>(R.id.purchase_workout_plans)
        val userNameTextView = view.findViewById<TextView>(R.id.name)
        val ageTextView = view.findViewById<TextView>(R.id.age)
        val weightTextView = view.findViewById<TextView>(R.id.weight)
        val heightTextView = view.findViewById<TextView>(R.id.height)

        // Set the text with first name and last name
        userNameTextView.text = "${SessionManager.currentUser.name}"
        weightTextView.text = "${SessionManager.currentUser.weight} lbs"
        heightTextView.text = "${SessionManager.currentUser.height} cm"
        ageTextView.text = "${SessionManager.currentUser.age} years"


        // Set a click listener
        goalsCardView.setOnClickListener {
            val intent = Intent(requireContext(), GoalSetting::class.java)
            startActivity(intent)
        }
        activitiesCardView.setOnClickListener {
            val intent = Intent(requireContext(), ActivityCategories::class.java)
            startActivity(intent)
        }
        trackingCardView.setOnClickListener {
            val intent = Intent(requireContext(), Tracking::class.java)
            startActivity(intent)
        }
        reviewCardView.setOnClickListener {
            val intent = Intent(requireContext(), ReviewTrainer::class.java)
            startActivity(intent)
        }
        subscriptionCardView.setOnClickListener {
            val intent = Intent(requireContext(), Subscription::class.java)
            startActivity(intent)
        }
        purchaseCardView.setOnClickListener {
            val intent = Intent(requireContext(), PaymentIntegration::class.java)
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
         * @return A new instance of fragment DashBoard.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashBoardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}