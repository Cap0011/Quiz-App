package com.example.quizapp

data class Question (
    val id: Int,
    val question: String,
    val img: Int,
    val opt0:String,
    val opt1:String,
    val opt2:String,
    val opt3:String,
    val answer: Int)