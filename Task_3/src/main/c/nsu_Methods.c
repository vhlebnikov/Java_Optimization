#include "nsu_Methods.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <windows.h>
#include <unistd.h>

JNIEXPORT void JNICALL Java_nsu_Methods_memoryEater(JNIEnv *env, jobject obj) {
    while (1) {
        size_t size = sizeof(int) * INT_MAX;
        int* arr = (int*) malloc(size);
        if (arr != NULL) {
            memset(arr, 0, size);
        }
    }
};

JNIEXPORT jlong JNICALL Java_nsu_Methods_allocateOneKB(JNIEnv *env, jobject obj) {
    char* arr = (char*) malloc(1024);
    if (arr != NULL) {
        memset(arr, 0, 1024);
    }
    return (jlong) arr;
};

void a(JNIEnv *env);

void c(JNIEnv *env) {
    static int count = 0;
    printf("%d\n", count);
    if (count < 10) {
        count++;
        a(env);
    } else {
//        int *ptr = NULL;
//        *ptr = 1;
        jclass exceptionClass = (*env)->FindClass(env, "java/lang/Exception");

        if (exceptionClass == NULL) {
            return;
        }

        int res = (*env)->ThrowNew(env, exceptionClass, "MY EXCEPTION");
        if (res >= 0) {
            printf("Exception was throwed\n");
            (*env)->ExceptionDescribe(env);
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

typedef struct {
    int field;
} SomeStruct;

JNIEXPORT jlong JNICALL Java_nsu_Methods_allocateStructure(JNIEnv *env, jobject obj) {
    SomeStruct *val = (SomeStruct*) malloc(sizeof(SomeStruct));
    val->field = 10;
    return (jlong) val;
};

JNIEXPORT jint JNICALL Java_nsu_Methods_getStructureField(JNIEnv *env, jobject obj, jlong pointer) {
    if ((void *)pointer == NULL) {
        return -1;
    }
    SomeStruct *val = (SomeStruct*) pointer;
    printf("Value of struct from C: %d\n", val->field);
    return val->field;
};

JNIEXPORT void JNICALL Java_nsu_Methods_freeMemory(JNIEnv *env, jobject obj, jlong pointer) {
    void *p = (void *)pointer;
    if (p == NULL) {
            return;
        }
    free(p);
};