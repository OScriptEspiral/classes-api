package repository

import arrow.data.Reader
import arrow.data.ReaderApi.ask
import arrow.data.map
import com.mongodb.client.model.Filters
import configuration.server.RepositoryContext
import kotlinx.coroutines.runBlocking
import model.Class

fun save(pClass: Class): Reader<RepositoryContext, Class> =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            pClass.also {
                ctx.coroutineCollection.insertOne(pClass)
            }
        }
    }

fun getById(id: String) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.findOneById(id)
        }
    }

fun getByTeacher(teacherId: String) =
    ask<RepositoryContext>().map { ctx ->
        ctx.coroutineCollection.find(Filters.eq("teacherId", teacherId))
    }

fun delete(id: String) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.deleteOneById(id)
        }
    }

fun replace(id: String, pClass: Class) =
    ask<RepositoryContext>().map { ctx ->
        runBlocking {
            ctx.coroutineCollection.replaceOneById(id, pClass)
        }
    }
