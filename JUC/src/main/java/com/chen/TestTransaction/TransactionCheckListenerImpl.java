package com.chen.TestTransaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionCheckListener;
import org.apache.rocketmq.common.message.MessageExt;

public class TransactionCheckListenerImpl implements TransactionCheckListener {
    @Override
    public LocalTransactionState checkLocalTransactionState(MessageExt messageExt) {

        System.out.println("服务器端回查事务消息： "+messageExt.toString());
        //由于RocketMQ迟迟没有收到消息的确认消息，因此主动询问这条prepare消息，是否正常？
        //可以查询数据库看这条数据是否已经处理

        return LocalTransactionState.COMMIT_MESSAGE;
    }

}
