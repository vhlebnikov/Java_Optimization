/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class nsu_Methods */

#ifndef _Included_nsu_Methods
#define _Included_nsu_Methods
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     nsu_Methods
 * Method:    memoryEater
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_nsu_Methods_memoryEater
  (JNIEnv *, jobject);

/*
 * Class:     nsu_Methods
 * Method:    allocateOneKB
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_nsu_Methods_allocateOneKB
  (JNIEnv *, jobject);

/*
 * Class:     nsu_Methods
 * Method:    brokenChainOfMethods
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_nsu_Methods_brokenChainOfMethods
  (JNIEnv *, jobject);

/*
 * Class:     nsu_Methods
 * Method:    stringLength
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_nsu_Methods_stringLength
  (JNIEnv *, jobject, jstring);

/*
 * Class:     nsu_Methods
 * Method:    callObjectMethod
 * Signature: (Lnsu/SomeClass;)V
 */
JNIEXPORT void JNICALL Java_nsu_Methods_callObjectMethod
  (JNIEnv *, jobject, jobject);

/*
 * Class:     nsu_Methods
 * Method:    changeObjectField
 * Signature: (Lnsu/SomeClass;I)V
 */
JNIEXPORT void JNICALL Java_nsu_Methods_changeObjectField
  (JNIEnv *, jobject, jobject, jint);

/*
 * Class:     nsu_Methods
 * Method:    allocateStructure
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_nsu_Methods_allocateStructure
  (JNIEnv *, jobject);

/*
 * Class:     nsu_Methods
 * Method:    getStructureField
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_nsu_Methods_getStructureField
  (JNIEnv *, jobject, jlong);

/*
 * Class:     nsu_Methods
 * Method:    freeMemory
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_nsu_Methods_freeMemory
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif