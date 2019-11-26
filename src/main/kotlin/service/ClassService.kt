package service

import arrow.core.fix
import configuration.server.RepositoryContext
import exceptions.EntityNotFoundException
import io.reactivex.Flowable
import model.Class

fun save(pClass: Class) = repository.save(pClass).run(RepositoryContext).fix().extract()

fun getById(id: String) = repository.getById(id).run(RepositoryContext).fix().extract() ?: throw EntityNotFoundException()

fun getByTeacher(teacherId: String) =
    Flowable.fromPublisher(repository.getByTeacher(teacherId).run(RepositoryContext).fix().extract().publisher)

fun delete(id: String) = repository.delete(id).run(RepositoryContext)

fun replace(id: String, pClass: Class) = repository.replace(id, pClass).run(RepositoryContext).fix().extract()
