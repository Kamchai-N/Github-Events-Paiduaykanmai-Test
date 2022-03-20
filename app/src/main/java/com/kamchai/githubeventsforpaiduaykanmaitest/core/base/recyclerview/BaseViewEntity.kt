package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview

interface BaseViewEntity {
    fun clone(): BaseViewEntity
    fun viewType(): Int
    var isError: Boolean
}

