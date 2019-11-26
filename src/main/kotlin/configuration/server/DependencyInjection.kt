package configuration.server

import configuration.database.mongoConnection
import model.Class
import org.litote.kmongo.coroutine.CoroutineCollection

object RepositoryContext {
    val coroutineCollection: CoroutineCollection<Class> = mongoConnection()
}