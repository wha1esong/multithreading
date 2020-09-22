ReentrantLock相比于synchronized
- 可以被打断，而synchronized不可以被打断，所以会出现死锁
- 可以设置超时时间 如果在规定时间内获取不到锁，就放弃这次锁的争抢
- 可以设置为公平锁，防止锁饥饿的情况出现
- 支持多个条件变量  在工作線程運行完成之後可以選擇自己要喚醒的那個線程，如果用synchronized的notify可能喚醒的不是自己想要的線程
- 与synchronized都可以进行锁重入

####可重入  

- 可以重入的意思是同一个线程第一次获取到了锁，第二次可以再次访问这把锁
- 不可重入的意思是同一个线程第一次获取到了锁，第二次也不允许再次访问这把锁  

API解释：
- lock(); 加锁，死等，不可以被打断
- lockInterruptibly(); 加锁，死等，可以被打断，抛出InterruptedException
- tryLock();尝试获取锁，获取成功返回true，获取失败反馈false并且停止继续等待
- tryLock(timeout,TimeUnit) 带超时时间的等待，时间到了就不等了，也可以被打断，会抛出InterruptedException
- 解决问题：可以解决哲学家就餐问题
  