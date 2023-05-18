import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import com.example.json.Emoji
import com.example.json.JsonSerializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


class JsonSerializerTest {

    private val serializer = JsonSerializer()
    private val mapper: ObjectMapper = jacksonObjectMapper()

    @Test
    fun testDeserialization() {
        val json = """
        {
            "name": "laos",
            "category": "flags",
            "group": "flags",
            "htmlCode": [
                "&#127473;",
                "&#127462;"
            ],
            "unicode": [
                "U+1F1F1",
                "U+1F1E6"
             ]
        }
        """

        val emoji = serializer.deserialize<Emoji>(json)

        Assertions.assertNotNull(emoji.name)
        Assertions.assertNotNull(emoji.category)
        Assertions.assertNotNull(emoji.group)
        Assertions.assertNotNull(emoji.htmlCode)
        Assertions.assertNotNull(emoji.unicode)
    }

    @Test
    fun testSerialization() {
        val emoji = Emoji(
            name = "laos",
            category = "flags",
            group = "flags",
            htmlCode = listOf("&#127473;",
                "&#127462;"),
            unicode = listOf("U+1F1F1",
                "U+1F1E6")
        )

        val json = serializer.serialize(emoji)

        val expectedJson = """
        {
            "name": "laos",
            "category": "flags",
            "group": "flags",
            "htmlCode": [
                "&#127473;",
                "&#127462;"
            ],
            "unicode": [
                "U+1F1F1",
                "U+1F1E6"
             ]
        }
        """.trimIndent()

        val expectedEmoji = mapper.readValue(expectedJson, Emoji::class.java)
        val actualEmoji = mapper.readValue(json, Emoji::class.java)

        Assertions.assertEquals(expectedEmoji, actualEmoji)
    }
}