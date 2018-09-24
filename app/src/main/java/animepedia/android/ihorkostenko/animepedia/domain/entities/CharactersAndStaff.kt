package animepedia.android.ihorkostenko.animepedia.domain.entities

data class CharactersAndStaff(
        val request_hash: String,
        val request_cached: Boolean,
        val request_cache_expiry: Int,
        val characters: List<Character>,
        val staff: List<Staff>
)