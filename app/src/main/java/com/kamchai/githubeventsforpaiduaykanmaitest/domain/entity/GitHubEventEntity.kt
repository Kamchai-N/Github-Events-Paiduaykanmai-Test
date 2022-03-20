package com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubEventEntity(
    val id: Long = 0,
    val login: String = String(),
    val displayLogin: String = String(),
    val gravatarId: String = String(),
    val url: String = String(),
    val avatarUrl: String = String(),
    val type: String = String(),
    val repoName : String = String(),
    val createdAt: String = String(),
) : Parcelable