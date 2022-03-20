package com.kamchai.githubeventsforpaiduaykanmaitest.data.entity

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseEntity(
    @SerializedName("id") val id: String = String(),
    @SerializedName("type") val type: String = String(),
    @SerializedName("actor") val actor: Actor? = null,
    @SerializedName("repo") val repo: Repo? = null,
    @SerializedName("created_at") val createdAt: String = String(),
) {

    data class Actor(
        @SerializedName("id") val id: Int = 0,
        @SerializedName("login") val login: String = String(),
        @SerializedName("display_login") val displayLogin: String = String(),
        @SerializedName("gravatar_id") val gravatarId: String = String(),
        @SerializedName("url") val url: String = String(),
        @SerializedName("avatar_url") val avatarUrl: String = String(),
    )

    data class Repo(
        @SerializedName("id") val id: Int = 0,
        @SerializedName("name") val name: String = String(),
        @SerializedName("url") val url: String = String(),
    )
}