import airy.forest.LanguageExampleDatabase
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import java.io.File

fun main() {
    //https://cashapp.github.io/sqldelight/jvm_sqlite/

    val dbFile = "languageExampleDatabase.db"
    val createTable = !File(dbFile).exists()
    val dbDriver = JdbcSqliteDriver("jdbc:sqlite:$dbFile")
    val database = LanguageExampleDatabase(dbDriver)
    if (createTable) {
        LanguageExampleDatabase.Schema.create(dbDriver)
    }

    val languageDbQueries = database.languageExampleDatabaseQueries

    println(languageDbQueries.selectAllLanguages().executeAsList())
    if (createTable) {
        languageDbQueries.insertLanguage(1010, "It")
        languageDbQueries.insertLanguage(1020, "DE")
        languageDbQueries.insertLanguage(1031, "Fra")
        languageDbQueries.insertLanguage(1040, "Bg")
        println(languageDbQueries.selectAllLanguages().executeAsList())
    }
    println(languageDbQueries.selectLanguageById(1031).executeAsOne())
}