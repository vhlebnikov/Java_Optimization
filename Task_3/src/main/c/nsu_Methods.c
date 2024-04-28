#include "nsu_Methods.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

JNIEXPORT void JNICALL Java_nsu_Methods_memoryEater(JNIEnv *env, jobject obj) {
    while (1) {
        int* arr = (int*) malloc(sizeof(int) * INT_MAX);
        for (int i = 0; i < INT_MAX; i++) {
            arr[i] = i;
        }
    }
};

JNIEXPORT jlong JNICALL Java_nsu_Methods_allocateOneKB(JNIEnv *env, jobject obj) {
    int64_t* array = (int64_t*) malloc(sizeof(int64_t) * 128);
    return (jlong) array;
};

void a(JNIEnv *env);

void c(JNIEnv *env) {
    static int count = 0;
    printf("%d\n", count);
    if (count < 10) {
        count++;
        a(env);
    } else {
        jclass Exception = (*env)->FindClass(env, "java/lang/Exception");

        int res = (*env)->ThrowNew(env, Exception, "MY EXCEPTION");
        if (res >= 0) {
            printf("Exception was throwed\n");

        }
        return;
    }
};

void b(JNIEnv *env) {
    c(env);
};

void a(JNIEnv *env) {
    b(env);
}

JNIEXPORT void JNICALL Java_nsu_Methods_brokenChainOfMethods(JNIEnv *env, jobject obj) {
    a(env);
};

JNIEXPORT jint JNICALL Java_nsu_Methods_stringLength(JNIEnv *env, jobject obj, jstring string) {
    jsize size = (*env)->GetStringLength(env, string);
    return (jint) size;
};

JNIEXPORT void JNICALL Java_nsu_Methods_callObjectMethod(JNIEnv *env, jobject obj, jobject class_object) {
    jclass cls = (*env)->GetObjectClass(env, class_object);
    jmethodID id = (*env)->GetMethodID(env, cls, "someMethod", "(Ljava/lang/String;)V");
    if (id == 0) {
        return;
    }
    char* string = "hello";
    jstring js = (*env)->NewStringUTF(env, string);
    (*env)->CallVoidMethod(env, class_object, id, js);
};

JNIEXPORT void JNICALL Java_nsu_Methods_changeObjectField(JNIEnv *env, jobject obj, jobject class_object, jint val) {
    jclass cls = (*env)->GetObjectClass(env, class_object);
    jfieldID id = (*env)->GetFieldID(env, cls, "field", "I");
    if (id == 0) {
        return;
    }
    (*env)->SetIntField(env, class_object, id, val);
};

//JNIEXPORT jlong JNICALL Java_nsu_Methods_allocateStructure(JNIEnv *env, jobject obj) {
//
//};
//
//JNIEXPORT jint JNICALL Java_nsu_Methods_getStructureField(JNIEnv *env, jobject obj, jlong pointer) {
//
//};
//
//JNIEXPORT void JNICALL Java_nsu_Methods_freeMemory(JNIEnv *env, jobject obj, jlong pointer) {
//
//};