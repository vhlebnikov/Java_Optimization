cmake_minimum_required(VERSION 3.24)
project(Task_3 C)

set(CMAKE_C_STANDARD 11)

include_directories(src/main/c)

add_executable(Task_3
        src/main/c/Methods.c
        src/main/c/Methods.h)
