package com.acme.edu.testunit;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.filters.LengthFilter;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.StringMessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LengthFilterTest implements SysoutCaptureAndAssertionAbility {
    LengthFilter filter;

    @BeforeEach
    public void setBasicArguments() {
        filter = new LengthFilter(10);
    }

    @Test
    public void lengthFilterShouldDismissShortMessages(){
        Message forbiddenString = new StringMessage("LONGMESSAGE");
        assert (filter.filter(forbiddenString) == true);
    }


}
