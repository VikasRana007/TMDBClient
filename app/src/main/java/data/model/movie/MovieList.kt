package data.model.movie


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("tvShows")
    val movie: List<Movie>
)