package com.example.shopit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.razorpay.PaymentResultListener
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import com.razorpay.Checkout
import org.json.JSONException

import org.json.JSONObject
import android.content.Intent










// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment(),PaymentResultListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("Title","DEFAULT")
            param2 = it.getString("Price","Default")


//

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_detail, container, false)
        view.buyNow.setOnClickListener {
            val intent = Intent(activity, PaymentConfirmationActivity::class.java)
            startActivity(intent)
        }

//        view.buyNow.setOnClickListener {
//            val amount= 4999
//            val checkout = Checkout()
//            checkout.setKeyID("rzp_test_CcyHHmDiAaljcx")
//            checkout.setImage(R.drawable.logo1)
//
//            val obj = JSONObject()
//            try {
//                // to put name
//                obj.put("name", "ShopIt")
//
//                // put description
//                obj.put("description", "Test payment")
//
//                // to set theme color
//
//
//                // put the currency
//                obj.put("currency", "INR")
//
//                // put amount
//                obj.put("amount", amount)
//
//                // put mobile number
//                obj.put("prefill.contact", "9284064503")
//
//                // put email
//                obj.put("prefill.email", "apurvashukla15@gmail.com")
//
//                // open razorpay to checkout activity
//                checkout.open(DetailFragment().activity, obj)
//            } catch (e: JSONException) {
//                e.printStackTrace()
//            }
//           // (activity as NavigationHost).navigateTo(CheckOutFragment(), true)
//        }
        return view
    }

    companion object {


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(context, "Payment is successful : " + p0, Toast.LENGTH_SHORT).show();
    }
    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(context, "Payment Failed due to error : " + p1, Toast.LENGTH_SHORT).show();
    }
    }


