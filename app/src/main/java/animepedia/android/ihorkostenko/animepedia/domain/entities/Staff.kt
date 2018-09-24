package animepedia.android.ihorkostenko.animepedia.domain.entities

data class Staff(
        val mal_id: Int,
        val url: String,
        val name: String,
        val image_url: String,
        val positions: List<String>
)