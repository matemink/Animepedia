package android.ihorkostenko.animepedia.domain.entities


data class Pictures(
        val request_hash: String,
        val request_cached: Boolean,
        val request_cache_expiry: Int,
        val pictures: List<Picture>
)

data class Picture(
        val large: String,
        val small: String
)