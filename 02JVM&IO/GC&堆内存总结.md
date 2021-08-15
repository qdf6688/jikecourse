### GC&堆内存总结


#### 1.堆内存划分差异

* serialGC:堆内存分成了def new generation和tenured generation
* parallelGC:堆内存分成了PSYoungGen和ParOldGen
* CMS GC：堆内存分成了par new generation和concurrent mark-sweep generation
* G1 GC：堆空间分成了garbage-first heap

#### 2. GC时间对比
* 通过gc日志对比，相同的内存空间年轻带gc时间serialGC是parallelGC的2倍，应该是parallelGC默认是2个并发线程
 






