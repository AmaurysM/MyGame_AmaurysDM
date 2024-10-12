package com.example.mygame_amaurysdm.model

import java.util.TreeSet

object UserBag {
    private val users = mutableListOf<User>();
    private var usersCount = 0;
    private var currentUser: User? = null;

    fun addUser(user: User) {
        users.add(user)
        usersCount++
    }

    fun removeUser(email: String) {
        users.removeIf { it.email == email }
        usersCount--
    }

    fun getCurrentUser(): User? {
        return currentUser
    }

    fun setCurrent(user: User) {
        users.find { it.email == user.email }?.let {
            currentUser = it
        }
    }

    fun getUsers(): List<User> {
        return users
    }

    fun getUser(filter: (User) -> Boolean): List<User> {
        return users.filter { filter(it)}
    }

}