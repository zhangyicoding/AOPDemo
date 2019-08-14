package com.estyle.aspect.advice;

import android.util.Log;

import com.estyle.asepct_library.BuildConfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAdvice {

    private static final String TAG = "aspect_advice";

    @Around("execution(* com.estyle..*.*(..))")
    public Object aroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;

        if (BuildConfig.DEBUG) {
            // before
            Log.i(TAG, "before -> " + joinPoint.getSignature());

            long startTime = System.currentTimeMillis();
            result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();

            // after returning
            long duration = endTime - startTime;
            if (duration > 10000) {// 阈值，有待确定
                Log.e(TAG, "after block -> duration: " + duration + "ms, return: " + result + ", method: " + joinPoint.getSignature());
            } else {
                Log.i(TAG, "after -> return: " + result + ", method: " + joinPoint.getSignature() + ", duration: " + duration + "ms");
            }
        } else {
            result = joinPoint.proceed();
        }
        return result;
    }
}
