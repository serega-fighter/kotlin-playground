package com.serega.libs.arrow

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import java.time.LocalDate

// Source https://proandroiddev.com/how-to-use-arrows-either-for-exception-handling-in-your-application-a73574b39d07

/*
Because I no longer want to throw exceptions in my code I need to remove this blocks, but still prevent to create invalid objects.
There are some problems with this. One problem is that the constructor can not return anything else than an object of the class
type itself or throwing an exception. So there are some changes necessary in order to achieve the same behavior as before.

I still want to use a data class to benefit from its advantages (equals and hashCode implementations by default) but I want
to create objects and return an Either with the domain model type. The validation logic is placed inside a function inside
the companion object of the data class. Instead of require I use ensure inside an either context, that automatically
returns the ValidationFailure in case of a missing requirement. To not be able to construct an object without calling
this function (copy constructor) I need to hide the concrete data class behind a sealed interface (making it private)
and use an invoke operator to provide a constructor like feeling for the caller.
*/

sealed interface Failure {
    val message: String

    data class ValidationFailure(override val message: String) : Failure

    data class GenericFailure(val e: Throwable) : Failure {
        override val message: String = e.localizedMessage
    }
}

sealed interface User {
    val id: Long
    val firstName: String
    val lastName: String
    val birthDate: LocalDate
    val address: Address

    companion object {
        operator fun invoke(id: Long, firstName: String, lastName: String, birthDate: LocalDate, address: Address): Either<Failure, User> {
            return UserModel.create(id, firstName, lastName, birthDate, address)
        }
    }

    private data class UserModel private constructor(
        override val id: Long,
        override val firstName: String,
        override val lastName: String,
        override val birthDate: LocalDate,
        override val address: Address
    ) : User {

        companion object {
            fun create(id: Long, firstName: String, lastName: String, birthDate: LocalDate, address: Address): Either<Failure, User> {
                return either {
                    ensure(firstName.isNotEmpty()) {
                        Failure.ValidationFailure("The streetName must not be empty!")
                    }
                    ensure(lastName.isNotEmpty()) {
                        Failure.ValidationFailure("The streetNumber must not be empty!")
                    }
                    UserModel(
                        id = id,
                        firstName = firstName,
                        lastName = lastName,
                        birthDate = birthDate,
                        address = address
                    )
                }
            }
        }
    }
}


sealed interface Address {
    val id: Long
    val streetName: String
    val streetNumber: String
    val zipCode: Int
    val city: String

    companion object {
        operator fun invoke(id: Long, streetName: String, streetNumber: String, zipCode: Int, city: String): Either<Failure, Address> {
            return AddressModel.create(id, streetName, streetNumber, zipCode, city)
        }
    }

    private data class AddressModel private constructor(
        override val id: Long,
        override val streetName: String,
        override val streetNumber: String,
        override val zipCode: Int,
        override val city: String,
    ) : Address {

        companion object {
            fun create(id: Long, streetName: String, streetNumber: String, zipCode: Int, city: String): Either<Failure, Address> {
                return either {
                    ensure(streetName.isNotEmpty()) {
                        Failure.ValidationFailure("The streetName must not be empty!")
                    }
                    ensure(streetNumber.isNotEmpty()) {
                        Failure.ValidationFailure("The streetNumber must not be empty!")
                    }
                    ensure(zipCode in 10000..99999) {
                        Failure.ValidationFailure("The zipCode must be between 10000 and 99999!")
                    }
                    ensure(city.isNotEmpty()) {
                        Failure.ValidationFailure("The city must not be empty.")
                    }
                    AddressModel(
                        id = id,
                        streetName = streetName,
                        streetNumber = streetNumber,
                        zipCode = zipCode,
                        city = city
                    )
                }
            }
        }
    }
}

interface UserRepository {
    fun save(user: User): User

    fun findBy(userId: Long): User?

    fun update(user: User): User

    fun delete(userId: Long)
}

// TODO add err logging
fun <T> eval(exec: () -> T): Either<Failure, T> {
    return Either.catch {
        exec()
    }.mapLeft {
        Failure.GenericFailure(it)
    }
}

class InMemoryUserRepository : UserRepository {
    private val userList = mutableListOf<User>()
    private var idGen = 0L

    private fun getOrCreateId(): Long {
        return idGen++
    }

    private fun addToList(user: User): Either<Failure, User> {
        val id = getOrCreateId()
        eval {
            userList.add(user)
        }
        return User(
            id = id,
            firstName = user.firstName,
            lastName = user.lastName,
            birthDate = user.birthDate,
            address = user.address
        )
    }

    override fun save(user: User): User {
        val successfullyAdded = userList.add(user)
        if (!successfullyAdded) {
            error("User could not be added.")
        }
        return user
    }

    override fun findBy(userId: Long): User? {
        return userList.find { it.id == userId }
    }

    override fun update(user: User): User {
        val existingUser = findBy(user.id) ?: error("User does not exist.")
        userList.remove(existingUser)
/*        val updatedUser = existingUser.copy(
            firstName = user.firstName,
            lastName = user.lastName,
            birthDate = user.birthDate,
            address = user.address
        )*/
        val updatedUser = existingUser
        userList.add(
            updatedUser
        )
        return updatedUser
    }

    override fun delete(userId: Long) {
        userList.removeIf { it.id == userId }
    }
}

class UserUseCase(
    private val userRepository: UserRepository
) {
    fun addNewUser(user: User): User {
        val existingUser = userRepository.findBy(user.id)
        require(existingUser == null) {
            "User with id ${user.id} already exists."
        }
        return userRepository.save(user)
    }

    fun updateUser(user: User): User {
        val existingUser = userRepository.findBy(user.id)
        require(existingUser != null) {
            "User with id ${user.id} does not exists."
        }
        return userRepository.update(user)
    }

    fun deleteUser(userId: Long) {
        val existingUser = userRepository.findBy(userId)
        require(existingUser != null) {
            "User with id ${userId} does not exists."
        }
        userRepository.delete(existingUser.id)
    }

    fun findUser(userId: Long): User {
        val existingUser = userRepository.findBy(userId)
        require(existingUser != null) {
            "User with id ${userId} does not exists."
        }
        return existingUser
    }
}

fun main() {
    val addr = Address(
        id = 5,
        streetName = "Main Street",
        streetNumber = "13b",
        zipCode = 22222,
        city = "Los Angeles"
    )

    // TODO map
    addr.onRight {
        val user = User(
            id = 6,
            firstName = "Serega",
            lastName = "Fighter",
            birthDate = LocalDate.of(1991, 5, 19),
            address = it
        )
    }
}
