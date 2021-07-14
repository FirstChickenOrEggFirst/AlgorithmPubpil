package com.itpubpil.datastructure.set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangjingbiao
 * createTime: 2021/7/14 8:06
 * desc:
 */
public class SetTest {
    @Test
    public void testBstSet(){
        Set<Integer> set = new BstSet<>();
        set.add(1);
        set.add(1);
        Assert.assertEquals(set.getSize(),1);
        set.add(2);
        Assert.assertEquals(set.getSize(),2);
        set.remove(1);
        Assert.assertEquals(set.getSize(),1);
        set.remove(2);
        Assert.assertEquals(set.getSize(),0);
    }

    @Test
    public void testLinkedListSet(){
        Set<Integer> set = new LinkedListSet<>();
        set.add(1);
        set.add(1);
        Assert.assertEquals(set.getSize(),1);
        set.add(2);
        Assert.assertEquals(set.getSize(),2);
        set.remove(1);
        Assert.assertEquals(set.getSize(),1);
        set.remove(2);
        Assert.assertEquals(set.getSize(),0);
    }
}