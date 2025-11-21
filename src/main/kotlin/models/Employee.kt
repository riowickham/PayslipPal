package models

data class Employee(val name: String,
                    var payFreq: Double = 0.0,
                    var hourlyPay: Double = 0.0,
                    var sundayPay: Double = 0.0,
                    var taxPercentage: Double = 0.0
)