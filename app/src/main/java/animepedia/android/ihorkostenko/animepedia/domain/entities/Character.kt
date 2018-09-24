package animepedia.android.ihorkostenko.animepedia.domain.entities

data class Character(
        val mal_id: Int,
        val url: String,
        val image_url: String,
        val name: String,
        val role: String,
        val voice_actors: List<VoiceActor>
)