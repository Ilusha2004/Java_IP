package cross_cutting.Arifmetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AriphmeticParserTest {

    @Test
    void getResult() {
        String test = "kj7898-sfadhi*jk8.34-45435-23*232.43/4.34";
        AriphmeticParser parser = new AriphmeticParser(test);

        assertEquals(parser.getResult(), 1093134.3565898614);
    }

    @Test
    void getResult2() {
        String test = "23-45";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), -22);
    }

    @Test
    void getResult3() {
        String test = "kaslflkjgasj2asdf*-gd**-dg3---g4-dfsg5-k-fgsfgddj-a---s---ljg";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), -10);
    }

    @Test
    void getResult4() {
        String test = "KH68778.78SGDFHSAJD-ASDF--FSDA-sd798sdaf556/3223423dsafhljfsadfsad89.32/23424-jhfsdakfjsa72384783242.234";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), -7.2384783242234E10);
    }

    @Test
    void getResult5() {
        String test = "sjafhdljashdk89480324/0.9234oqriuoqrw89132h+jds8990.12321/72468723";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), 1.3371663655463972);
    }

    @Test
    void getResult6() {
        String test = "673248-46*34234";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), 2.3046397268E10);
    }

    @Test
    void getResult7() {
        String test = "234/-234";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), 0);
    }

    @Test
    void getResult8() {
        String test = "1*33";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), 33);
    }

    @Test
    void getResult9() {
        String test = "kaslflkjgasj2asdf*-gd**-dg3---g4-dfsg5-k-fgsfgddj-a---s---ljg";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), -10);
    }

    @Test
    void getResult10() {
        String test = "hriqwu7238-jliu7ijhiuh7hihiuh23hiuhi23";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), -765085.0);
    }

    @Test
    void getResult11() {
        String test = "HHIUH79792134998-iufadhiuas098/23423";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), 3406571.954916108);
    }

    @Test
    void getResult12() {
        String test = "jkfasd-890asfd78m9283r9k98u0293r9uk09-23r2i0/234*3242hbjkbhqwekruyubqwr";
        AriphmeticParser parser = new AriphmeticParser(test);
        assertEquals(parser.getResult(), -1.2341619054365861E20);
    }


}