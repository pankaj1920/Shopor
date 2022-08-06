package com.nosense.shopor.model.request.register

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class RegisterRequest(
    email: String = "p@gmail.com",
    password: String = "ppp"
) : BaseObservable() {

    @get:Bindable
    var email = email
        set(value) {
            if (value != email) {
                field = value
                notifyChange()
            }
        }

    @get:Bindable
    var password = password
        set(value) {
            if (value != password) {
                field = value
                notifyChange()
            }
        }

    override fun toString(): String {
        return "Email $email and Password $password"
    }
}