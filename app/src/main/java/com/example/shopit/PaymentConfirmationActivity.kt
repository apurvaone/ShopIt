package com.example.shopit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_payment_confirmation.*
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONException

import org.json.JSONObject







class PaymentConfirmationActivity : AppCompatActivity(),PaymentResultListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_confirmation)
val amount= 4999
        buycnf.setOnClickListener {
            val checkout = Checkout()
            checkout.setKeyID("YourKey")
            checkout.setImage(R.drawable.logo1)

            val `object` = JSONObject()
            try {
                // to put name
                `object`.put("name", "ShopIt")

                // put description
                `object`.put("description", "Test payment")

                // to set theme color
                `object`.put("theme.color", "#060219")

                // put the currency
                `object`.put("currency", "INR")

                // put amount
                `object`.put("amount", amount)

                // put mobile number
                `object`.put("prefill.contact", "9284064503")

                // put email
                `object`.put("prefill.email", "Payments@ShopIt.com")

                // open razorpay to checkout activity
                checkout.open(this, `object`)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Payment is successful : " + p0, Toast.LENGTH_SHORT).show();

    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Chill: Just because it is a test payment", Toast.LENGTH_SHORT).show()
    }
}
