package com.kamchai.githubeventsforpaiduaykanmaitest.domain

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
    fun main(): Scheduler
    fun compute(): Scheduler
}