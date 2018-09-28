package android.ihorkostenko.animepedia.domain.entities

data class Characters(
        val request_hash: String,
        val request_cached: Boolean,
        val request_cache_expiry: Int,
        val characters: List<AnimeCharacter>,
        val staff: List<Staff>
)

data class Staff(
        val mal_id: Int,
        val url: String,
        val name: String,
        val image_url: String,
        val positions: List<String>
)

data class AnimeCharacter(
        val mal_id: Int,
        val url: String,
        val image_url: String,
        val name: String,
        val role: String,
        val voice_actors: List<VoiceActor>
)

data class VoiceActor(
        val mal_id: Int,
        val name: String,
        val url: String,
        val image_url: String,
        val language: String
)


