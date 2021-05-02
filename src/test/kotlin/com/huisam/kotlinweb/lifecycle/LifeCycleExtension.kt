package com.huisam.kotlinweb.lifecycle

import org.hibernate.annotations.common.util.impl.LoggerFactory.logger
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.InvocationInterceptor
import org.junit.jupiter.api.extension.ReflectiveInvocationContext
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import kotlin.system.measureTimeMillis

class LifeCycleExtension : InvocationInterceptor {
    private val log = logger(this.javaClass)

    override fun <T : Any?> interceptTestClassConstructor(
        invocation: InvocationInterceptor.Invocation<T>?,
        invocationContext: ReflectiveInvocationContext<Constructor<T>>?,
        extensionContext: ExtensionContext?
    ): T {
        log.info("constructed, ${invocation?.javaClass}")
        return super.interceptTestClassConstructor(invocation, invocationContext, extensionContext)
    }

    override fun interceptTestMethod(
        invocation: InvocationInterceptor.Invocation<Void>?,
        invocationContext: ReflectiveInvocationContext<Method>?,
        extensionContext: ExtensionContext?
    ) {
        val methodName = invocationContext?.executable?.name
        val executionTime = measureTimeMillis {
            super.interceptTestMethod(invocation, invocationContext, extensionContext)
        }
        println("테스트명 = $methodName, 실행시간 = $executionTime ms")
    }
}