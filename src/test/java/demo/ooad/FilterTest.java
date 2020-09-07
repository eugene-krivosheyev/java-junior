package demo.ooad;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import demo.ooad.filter.ContentLengthLoggerFilter;
import demo.ooad.filter.NullCheckLoggerFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilterTest implements SysoutCaptureAndAssertionAbility  {
    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void shouldCallChildMethodWhenOverriden() {
        NullCheckLoggerFilter filter = new ContentLengthLoggerFilter(4);
        filter.checkNull(new LoggerMessage("", 0));
        assertSysoutContains("WOW!!!!");
    }
}
