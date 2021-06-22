package com.itpubpil.datastructure.queue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author wangjingbiao
 * createTime: 2019/7/14 16:05
 * desc:
 * 对比arrayQueue和LoopQueue的效率
 * 入队后再出队，比较耗时
 */
public class CompareArrayQueueAndLoopQueue {
    private Map<String, Double> inThenOutQueueTime(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        // 入队
        for (int i = 0; i < opCount; i++) {
            q.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        long inEndTime = System.nanoTime();
        // 出队
        for (int i = 0; i < opCount; i++) {
            q.deQueue();
        }
        long outEndTime = System.nanoTime();

        double inSpendTime = (inEndTime - startTime) / 1000000000.0;
        double outSpendTime = (outEndTime - inEndTime) / 1000000000.0;
        double allSpendTime = (outEndTime - startTime) / 1000000000.0;
        Map<String, Double> result = new HashMap<>();
        result.put("inSpendTime", inSpendTime);
        result.put("outSpendTime", outSpendTime);
        result.put("allSpendTime", allSpendTime);
        return result;
    }

    /**
     * 100万条数据条件下执行结果
     * ArrayQueue {inSpendTime=0.0418176, outSpendTime=285.1451258, allSpendTime=285.1869434}
     * LoopQueue {inSpendTime=0.0555593, outSpendTime=0.0243112, allSpendTime=0.0798705}
     * 可以看出loopQueue的出队列性能是远远高于arrayQueue的，一个是O(1)的，一个是O(n)的
     */
    @Test
    public void testInThenOut() {
        int opCount = 1000000;
        Queue arrayQueue = new ArrayQueue();
        Map map = inThenOutQueueTime(arrayQueue, opCount);
        System.out.println(map.toString());

        Queue loopQueue = new LoopQueue();
        Map map2 = inThenOutQueueTime(loopQueue, opCount);
        System.out.println(map2.toString());
    }
}
