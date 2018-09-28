package android.ihorkostenko.animepedia.domain.entities


data class Episodes(
        val request_hash: String,
        val request_cached: Boolean,
        val request_cache_expiry: Int,
        val episodes_last_page: Int,
        val episodes: List<Episode>
)

data class Episode(
        val episode_id: Int,
        val title: String,
        val title_japanese: String,
        val title_romanji: String,
        val aired: Aired,
        val filler: Boolean,
        val recap: Boolean,
        val video_url: String,
        val forum_url: String
)

data class Aired(
        val from: String,
        val to: Any,
        val prop: Prop,
        val string: String
)

data class Prop(
        val from: From,
        val to: To
)

data class From(
        val day: Any,
        val month: Any,
        val year: Any
)

data class To(
        val day: Any,
        val month: Any,
        val year: Any
)