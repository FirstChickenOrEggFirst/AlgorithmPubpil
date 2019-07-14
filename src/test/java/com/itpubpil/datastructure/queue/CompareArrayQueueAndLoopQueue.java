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
    public Map<String, Double> inThenOutQueueTime(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        // 入队
        for (int i = 0; i < opCount; i++) {
            q.enquque(random.nextInt(Integer.MAX_VALUE));
        }
        long inEndTime = System.nanoTime();
        // 出队
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
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
