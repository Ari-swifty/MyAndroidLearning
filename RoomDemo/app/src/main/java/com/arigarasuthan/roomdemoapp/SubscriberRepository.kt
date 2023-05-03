package com.arigarasuthan.roomdemoapp

import com.arigarasuthan.roomdemoapp.db.Subscriber
import com.arigarasuthan.roomdemoapp.db.SubscriberDao

class SubscriberRepository(private val dao: SubscriberDao) {
    val subscribers = dao.getAllSubscribers()

    suspend fun insert(subscriber: Subscriber) : Long {
       return dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber) : Int {
       return dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber) : Int {
        return dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll() : Int {
        return dao.deleteAll()
    }
}