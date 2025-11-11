package models

data class Employee(val name: String,
                    var payFreq: Double = 0.0,
                    var hourlyRate: Double = 0.0,
                    var sundayRate: Double = 0.0,
                    var taxPercentage: Double = 0.0
)