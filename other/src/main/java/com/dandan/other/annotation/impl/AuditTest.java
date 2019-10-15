package com.dandan.other.annotation.impl;

import com.dandan.other.annotation.Audit;

/**
 * Created by dandan On 九月 09 2019
 */
public class AuditTest {

    @Audit(actionType = "test", actionCategoryCode = "testAudit", actionCategoryName = "testAuditName")
    public void testAuditAnnotation(){
        System.out.println(AuditTest.class.getName() + "--testAuditAnnotation()");
    }



}
