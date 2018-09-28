package android.ihorkostenko.animepedia.domain.entities


data class News(
    val request_hash: String,
    val request_cached: Boolean,
    val request_cache_expiry: Int,
    val articles: List<Article>
)

data class Article(
    val url: String,
    val title: String,
    val date: String,
    val author_name: String,
    val author_url: String,
    val forum_url: String,
    val image_url: String,
    val comments: Int,
    val intro: String
)