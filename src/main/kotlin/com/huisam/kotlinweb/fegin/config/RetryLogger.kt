package com.huisam.kotlinweb.fegin.config

import org.slf4j.LoggerFactory
import org.springframework.retry.RetryCallback
import org.springframework.retry.RetryContext
import org.springframework.retry.listener.RetryListenerSupport
import org.springframework.stereotype.Component

@Component
class RetryLogger : RetryListenerSupport() {
    private val log = LoggerFactory.getLogger(RetryLogger::class.java)
    override fun <T : Any?, E : Throwable> onError(
        context: RetryContext,
        callback: RetryCallback<T, E>,
        throwable: Throwable
    ) {
        log.warn("retry method : ${context.getAttribute(RetryContext.NAME)}, retry count : ${context.retryCount}, exception : ${throwable.stackTrace.contentToString()}")
    }
}

