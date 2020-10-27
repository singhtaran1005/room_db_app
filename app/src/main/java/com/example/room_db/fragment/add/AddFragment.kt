package com.example.room_db.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.room_db.R
import com.example.room_db.data.User
import com.example.room_db.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.add_button


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = return inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_button.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        TODO("Not yet implemented")
        val firstName = editTextTextPersonName.text.toString()
        val lastName = editTextTextPersonName2.text.toString()
        val age = editTextTextPersonName4.text

        if (inputcheck(firstName, lastName, age)) {
            //Create user object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            //Add data to database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully Added", Toast.LENGTH_LONG).show()

            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG)
                .show()

        }
    }

    private fun inputcheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && (TextUtils.isEmpty(lastName)) && age.isEmpty())

    }

}