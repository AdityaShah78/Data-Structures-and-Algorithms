package a1;

import static org.junit.jupiter.api.Assertions.*;

import a1.LargeInt;
import a1.LargeIntInterface;
import org.junit.jupiter.api.Test;

class LargeIntEdgeCaseTest {

    @Test
    void simpleSubtract1() {
        LargeInt a = new LargeInt("0");
        LargeInt b = new LargeInt("0");
        assertEquals("0", a.subtract(b).toString());
        assertEquals("0", b.subtract(a).toString());
    }

    @Test
    void simpleAdd1() {
        LargeInt a = new LargeInt("0");
        LargeInt b = new LargeInt("0");
        assertEquals("0", a.add(b).toString());
        assertEquals("0", b.add(a).toString());
    }

    @Test
    void simpleSubtract2() {
        LargeInt a = new LargeInt("0");
        LargeInt b = new LargeInt("1");
        assertEquals("-1", a.subtract(b).toString());
        assertEquals("1", b.subtract(a).toString());
    }

    @Test
    void simpleAdd2() {
        LargeInt a = new LargeInt("0");
        LargeInt b = new LargeInt("1");
        assertEquals("1", a.add(b).toString());
        assertEquals("1", b.add(a).toString());
    }

    @Test
    void overflow1() {
        LargeInt a = new LargeInt("9");
        LargeInt b = new LargeInt("1");
        assertEquals("10", a.add(b).toString());
        assertEquals("10", b.add(a).toString());
    }

    @Test
    void overflow2() {
        LargeInt a = new LargeInt("999999");
        LargeInt b = new LargeInt("1");
        assertEquals("1000000", a.add(b).toString());
        assertEquals("1000000", b.add(a).toString());
    }

    @Test
    void overflow3() {
        LargeInt a = new LargeInt("10");
        LargeInt b = new LargeInt("1");
        assertEquals("9", a.subtract(b).toString());
        assertEquals("-9", b.subtract(a).toString());
    }

    @Test
    void overflow4() {
        LargeInt a = new LargeInt("1000000");
        LargeInt b = new LargeInt("1");
        assertEquals("999999", a.subtract(b).toString());
        assertEquals("-999999", b.subtract(a).toString());
    }

    @Test
    void sameSignSub1() {
        LargeInt a = new LargeInt("-79797999999999");
        LargeInt b = new LargeInt("-7797797797");
        assertEquals("-79790202202202", a.subtract(b).toString());
        assertEquals("79790202202202", b.subtract(a).toString());
    }

    @Test
    void sameSignSub2() {
        LargeInt a = new LargeInt("553235321");
        LargeInt b = new LargeInt("8891365");
        assertEquals("544343956", a.subtract(b).toString());
        assertEquals("-544343956", b.subtract(a).toString());
    }

    @Test
    void oppositeSignSub1() {
        LargeInt a = new LargeInt("-64543324653");
        LargeInt b = new LargeInt("124569029333234");
        assertEquals("-124633572657887", a.subtract(b).toString());
        assertEquals("124633572657887", b.subtract(a).toString());
    }

    @Test
    void oppositeSignSub2() {
        LargeInt a = new LargeInt("-84555439967993");
        LargeInt b = new LargeInt("8891365");
        assertEquals("-84555448859358", a.subtract(b).toString());
        assertEquals("84555448859358", b.subtract(a).toString());
    }

    @Test
    void sameSignAdd1() {
        LargeInt a = new LargeInt("-2222222334234");
        LargeInt b = new LargeInt("-999999999999");
        assertEquals("-3222222334233", a.add(b).toString());
        assertEquals("-3222222334233", b.add(a).toString());
    }

    @Test
    void sameSignAdd2() {
        LargeInt a = new LargeInt("100234322989284");
        LargeInt b = new LargeInt("69438865");
        assertEquals("100234392428149", a.add(b).toString());
        assertEquals("100234392428149", b.add(a).toString());
    }

    @Test
    void oppositeSignAdd1() {
        LargeInt a = new LargeInt("-9942354234");
        LargeInt b = new LargeInt("124569029333234");
        assertEquals("-124578971687468", a.subtract(b).toString());
        assertEquals("124578971687468", b.subtract(a).toString());
    }

    @Test
    void oppositeSignAdd2() {
        LargeInt a = new LargeInt("-84555439967993");
        LargeInt b = new LargeInt("77773242343324");
        assertEquals("-162328682311317", a.subtract(b).toString());
        assertEquals("162328682311317", b.subtract(a).toString());
    }

    @Test
    void together1() {
        LargeInt a = new LargeInt("-99");
        LargeInt b = new LargeInt("48283");
        LargeInt c = a.add(b);
        LargeInt d = a.add(c);
        LargeInt e = d.subtract(b);
        assertEquals("-198", e.toString());
    }

    @Test
    void together2() {
        LargeInt a = new LargeInt("1000000");
        LargeInt b = new LargeInt("1");
        for(int i = 0; i < 1_000_000; i++) {
            a = a.subtract(b);
        }
        assertEquals("0", a.toString());
    }

    @Test
    void together3() {
        LargeInt a = new LargeInt("0");
        LargeInt b = new LargeInt("1");
        for(int i = 0; i < 1_000_000; i++) {
            a = a.add(b);
        }
        assertEquals("1000000", a.toString());
    }

    @Test
    void mutatedSign1() {
        LargeInt a = new LargeInt("1000");
        LargeInt b = new LargeInt("-44444");
        a.add(b);
        b.add(a);
        assertEquals('-', b.toString().charAt(0));
        assertNotEquals('-', a.toString().charAt(0));
    }

    @Test
    void mutatedSign2() {
        LargeInt a = new LargeInt("-1000");
        LargeInt b = new LargeInt("44444");
        a.subtract(b);
        b.subtract(a);
        assertNotEquals('-', b.toString().charAt(0));
        assertEquals('-', a.toString().charAt(0));

    }

    @Test
    void zeroPadding() {
        LargeInt a = new LargeInt("44444");
        LargeInt b = new LargeInt("44444");
        assertEquals("0", a.subtract(b).toString());
        assertEquals("0", b.subtract(a).toString());

    }

    @Test
    void testLargeIntSum21() {
        String meValue = "123124775857";
        String me2Value = "2317848724782347283472";
        LargeInt me = new LargeInt(meValue);
        LargeInt me2 = new LargeInt(me2Value);
        LargeIntInterface me3 = me.add(me2);
        assertEquals("2317848724905472059329", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(meValue, me.toString().replace("+","").replace(",", ""));
        assertEquals(me2Value, me2.toString().replace("+","").replace(",", ""));
    }

}