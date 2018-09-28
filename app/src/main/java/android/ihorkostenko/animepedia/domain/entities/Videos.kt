package android.ihorkostenko.animepedia.domain.entities


data class Videos(
        val request_hash: String,
        val request_cached: Boolean,
        val request_cache_expiry: Int,
        val promo: List<Promo>,
        val episodes: List<VideoEpisode>
)

data class VideoEpisode(
        val title: String,
        val episode: String,
        val url: String,
        val image_url: String
)

data class Promo(
        val title: String,
        val image_url: String,
        val video_url: String
)