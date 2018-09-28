package com.ikurek.shopshare.database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.ikurek.shopshare.model.Product

class FirebaseHelper {

    val firebaseInstance = FirebaseDatabase.getInstance()

    fun putProduct(product: Product, success: () -> Unit, failure: () -> Unit) {
        firebaseInstance.reference.child("list").push().setValue(product).addOnCompleteListener {
            success()
        }.addOnFailureListener {
            failure()
        }
    }

    fun getProducts(success: (List<Product>) -> Unit, failure: () -> Unit) {
        firebaseInstance.reference.child("list").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                failure()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var listOfProducts = mutableListOf<Product>()

                dataSnapshot.children.forEach {

                    listOfProducts.add(
                            Product(
                                    it.child("ammount").value as Long,
                                    it.child("name").value as String,
                                    it.child("notes").value as String
                            )
                    )
                }

                success(listOfProducts)
            }

        })
    }
}